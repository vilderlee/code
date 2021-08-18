package com.vilderlee.thread.pipe;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TerminationToken
 *
 * @ClassName TerminationToken
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 5:54 下午
 */

public class TerminationToken {

    /**
     * 无锁请求下当数据修改后其他线程可以读取到，是否停止的标志
     */
    protected volatile boolean toShutdown = false;

    /**
     * 未执行的任务的数量
     */
    public final AtomicInteger reservations = new AtomicInteger(0);

    private final Queue<WeakReference<Termination>> coordinatedThreads = new LinkedList<>();


    public boolean isToShutdown() {
        return toShutdown;
    }

    public void setToShutdown(boolean toShutdown) {
        this.toShutdown = toShutdown;
    }

    public void register(Termination thread) {
        coordinatedThreads.add(new WeakReference<>(thread));
    }

    public void notifyThreadTermination(Termination thread) {
        WeakReference<Termination> wrThread;
        Termination otherThread;

        while ((wrThread = coordinatedThreads.poll()) != null) {
            otherThread = wrThread.get();
            if (otherThread != null && otherThread != thread){
                otherThread.terminate();
            }
        }
    }
}

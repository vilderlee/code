package com.vilderlee.thread.pipe;

/**
 * AbstractTerminationThread
 *
 * @ClassName AbstractTerminationThread
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 6:58 下午
 */

public abstract class AbstractTerminationThread extends Thread implements Termination {

    public final TerminationToken token;

    public AbstractTerminationThread() {
        this(new TerminationToken());
    }


    public AbstractTerminationThread(TerminationToken token) {
        this.token = token;
        System.out.println("注册线程到线程停止的标志实现对象队列中");
        token.register(this);
    }

    @Override
    public void terminate() {
        System.out.println("设置中断标志对象为中断状态");
        this.token.setToShutdown(true);

        try {
            doTerminate();
        } finally {
            if (token.reservations.get() <= 0) {
                super.interrupt();
            }
        }
    }

    protected void doTerminate() {
    }


    @Override
    public void run() {
        Exception ex = null;
        try {
            for (; ; ) {
                if (token.isToShutdown() && token.reservations.get() <= 0) {
                    System.out.println("中断标志位TRUE，未完成的任务为0，线程退出");
                    break;
                }
                doRun();
            }

        } catch (Exception e) {
            ex = e;
            if (e instanceof InterruptedException) {
                System.out.println("中断相应:" + e);
            }
        } finally {
            try {
                System.out.println("线程停止，回调终止后的清理工作");
                doClean(ex);
            } finally {
                System.out.println("标志实例对象中一个线程终止，通知其他线程终止");
                token.notifyThreadTermination(this);
            }
        }
    }

    protected abstract void doClean(Exception ex);

    protected abstract void doRun();

}
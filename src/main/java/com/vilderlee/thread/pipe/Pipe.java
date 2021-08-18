package com.vilderlee.thread.pipe;

import java.util.concurrent.TimeUnit;

/**
 * Pipe
 *
 * @ClassName Pipe
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 5:01 下午
 */

public interface Pipe<IN, OUT> {


    /**
     * 设置当前Pipe实例的下一个Pipe实例
     *
     * @param nextPipe
     */
    void setNextPipe(Pipe<?, ?> nextPipe);


    /**
     * 初始化当前pipe实例对外提供的服务
     *
     * @param pipeContext
     */
    void init(PipeContext pipeContext);


    /**
     * 终止当前的Pipe实例对外提供的服务
     *
     * @param timeout
     * @param unit
     */
    void shutdown(long timeout, TimeUnit unit);

    /**
     * 对输入元素进行处理，并将处理结果作为下一个pipe实例输入
     *
     * @param input
     * @throws InterruptedException
     */
    void process(IN input) throws InterruptedException;
}

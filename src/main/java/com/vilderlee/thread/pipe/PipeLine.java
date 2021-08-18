package com.vilderlee.thread.pipe;

/**
 * PipeLine
 *
 * @ClassName PipeLine
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 5:07 下午
 */

public interface PipeLine<IN, OUT> extends Pipe<IN, OUT> {


    /**
     * 往PipeLine添加一个pipe实例
     *
     * @param pipe
     */
    void addPipe(Pipe<?, ?> pipe);
}

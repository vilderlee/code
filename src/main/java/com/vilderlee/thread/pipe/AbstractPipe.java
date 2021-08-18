package com.vilderlee.thread.pipe;

import java.util.concurrent.TimeUnit;

/**
 * AbstractPipe
 *
 * @ClassName AbstractPipe
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 5:09 下午
 */

public abstract class AbstractPipe<IN, OUT> implements Pipe<IN, OUT> {


    protected volatile Pipe<?, ?> nextPipe = null;

    protected volatile PipeContext pipeContext;


    @Override
    public void init(PipeContext pipeContext) {
        this.pipeContext = pipeContext;
    }

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        this.nextPipe = nextPipe;
    }


    @Override
    public void shutdown(long timeout, TimeUnit unit) {

    }

    @Override
    public void process(IN input) throws InterruptedException {
        try {
            OUT out = doProcess(input);
            if (null != nextPipe) {
                if (null != out) {
                    ((Pipe<OUT, ?>) nextPipe).process(out);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (RuntimeException e1) {
            pipeContext.handleError(e1);
        }
    }

    protected abstract OUT doProcess(IN input);
}

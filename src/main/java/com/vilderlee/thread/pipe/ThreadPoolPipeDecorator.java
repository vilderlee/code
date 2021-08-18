package com.vilderlee.thread.pipe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolPipeDecorator
 *
 * @ClassName ThreadPoolPipeDecorator
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 6:10 下午
 */

public class ThreadPoolPipeDecorator<IN, OUT> implements Pipe<IN, OUT> {

    private Pipe<IN, OUT> delegate;

    private CustomTerminationToken customTerminationToken;

    private ExecutorService executorService;

    private CountDownLatch stageProcessDoneLatch = new CountDownLatch(1);

    @Override
    public void setNextPipe(Pipe<?, ?> nextPipe) {
        delegate.setNextPipe(nextPipe);
    }

    @Override
    public void init(PipeContext pipeContext) {
        delegate.init(pipeContext);
    }

    @Override
    public void shutdown(long timeout, TimeUnit unit) {
        customTerminationToken.setToShutdown();
        if (customTerminationToken.reservations.get() > 0) {
            if (stageProcessDoneLatch.getCount() > 0) {
                try {
                    stageProcessDoneLatch.await(timeout, unit);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        delegate.shutdown(timeout, unit);
    }

    @Override
    public void process(IN input) throws InterruptedException {
        Runnable task = () -> {
            int remainingReservations = -1;
            try {
                delegate.process(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                remainingReservations = customTerminationToken.reservations.decrementAndGet();
            }

            if (customTerminationToken.isToShutdown() && 0 == remainingReservations) {
                stageProcessDoneLatch.countDown();
            }
        };

        executorService.submit(task);

        customTerminationToken.reservations.incrementAndGet();
    }
}

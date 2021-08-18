package com.vilderlee.thread.pipe;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * AbstractParallelPipe
 *
 * @ClassName AbstractParallelPipe
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 5:24 下午
 */

public abstract class AbstractParallelPipe<IN, OUT, V> extends AbstractPipe<IN, OUT> {

    private final ExecutorService executorService;

    public AbstractParallelPipe(BlockingQueue<IN> queue, ExecutorService executorService) {
        super();
        this.executorService = executorService;
    }

    /**
     * 留个子类实现，用于指定输入的元素构成一组子任务
     *
     * @param input
     * @return
     * @throws Exception
     */
    protected abstract List<Callable<V>> buildTasks(IN input) throws Exception;


    /**
     * 留个子类实现，对于各子任务处理结果进行合并，形成相应输入元素的输出结果
     *
     * @param subTaskResults
     * @return
     * @throws Exception
     */
    protected abstract OUT combineResults(List<Future<V>> subTaskResults) throws Exception;


    protected List<Future<V>> invokeParallel(List<Callable<V>> tasks) throws Exception {
        return executorService.invokeAll(tasks);
    }


    @Override
    protected OUT doProcess(IN input) {
        OUT out = null;
        try {
            out = combineResults(invokeParallel(buildTasks(input)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}

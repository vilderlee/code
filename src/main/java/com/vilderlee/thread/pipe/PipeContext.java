package com.vilderlee.thread.pipe;

/**
 * PipeContext
 *
 * @ClassName PipeContext
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 5:03 下午
 */

public interface PipeContext {

    void handleError(RuntimeException exception);
}

package com.vilderlee.thread.pipe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

/**
 * CustomTerminationToken
 *
 * @ClassName CustomTerminationToken
 * @Description
 * @Author VilderLee
 * @Date 2021/8/14 6:02 下午
 */

public class CustomTerminationToken extends TerminationToken {

    private final static ConcurrentMap<ExecutorService, CustomTerminationToken>
            INSTANCES_MAP = new ConcurrentHashMap<>();

    private CustomTerminationToken() {
    }

    public void setToShutdown() {
        this.toShutdown = true;
    }


    static CustomTerminationToken newInstance(ExecutorService executorService) {
        CustomTerminationToken token = INSTANCES_MAP.get(executorService);
        if (null == token) {
            token = new CustomTerminationToken();
            CustomTerminationToken existingToken = INSTANCES_MAP.putIfAbsent(executorService, token);
            if (null != existingToken) {
                token = existingToken;
            }
        }
        return token;
    }
}

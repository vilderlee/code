package com.study.mq.rabbitmq.connect;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class Message {
    private Long deliverTag;
    private Object object;

    public Long getDeliverTag() {
        return deliverTag;
    }

    public void setDeliverTag(Long deliverTag) {
        this.deliverTag = deliverTag;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

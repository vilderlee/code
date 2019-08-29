package com.study.spring.demo;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/26      Create this file
 * </pre>
 */
public abstract class AbstractTemplate {
    protected int step;
    private AbstractTemplate nextService;

    protected void doBusiness(int step, String message) throws Exception {
        if (this.step == step) {
            doIt(message);
            step += 1;
            if (nextService != null) {
                nextService.doBusiness(step, message);
            }
        } else {
            if (nextService != null) {
                nextService.doBusiness(step, message);
            }
        }
    }

    protected abstract void doIt(String message);

    public void setStep(int step) {
        this.step = step;
    }

    public void setNextService(AbstractTemplate nextService) {
        this.nextService = nextService;
    }
}

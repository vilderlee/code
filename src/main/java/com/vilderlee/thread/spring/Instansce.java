package com.vilderlee.thread.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/7      Create this file
 * </pre>
 */

@Component
@Scope(SCOPE_PROTOTYPE)
public class Instansce {

    private Process process;

    public void process(Process process){
        this.process = process;

        Task task = getValue();
//        System.out.println(task.toString());
        System.out.println("process" + process.getNum() +  ";Instance:" + task.toString() + this + "--------" + this.process.toString());

    }


    private Task getValue() {
        Task task = new Task();
        task.setName("23423424");
        task.setNum(process.getNum());
        return task;
    }

}

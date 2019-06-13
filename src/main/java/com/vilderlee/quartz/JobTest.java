package com.vilderlee.quartz;

import com.vilderlee.quartz.command.AbstractCommand;
import com.vilderlee.quartz.entity.ProcessControl;
import com.vilderlee.quartz.mapper.ProcessControlDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/19      Create this file
 * </pre>
 */
public class JobTest implements Job {
    @Override public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        AbstractCommand command = (AbstractCommand) Environment.context.getBean("check");
        ProcessControlDao dao = (ProcessControlDao) Environment.context.getBean("processControlDao");
        Map map = new HashMap();
        map.put("depositMode", "10");
        map.put("institutionID", "000020");
        ProcessControl processControl = dao.getProcessControlByMap(map);
        //        command.execute(processControl.getStep());
        Task task = new Task(processControl);
        new Thread(task, "test1").start();
    }

    class Task implements Runnable {

        private ProcessControl processControl;
        private volatile Object monitor = new Object();

        public Task(ProcessControl processControl) {
            this.processControl = processControl;
        }

        @Override public void run() {

            DoTask.doTask();
        }


    }

    static class DoTask{
        private static synchronized  void doTask() {
            System.out.println("&&&&&&&&&&&&&&");
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

package com.vilderlee.quartz;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/19      Create this file
 * </pre>
 */
public class QuartzTest {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            for (int i = 0; i < 2; i++) {
                JobDetailImpl jobDetail = new JobDetailImpl();
                jobDetail.setName("job" + i);
                jobDetail.setGroup("jobGroup" + i);
                jobDetail.setKey(new JobKey(jobDetail.getName(), jobDetail.getGroup()));
                jobDetail.setJobClass(JobTest.class);
                CronExpression cronExpression = new CronExpression("0 0/1 * * * ?");
                CronTriggerImpl cronTrigger = new CronTriggerImpl();
                cronTrigger.setName("cronTrigger" + i);
                cronTrigger.setCronExpression(cronExpression);
                scheduler.scheduleJob(jobDetail, cronTrigger);
            }

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

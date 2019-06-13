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
public class QuartzTest {

    public static void main(String[] args) {
        Environment.init();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetailImpl jobDetail = new JobDetailImpl();
            jobDetail.setName("job");
            jobDetail.setGroup("jobGroup");
            jobDetail.setKey(new JobKey(jobDetail.getName(), jobDetail.getGroup()));
            jobDetail.setJobClass(JobTest.class);

            Map map = new HashMap(1);
            map.put("command", "1101");
            JobDataMap jobDataMap = new JobDataMap(map);
            jobDetail.setJobDataMap(jobDataMap);
            CronExpression cronExpression = new CronExpression("0/5 * * * * ?");
            CronTriggerImpl cronTrigger = new CronTriggerImpl();
            cronTrigger.setName("cronTrigger");
            cronTrigger.setCronExpression(cronExpression);
            scheduler.scheduleJob(jobDetail, cronTrigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}

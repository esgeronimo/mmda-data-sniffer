package com.eugenegeronimo.mmda.mmdadatasniffer.impl.trafficreport.quartz;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.Task;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.TaskScheduler;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrafficReportTaskScheduler implements TaskScheduler {

    private static final String JOB_DATA_MAP_KEY_TASK = "trafficReportTask";

    private static final Logger log = LoggerFactory.getLogger(TrafficReportTaskScheduler.class);

    @Value("${task.scheduled.enable}")
    private boolean isEnabled;

    @Override
    public void start(Task task) {
        JobDataMap map = new JobDataMap();
        map.put(JOB_DATA_MAP_KEY_TASK, task);

        JobDetail jobDetail = JobBuilder.newJob(TaskJob.class)
                .usingJobData(map)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)) // Leave this simple implementation for now
                .build();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
           log.error(e.getMessage(), e);
        }

    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public static class TaskJob implements Job {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            if (context.getJobDetail() == null
                    || context.getJobDetail().getJobDataMap() == null
                    || context.getJobDetail().getJobDataMap().isEmpty()
                    || context.getJobDetail().getJobDataMap().get(JOB_DATA_MAP_KEY_TASK) == null) {
                log.info("No task found to be executed.");
                return;
            }
            log.info("Executing traffic report task...");
            Task task = (Task) context.getJobDetail().getJobDataMap().get(JOB_DATA_MAP_KEY_TASK);
            task.execute();
        }
    }
}

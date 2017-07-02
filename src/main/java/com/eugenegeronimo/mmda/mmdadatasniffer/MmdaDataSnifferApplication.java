package com.eugenegeronimo.mmda.mmdadatasniffer;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReportTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MmdaDataSnifferApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MmdaDataSnifferApplication.class);

	@Autowired
	private TrafficReportTask trafficReportTask;

	@Value("${task.scheduled.enable}")
	private boolean isScheduledTask;

	public static void main(String[] args) {
		SpringApplication.run(MmdaDataSnifferApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (!isScheduledTask) {
			log.info("Task is not scheduled and will only execute one-time.");
			trafficReportTask.getAndSave();
		}
	}
}

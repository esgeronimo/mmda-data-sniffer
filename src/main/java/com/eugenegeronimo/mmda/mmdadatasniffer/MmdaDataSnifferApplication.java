package com.eugenegeronimo.mmda.mmdadatasniffer;

import com.eugenegeronimo.mmda.mmdadatasniffer.core.base.TaskScheduler;
import com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReportTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MmdaDataSnifferApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MmdaDataSnifferApplication.class);

	@Autowired
	private TaskScheduler trafficPointTaskScheduler;

	@Autowired
	private TrafficReportTask trafficReportTask;

	public static void main(String[] args) {
		SpringApplication.run(MmdaDataSnifferApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (trafficPointTaskScheduler.isEnabled()) {
			trafficPointTaskScheduler.start(trafficReportTask);
		} else {
			trafficReportTask.execute();
		}
	}
}

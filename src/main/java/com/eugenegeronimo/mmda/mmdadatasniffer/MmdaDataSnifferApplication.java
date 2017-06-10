package com.eugenegeronimo.mmda.mmdadatasniffer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MmdaDataSnifferApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmdaDataSnifferApplication.class, args);
	}
}

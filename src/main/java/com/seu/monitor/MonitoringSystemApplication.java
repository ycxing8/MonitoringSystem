package com.seu.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.seu.monitor.socket.*;

@SpringBootApplication
public class MonitoringSystemApplication {

	public static void main(String[] args) {
		StartSocketServer.start();
		SpringApplication.run(MonitoringSystemApplication.class, args);
	}
}

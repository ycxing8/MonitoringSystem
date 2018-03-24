package com.bob.test_my_sql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.bob.test_my_sql.socket.*;

@SpringBootApplication
public class TestMySqlApplication {

	public static void main(String[] args) {
		StartSocketServer.start();
		SpringApplication.run(TestMySqlApplication.class, args);
	}
}

package com.rad.kit.dsappsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DsAppSvcConfig.class)
public class DsAppSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsAppSvcApplication.class, args);
	}

}

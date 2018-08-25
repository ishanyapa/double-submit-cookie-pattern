package me.ishanyapa.dscp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:WebContentInterceptor.xml")
public class DscpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DscpApplication.class, args);
	}
}

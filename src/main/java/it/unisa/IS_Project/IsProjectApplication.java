package it.unisa.IS_Project;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class IsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsProjectApplication.class, args);
	}
}

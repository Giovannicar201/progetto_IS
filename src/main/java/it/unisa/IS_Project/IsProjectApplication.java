package it.unisa.IS_Project;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsProjectApplication.class, args);
	}
}

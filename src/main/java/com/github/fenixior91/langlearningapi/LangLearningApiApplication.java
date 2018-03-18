package com.github.fenixior91.langlearningapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LangLearningApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangLearningApiApplication.class, args);
	}
}

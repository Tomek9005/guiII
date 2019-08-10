package com.sda.gui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GuiApplication {

	public static void main(String[] args) {

		SpringApplication.run(GuiApplication.class, args);
	}


	@Bean
	RestTemplate restTemplate() {
		return new RestTemplateBuilder().build();

	}
}


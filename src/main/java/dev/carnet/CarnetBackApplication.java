package dev.carnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:application.properties")
public class CarnetBackApplication {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedMethods("GET", "POST", "PATCH", "PUT", "OPTIONS", "DELETE").allowCredentials(true);
				;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CarnetBackApplication.class, args);

	}

}

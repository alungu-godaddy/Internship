package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Function<String, String> toUpperCase() {
		return (value) -> value.toUpperCase();
	}

	@Bean
	public Supplier<String> getMessage() {
		return () -> "Welcome to Daily Code Buffer";
	}

	@Bean
	public Consumer<String> writeMessage() {
		return (value) -> System.out.println(value);
	}

}

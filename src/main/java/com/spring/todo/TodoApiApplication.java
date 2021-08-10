package com.spring.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.todo.domain.Todo;

@SpringBootApplication
public class TodoApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo t1 = new Todo(null,"Estudar","Estudar Spring Boot 2 e Angular 11", LocalDateTime.parse("09/08/2021 23:47", formatter), false);
		
	
	}

}

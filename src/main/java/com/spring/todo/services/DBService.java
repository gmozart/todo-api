package com.spring.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.todo.domain.Todo;
import com.spring.todo.repositories.TodoRepository;


public class DBService {
	
	@Autowired
	private TodoRepository TodoRepo;
	
	public void instnaciaBaseDeDados(){

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				LocalDateTime.parse("09/08/2021 23:47", formatter), false);

		TodoRepo.saveAll(Arrays.asList(t1));

	}
	
	

}

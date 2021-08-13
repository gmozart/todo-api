package com.spring.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.domain.Todo;
import com.spring.todo.repositories.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	private TodoRepository TodoRepo;
	
	public void instanciaBaseDeDados(){

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				LocalDateTime.parse("09/08/2021 23:47", formatter), false);
		Todo t2 = new Todo(null, "Ler", "Livro de Desenvolvimento Pessoal",
				LocalDateTime.parse("12/08/2021 23:47", formatter), true);
		Todo t3 = new Todo(null, "Exercicios", "Práticar Exércicios Físicos",
				LocalDateTime.parse("15/08/2021 23:47", formatter), false);
		Todo t4 = new Todo(null, "Meditar", "Sobre ás Escrituras",
				LocalDateTime.parse("20/08/2021 23:47", formatter), true);

		TodoRepo.saveAll(Arrays.asList(t1,t2,t3,t4));

	}
	
	

}

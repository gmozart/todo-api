package com.spring.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.domain.Todo;
import com.spring.todo.repositories.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	private TodoRepository TodoRepo;
	
	public void instanciaBaseDeDados() throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11",
				sdf.parse("09/08/2021"), false);
		Todo t2 = new Todo(null, "Ler", "Livro de Desenvolvimento Pessoal",
				sdf.parse("12/08/2021"), true);
		Todo t3 = new Todo(null, "Exercicios", "Práticar Exércicios Físicos",
				sdf.parse("15/08/2021"), false);
		Todo t4 = new Todo(null, "Meditar", "Sobre ás Escrituras",
				sdf.parse("20/08/2021"), true);

		TodoRepo.saveAll(Arrays.asList(t1,t2,t3,t4));

	}
	
	

}

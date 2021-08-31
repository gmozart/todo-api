package com.spring.todo.services;

import java.time.LocalDate;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.domain.Todo;
import com.spring.todo.repository.TodoRepository;

@Service
public class DBService {
	
	@Autowired
	private TodoRepository TodoRepo;
	
	public void instanciaBaseDeDados(){

		
		Todo t1 = new Todo();
		
		t1.setDataParaFinalizar(LocalDate.of(2020, 12, 21));
		t1.setDescricao("Angular Básico");
		t1.setFinalizado(false);
		t1.setTitulo("Angular");
		
        Todo t2 = new Todo();
		
		t2.setDataParaFinalizar(LocalDate.of(2020, 12, 21));
		t2.setDescricao("Spring Básico");
		t2.setFinalizado(true);
		t2.setTitulo("Spring");
		
		
		TodoRepo.saveAll(Arrays.asList(t1,t2));

	}
	
	

}

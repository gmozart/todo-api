package com.spring.todo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.todo.services.TodoService;



@Configuration
@Profile("teste")
public class TestConfig {
	
	@Autowired
	private TodoService  tdService;
	
	
	public boolean instancia() {
		
		this.tdService.instnaciaBaseDeDados();
		
		return true;
		                                       
	}

}

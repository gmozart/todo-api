package com.spring.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.domain.Todo;
import com.spring.todo.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository TodoRepo;

	
	
	public Todo findByid(Integer id) {
		
	Optional<Todo> obj = TodoRepo.findById(id);
	
	 return obj.orElse(null);
	}
	
	public List<Todo> findAll(){
		
	 return TodoRepo.findAll();
	}

}

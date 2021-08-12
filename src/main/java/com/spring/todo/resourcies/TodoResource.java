package com.spring.todo.resourcies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.todo.domain.Todo;
import com.spring.todo.services.TodoService;

@RestController
@RequestMapping(value ="/todos")
public class TodoResource {
	
	@Autowired
	private TodoService tdService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findByid(@PathVariable Integer id){
		
	    Todo objTodo = tdService.findByid(id);
		
		return ResponseEntity.ok().body(objTodo);
	}

}

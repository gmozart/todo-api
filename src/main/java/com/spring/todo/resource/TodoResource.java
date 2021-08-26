package com.spring.todo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.spring.todo.domain.Todo;
import com.spring.todo.services.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "TODO")
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@Autowired
	private TodoService tdService;
    
	@ApiOperation(notes = "Essa API retorna um TODO por ID", value = "GET por ID")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findByid(@PathVariable Integer id) {

		Todo objTodo = tdService.findByid(id);

		return ResponseEntity.ok().body(objTodo);
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen() {

		List<Todo> list = tdService.findAllOpen();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/close")
	public ResponseEntity<List<Todo>> listClose() {

		List<Todo> list = tdService.findAllClose();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/listAll")
	public ResponseEntity<List<Todo>> listAll() {

		List<Todo> list = tdService.findAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo obj) {

		obj = tdService.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Todo> delete(@PathVariable Integer id) {

		Todo objTodo = tdService.findByid(id);

		tdService.delete(id);

		return ResponseEntity.ok().body(objTodo);

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo obj){
		

		Todo newObj = tdService.update(id, obj);

		return ResponseEntity.ok().body(newObj);
	}

}

package com.spring.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.domain.Todo;
import com.spring.todo.repositories.TodoRepository;
import com.spring.todo.services.exceptions.ObjectNotFoundException;


@Service
public class TodoService {

	@Autowired
	private TodoRepository TodoRepo;

	
	
	public Todo findByid(Integer id) {
		
	Optional<Todo> obj = TodoRepo.findById(id);
	
	 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado! " + id +", Tipo: "+ Todo.class.getName(), null));
	}
	
	public Todo update(Integer id, Todo todo) {
		
		Todo tdObj = findByid(id);
		
		tdObj.setTitulo(todo.getTitulo());
		tdObj.setDescricao(todo.getDescricao());
		tdObj.setFinalizado(todo.getFinalizado());
		tdObj.setDataParaFinalizar(todo.getDataParaFinalizar());
		
		return TodoRepo.save(tdObj);
	}
	
	public void delete(Integer id) {
		
		findByid(id);
		TodoRepo.deleteById(id);
		
	}
	
	public Todo create(Todo todo) {
		todo.setId(null);
		return TodoRepo.save(todo);
	}

	public List<Todo> findAllOpen() {
		
		List<Todo> list = TodoRepo.findAllOpen();
		
		return list;
	}

	public List<Todo> findAllClose() {
		
        List<Todo> list = TodoRepo.findAllClose();
		
		return list;
	}

	public List<Todo> findAll() {
		
		  List<Todo> list = TodoRepo.findAll();
			
			return list;
	}
	
	
}

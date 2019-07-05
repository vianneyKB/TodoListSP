/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vianney.todolist.service.impl;

import java.util.List;
import com.vianney.todo.Todo;
import org.springframework.stereotype.Service;
import com.vianney.todolist.service.TodoService;
import com.vianney.todolist.repository.TodoRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MISHIKO
 */
@Service
@Transactional
public class TodoServiceImpl implements TodoService
{
    @Autowired private TodoRepository todorepository;
    @Override
    public List<Todo> getAllTodos() 
    {
        return (List<Todo>) todorepository.findAll();
        //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Todo save(Todo todo) 
    {
        todo.setDuedate(new Date());
        return todorepository.save(todo);
    }
    @Override
    public Todo findBy(Long Id) 
    {
        Optional<Todo> todo = todorepository.findById(Id);
        if (todo.isPresent()) 
        {
          return todo.get();
        }
        else
        {
            return null;
        }
    }
    @Override
    public Todo update(Todo todo) 
    {
        todo.setUpdateDate(new Date());
        return todorepository.save(todo);
    }
	@Override
	public void delete(Long id) 
	{
		todorepository.deleteById(id);
		
	}
}
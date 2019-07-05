/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vianney.todolist.service;

import com.vianney.todo.Todo;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author MISHIKO
 */
@Service
public interface TodoService 
{
    public List<Todo> getAllTodos();
    public Todo save(Todo todo);
    public Todo findBy(Long Id);
    public Todo update(Todo todo);
	public void delete(Long id);
}

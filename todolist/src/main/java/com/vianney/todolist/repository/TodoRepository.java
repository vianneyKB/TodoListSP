/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vianney.todolist.repository;

import com.vianney.todo.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MISHIKO
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>
{
    
}

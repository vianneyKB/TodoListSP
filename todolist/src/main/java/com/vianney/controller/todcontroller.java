/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vianney.controller;

import com.vianney.todo.Todo;
import com.vianney.todolist.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author MISHIKO
 */

@Controller
public class todcontroller
{
    @Autowired private TodoService todoservice;
    
    @GetMapping("/")
    public String Todo(Model model)
    {
        List<Todo> todoss = todoservice.getAllTodos();
        model.addAttribute("todos", todoss);
        model.addAttribute("todo", new Todo());
        model.addAttribute("title","todos");
        model.addAttribute("isAdd", true);
        return "view/todos";
    }
    @PostMapping(value="/save")
    public String save(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes, Model model) 
    {
        Todo dbTodo = todoservice.save(todo);
        if (dbTodo!=null) 
        {
            redirectAttributes.addFlashAttribute("SuccessMessage", "A Todo was added ");
            return "redirect:/";
        }
        else
        {
            model.addAttribute("ErrorMessage", "Nothing was added, Please try again");
            model.addAttribute("todo", todo);
        return "view/todos";
        }
    }
    @GetMapping(value="/getTodo/{Id}")
    public  String getTodo(@PathVariable Long Id, Model model)
    {
        Todo todo = todoservice.findBy(Id);
        List<Todo> todoss = todoservice.getAllTodos();
        model.addAttribute("todos", todoss);
        model.addAttribute("todo", todo);
        model.addAttribute("title","Edit todos");
        model.addAttribute("isAdd", false);
        return "view/todos";
    }
    
    @PostMapping(value="/update")
    public String update(@ModelAttribute Todo todo, RedirectAttributes redirectAttributes, Model model) 
    {
        Todo dbTodo = todoservice.update(todo);
        if (dbTodo!=null) 
        {
            redirectAttributes.addFlashAttribute("SuccessMessage", "A Todo was updated ");
            return "redirect:/";
        }
        else
        {
            model.addAttribute("ErrorMessage", "Nothing was updated, Please try again");
            model.addAttribute("todo", todo);
        return "view/todos";
        }
    }    
    
    @GetMapping(value = "deletetodo/{Id}")
    
    public String deletetodo(@PathVariable Long Id, RedirectAttributes redirectAttributes) 
    {
    	todoservice.delete(Id);
        redirectAttributes.addFlashAttribute("SuccessMessage", "A Todo was Deleted ");
        return "redirect:/";
    }
    
}

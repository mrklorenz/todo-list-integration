package com.example.controller;

import com.example.model.Todo;
import com.example.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
}

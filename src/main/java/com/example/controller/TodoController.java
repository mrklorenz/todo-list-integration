package com.example.controller;

import com.example.model.Todo;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addToDo(todo);
    }

    @PutMapping(path = "/{todoId}")
    public Todo updateTodo(@PathVariable int todoId, @RequestBody Todo todoDetails){
        return todoService.updateTodo(todoId, todoDetails);
    }
}

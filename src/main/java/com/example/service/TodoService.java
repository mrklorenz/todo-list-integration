package com.example.service;

import com.example.model.Todo;
import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo addToDo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(int todoId, Todo todoDetails){
        Todo updatedTodo =  todoRepository.findById(todoId)
                .map(todo -> updateTodoIsDone(todo, todoDetails))
                .get();

        return todoRepository.save(updatedTodo);
    }

    public void deleteTodo(int todoId){
        todoRepository.deleteById(todoId);
    }

    public Todo updateTodoIsDone(Todo todo, Todo todoDetails){
        if(todo.isDone() != todoDetails.isDone()){
            todo.setDone(todoDetails.isDone());
        }
        return todo;
    }
}

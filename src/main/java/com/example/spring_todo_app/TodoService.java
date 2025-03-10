package com.example.spring_todo_app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // Get all todos
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // Add a new todo
    public Todo addTodo(String title, String content, Long userId) {
        Todo todo = new Todo(title, content, userId);
        return todoRepository.save(todo);
    }

    // Update a todo
    public Todo updateTodo(Long id, String title, String content, Long userId) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setTitle(title);
            todo.setContent(content);
            todo.setUserId(userId);
            return todoRepository.save(todo);
        }
        return null; // veya bir exception fırlatabilirsiniz
    }

    // Delete a todo by id
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // Get a todo by id
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }
}
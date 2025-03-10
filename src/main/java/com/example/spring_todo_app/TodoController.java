package com.example.spring_todo_app;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@Tag(name = "Todo API", description = "API for managing todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Operation(summary = "Get all todos")
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Operation(summary = "Add a new todo")
    @PostMapping
    public Todo addTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.addTodo(todoRequest.getTitle(), todoRequest.getContent(), todoRequest.getUserId());
    }

    @Operation(summary = "Update an existing todo")
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        return todoService.updateTodo(id, todoRequest.getTitle(), todoRequest.getContent(), todoRequest.getUserId());
    }

    @Operation(summary = "Delete a todo by ID")
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @Operation(summary = "Get a todo by ID")
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }
}

// Request body için yardımcı sınıf
class TodoRequest {
    private String title;
    private String content;
    private Long userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
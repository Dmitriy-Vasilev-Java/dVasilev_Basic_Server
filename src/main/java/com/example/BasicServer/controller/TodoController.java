package com.example.BasicServer.controller;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.DeleteTodoDto;
import com.example.BasicServer.dto.request.GetPaginatedTodoDto;
import com.example.BasicServer.dto.request.PatchTodoDto;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>> getPaginated(@Valid GetPaginatedTodoDto todoDto) {
        return ResponseEntity.ok(todoService.getPaginated(todoDto));
    }

    @PostMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>> create(@Valid CreateTodoDto todoDto) {
        return ResponseEntity.ok(todoService.create(todoDto));
    }

    @DeleteMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>>  deleteAllReady(@Valid CreateTodoDto todoDto) {
        return ResponseEntity.ok(todoService.deleteAllReady(todoDto));
    }

    @PatchMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>> patch(@Valid CreateTodoDto todoDto) {
        return ResponseEntity.ok(todoService.patch(todoDto));
    }

    //@RequestMapping("/v1/todo/{id}")

    @DeleteMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>> delete(@Valid CreateTodoDto todoDto) {
        return ResponseEntity.ok(todoService.delete(todoDto));
    }

    //@PatchMapping
    //@PatchMapping

}

//Логика перехвата методов (запросов по определенным эедпоинтам)
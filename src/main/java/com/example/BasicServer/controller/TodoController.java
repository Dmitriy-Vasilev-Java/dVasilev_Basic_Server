package com.example.BasicServer.controller;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.DeleteAllReadyTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.service.impl.TodoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/todo/")
@RequiredArgsConstructor
@Validated
public class TodoController {

    private final TodoServiceImpl todoService;

//      @GetMapping
//    public ResponseEntity<CustomSuccessResponse<TodoEntity>> getPaginated(@Valid GetPaginatedTodoDto todoDto) {
//        return ResponseEntity.ok(todoService.getPaginated(todoDto));
//    }

    @PostMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>> createTask(@Valid @RequestBody CreateTodoDto todoDto) {
        return ResponseEntity.ok(todoService.createTask(todoDto));
    }

    @DeleteMapping
    public ResponseEntity<BaseSuccessResponse<TodoEntity>>
    deleteAllReady(@Valid @RequestBody DeleteAllReadyTodoDto todoDto) {
        return ResponseEntity.ok(todoService.deleteAllReady(todoDto));
    }

//    @PatchMapping
//    public ResponseEntity<CustomSuccessResponse<TodoEntity>> patch(@Valid CreateTodoDto todoDto) {
//        return ResponseEntity.ok(todoService.patch(todoDto));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<CustomSuccessResponse<TodoEntity>> delete(@Valid CreateTodoDto todoDto) {
//        return ResponseEntity.ok(todoService.delete(todoDto));
//    }
//
//    @PatchMapping("/status/{id}")
//    public ResponseEntity<CustomSuccessResponse<TodoEntity>> patchStatus(@Valid CreateTodoDto todoDto) {
//        return ResponseEntity.ok((todoService.patchStatus(todoDto)));
//    }
//
//    @PatchMapping("/text/{id}")

}

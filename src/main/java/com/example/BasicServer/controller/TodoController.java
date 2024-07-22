package com.example.BasicServer.controller;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.PatchTextTodoDto;
import com.example.BasicServer.dto.request.PatchTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.dto.response.GetNewsDto;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.service.impl.TodoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/todo")
@RequiredArgsConstructor
@Validated
public class TodoController {

    private final TodoServiceImpl todoService;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<GetNewsDto<List<TodoEntity>>>> getPaginatedTodos(
            @RequestParam @Max(100) @Min(1) Integer page,
            @RequestParam @Min(1) Integer perPage,
            @RequestParam(required = false) Boolean status) {
        return ResponseEntity.ok(todoService.getPaginated(page, perPage, status));
    }

    @PostMapping
    public ResponseEntity<CustomSuccessResponse<TodoEntity>> createTask(@Valid @RequestBody CreateTodoDto todoDto) {
        return ResponseEntity.ok(todoService.createTask(todoDto));
    }

    @DeleteMapping
    public ResponseEntity<BaseSuccessResponse> deleteAllReady() {
        return ResponseEntity.ok(todoService.deleteAllReady());
    }

    @PatchMapping
    public ResponseEntity<BaseSuccessResponse> patchStatus(@Valid @RequestBody PatchTodoDto patchTodoDto ) {
        return ResponseEntity.ok(todoService.changeStatus(patchTodoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseSuccessResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.deleteById(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<BaseSuccessResponse> patchStatusId
            (@Valid
             @RequestBody PatchTodoDto patchTodoDto,
             @PathVariable Long id) {
        return ResponseEntity.ok(todoService.changeStatusById(id, patchTodoDto));
    }

    @PatchMapping("/text/{id}")
    public ResponseEntity<BaseSuccessResponse> patchStatusText
            (@PathVariable String text, PatchTextTodoDto patchTextTodoDto) {
        return ResponseEntity.ok((todoService.changeStatusByText(text, patchTextTodoDto)));
    }

}

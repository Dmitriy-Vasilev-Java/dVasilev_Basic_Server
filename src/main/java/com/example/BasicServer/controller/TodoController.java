package com.example.BasicServer.controller;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.PatchTextTodoDto;
import com.example.BasicServer.dto.request.PatchTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.dto.response.GetNewsDto;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.error.ValidationConstants;
import com.example.BasicServer.service.impl.TodoServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/todo")
@RequiredArgsConstructor
@Validated
public class TodoController {

    private final TodoServiceImpl todoService;

    @GetMapping
    public ResponseEntity<CustomSuccessResponse<GetNewsDto<List<TodoEntity>>>> getPaginatedTodos(
            @RequestParam
            @Min(value = 1, message = ValidationConstants.TASKS_PAGE_GREATER_OR_EQUAL_1) Integer page,
            @RequestParam
            @Max(value = 100, message = ValidationConstants.TASKS_PER_PAGE_LESS_OR_EQUAL_100)
            @Min(value = 1, message = ValidationConstants.TASKS_PER_PAGE_GREATER_OR_EQUAL_1)
            Integer perPage,
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
    public ResponseEntity<BaseSuccessResponse> patchStatus(@Valid @RequestBody PatchTodoDto patchTodoDto) {
        return ResponseEntity.ok(todoService.changeStatus(patchTodoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseSuccessResponse> deleteById(
            @PathVariable
            @Positive(message = ValidationConstants.ID_MUST_BE_POSITIVE) Long id) {
        return ResponseEntity.ok(todoService.deleteById(id));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<BaseSuccessResponse> patchStatusId(
            @Valid
            @RequestBody PatchTodoDto patchTodoDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(todoService.changeStatusById(id, patchTodoDto));
    }

    @PatchMapping("/text/{id}")
    public ResponseEntity<BaseSuccessResponse> patchStatusText
            (@Valid
             @RequestBody PatchTextTodoDto patchTextTodoDto,
             @PathVariable Long id) {
        return ResponseEntity.ok(todoService.changeTextById(id, patchTextTodoDto));
    }
}

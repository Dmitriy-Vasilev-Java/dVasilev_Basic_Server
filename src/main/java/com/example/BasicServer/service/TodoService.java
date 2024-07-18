package com.example.BasicServer.service;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.DeleteAllReadyTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.entity.TodoEntity;

public interface TodoService {

    CustomSuccessResponse<TodoEntity> createTask(CreateTodoDto createTodoDto);

    BaseSuccessResponse<TodoEntity> deleteAllReady(DeleteAllReadyTodoDto deleteAllReadyTodoDto);
}



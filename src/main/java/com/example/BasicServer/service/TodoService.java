package com.example.BasicServer.service;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.PatchTextTodoDto;
import com.example.BasicServer.dto.request.PatchTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.dto.response.GetNewsDto;
import com.example.BasicServer.entity.TodoEntity;
import java.util.List;

public interface TodoService {

    CustomSuccessResponse<GetNewsDto<List<TodoEntity>>> getPaginated(Integer page, Integer perPage, Boolean status);

    CustomSuccessResponse<TodoEntity> createTask(CreateTodoDto createTodoDto);

    BaseSuccessResponse deleteAllReady();

    BaseSuccessResponse changeStatus (PatchTodoDto patchTodoDto);

    BaseSuccessResponse deleteById(Long id);

    BaseSuccessResponse changeStatusById(Long  id, PatchTodoDto patchTodoDto);

    BaseSuccessResponse changeTextById(Long id, PatchTextTodoDto patchTextTodoDto);
}

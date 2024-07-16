package com.example.BasicServer.service;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.GetPaginatedTodoDto;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository repository;

    public CustomSuccessResponse<TodoEntity> create(CreateTodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        CreateTodoDto createTodoDto = new CreateTodoDto();
        todoEntity = repository.save(todoEntity);
        return new CustomSuccessResponse<TodoEntity>(new TodoEntity());
    }

    public CustomSuccessResponse<TodoEntity> deleteAllReady(CreateTodoDto todoDto) {
        return new CustomSuccessResponse<TodoEntity>(new TodoEntity());
    }


    public CustomSuccessResponse<TodoEntity> patch(CreateTodoDto todoDto) {
        return new CustomSuccessResponse<TodoEntity>(new TodoEntity());
    }

    public CustomSuccessResponse<TodoEntity> getPaginated(GetPaginatedTodoDto todoDto) {
        return new CustomSuccessResponse<TodoEntity>(new TodoEntity());
    }

    public CustomSuccessResponse<TodoEntity> delete(CreateTodoDto todoDto) {
        return new CustomSuccessResponse<TodoEntity>((new TodoEntity()));
    }
}
//Методы (анал-е по названию из контроллера внутри методов логика работы с репозиторием(взаимодействует с БД))
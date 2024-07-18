package com.example.BasicServer.service.impl;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.DeleteAllReadyTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.repository.TodoRepository;
import com.example.BasicServer.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Override
    public CustomSuccessResponse<TodoEntity> createTask(CreateTodoDto createTodoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setText(createTodoDto.getText());
        todoEntity = repository.save(todoEntity);
        return new CustomSuccessResponse<>(todoEntity, true, 1);
    }

//    public CustomSuccessResponse<TodoEntity> getPaginated(GetPaginatedTodoDto todoDto) {
//        return new CustomSuccessResponse<TodoEntity>();
//    }

    public BaseSuccessResponse<TodoEntity> deleteAllReady(DeleteAllReadyTodoDto deleteAllReadyTodoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setText(deleteAllReadyTodoDto.getSuccess());
        todoEntity = repository.deleteAll(todoEntity);
        return new BaseSuccessResponse<>(todoEntity, true, deleteAllReadyTodoDto);
    }
//    public BaseSuccessResponse<TodoEntity> deleteAllReady(DeleteAllReadyTodoDto deleteAllReadyTodoDto) {
//        TodoEntity todoEntity = new TodoEntity();
//        todoEntity.setText(deleteAllReadyTodoDto.g);
//        todoEntity = repository.delete(todoEntity);
//        return new CustomSuccessResponse<TodoEntity>(TodoEntity, true, 0);
//    }

//
//    public CustomSuccessResponse<TodoEntity> patch(CreateTodoDto todoDto) {
//        return new CustomSuccessResponse<TodoEntity>(new TodoEntity());
//    }
//
//    public CustomSuccessResponse<TodoEntity> delete(CreateTodoDto todoDto) {
//        return new CustomSuccessResponse<TodoEntity>((new TodoEntity()));
//    }
//
//    public CustomSuccessResponse<TodoEntity> patchStatus(CreateTodoDto todoDto) {
//        return new CustomSuccessResponse<TodoEntity>(new TodoEntity());
//    }
}

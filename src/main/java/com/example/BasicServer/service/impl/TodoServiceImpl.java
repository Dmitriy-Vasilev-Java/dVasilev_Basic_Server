package com.example.BasicServer.service.impl;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.PatchTextTodoDto;
import com.example.BasicServer.dto.request.PatchTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.entity.TodoEntity;
import com.example.BasicServer.repository.TodoRepository;
import com.example.BasicServer.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    //    @Override
//    public CustomSuccessResponse<TodoEntity> getPaginated(GetPaginatedTodoDto todoDto) {
//        return new CustomSuccessResponse<TodoEntity>();
//    }

    @Override
    public CustomSuccessResponse<TodoEntity> createTask(CreateTodoDto createTodoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setText(createTodoDto.getText());
        todoEntity.setStatus(false);
        todoEntity = repository.save(todoEntity);
        return new CustomSuccessResponse<>(true, 1, todoEntity, null);
    }

    @Override
    public BaseSuccessResponse deleteAllReady() {
        repository.deleteByStatus(true);
        return new BaseSuccessResponse(1,true);
    }

    @Transactional
    @Override
    public BaseSuccessResponse changeStatus(PatchTodoDto patchTodoDto) {
        List<TodoEntity> listEntity = repository.findAll();
        for (TodoEntity todoEntity:listEntity) {
            todoEntity.setStatus(patchTodoDto.getStatus());
        }
        return new BaseSuccessResponse(1, true);
    }

    @Override
    public BaseSuccessResponse deleteById(Long id) {
        repository.deleteById(id);
        return new BaseSuccessResponse(1, true);
    }

    @Transactional
    @Override
    public BaseSuccessResponse changeStatusById(Long id, PatchTodoDto patchTodoDto) {
        TodoEntity entity = repository.findById(id).orElseThrow(RuntimeException::new);
        entity.setStatus(patchTodoDto.getStatus());
        return new BaseSuccessResponse(1, true);
    }

    @Transactional
    @Override
    public BaseSuccessResponse changeStatusByText(String text, PatchTextTodoDto patchTextTodoDto) {
        List<TodoEntity> listTextEntity = repository.findAll();
        for(TodoEntity todoEntity:listTextEntity) {
            todoEntity.setText(patchTextTodoDto.getText());
        }
        return new BaseSuccessResponse(1, true);
    }
}

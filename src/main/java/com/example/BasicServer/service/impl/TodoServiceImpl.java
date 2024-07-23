package com.example.BasicServer.service.impl;

import com.example.BasicServer.dto.request.CreateTodoDto;
import com.example.BasicServer.dto.request.PatchTextTodoDto;
import com.example.BasicServer.dto.request.PatchTodoDto;
import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import com.example.BasicServer.dto.response.GetNewsDto;
import com.example.BasicServer.entity.TodoEntity;
//import com.example.BasicServer.error.CustomException;
import com.example.BasicServer.error.CustomException;
import com.example.BasicServer.error.ErrorCodes;
import com.example.BasicServer.repository.TodoRepository;
import com.example.BasicServer.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    @Autowired
    private final TodoRepository repository;

    public CustomSuccessResponse<GetNewsDto<List<TodoEntity>>> getPaginated(Integer page, Integer perPage, Boolean status) {
        Pageable pageable = PageRequest.of(page - 1, perPage);
        Page<TodoEntity> pageEntities = status == null
                ? repository.findAll(pageable)
                : repository.findPaginatedByStatus(pageable, status);
        List<TodoEntity> listEntities = pageEntities.stream().collect(Collectors.toList());
        long numberOfElements = listEntities.size();
        long ready = listEntities.stream().filter(TodoEntity::getStatus).count();
        long notReady = numberOfElements-ready;

        return new CustomSuccessResponse<>(true, 1, new GetNewsDto<>(listEntities, numberOfElements, ready, notReady), null);
    }


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
        TodoEntity entity = repository.findById(id).orElseThrow(() -> new CustomException(ErrorCodes.HTTP_MESSAGE_NOT_READABLE_EXCEPTION));
        entity.setStatus(patchTodoDto.getStatus());
        return new BaseSuccessResponse(1, true);
    }

    @Transactional
    @Override
    public BaseSuccessResponse changeTextById(Long id, PatchTextTodoDto patchTextTodoDto) {
        List<TodoEntity> listTextEntity = repository.findAll();
        for(TodoEntity todoEntity:listTextEntity) {
            todoEntity.setText(patchTextTodoDto.getText());
        }
        return new BaseSuccessResponse(1, true);
    }
}

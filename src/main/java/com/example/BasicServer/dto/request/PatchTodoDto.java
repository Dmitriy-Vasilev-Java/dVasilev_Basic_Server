package com.example.BasicServer.dto.request;

import com.example.BasicServer.error.ValidationConstants;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PatchTodoDto {

    @NotNull(message = ValidationConstants.TODO_STATUS_NOT_NULL)
    private Boolean status;
}

package com.example.BasicServer.dto.request;

import com.example.BasicServer.error.ValidationConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PatchTextTodoDto {

    @NotNull(message = ValidationConstants.TODO_TEXT_NOT_NULL)
    @Size(min = 3, max = 160, message = ValidationConstants.TODO_TEXT_SIZE_NOT_VALID)
    private String text;
}

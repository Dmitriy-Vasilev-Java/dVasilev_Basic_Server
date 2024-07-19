package com.example.BasicServer.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchTextTodoDto {
    @Size(min = 3, max = 160)
    private String text;
}

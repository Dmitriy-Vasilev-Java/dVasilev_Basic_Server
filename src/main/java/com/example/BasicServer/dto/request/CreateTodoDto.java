package com.example.BasicServer.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTodoDto {

    @Size(min = 3, max = 160)
    private String text;
}

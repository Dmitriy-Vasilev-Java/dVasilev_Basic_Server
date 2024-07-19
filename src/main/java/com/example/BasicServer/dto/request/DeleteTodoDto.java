package com.example.BasicServer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteTodoDto {
    private Integer statusCode;
    private boolean success;
}

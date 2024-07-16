package com.example.BasicServer.dto.request;

import lombok.Data;

@Data
public class DeleteTodoDto {

    private Integer statusCode;
    private boolean success;
}

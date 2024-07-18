package com.example.BasicServer.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteAllReadyTodoDto {
    private Integer statusCode;
    private Boolean success;
}

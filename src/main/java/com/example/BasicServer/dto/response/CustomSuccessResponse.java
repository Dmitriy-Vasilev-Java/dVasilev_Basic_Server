package com.example.BasicServer.dto.response;

import lombok.Getter;

@Getter
public class CustomSuccessResponse <T>  {
    public T data;
    public Integer statusCode;
    public Boolean success;

    public CustomSuccessResponse(T data, Boolean success, Integer statusCode) {
        this.data = data;
        this.statusCode = statusCode;
        this.success = success;
    }
}

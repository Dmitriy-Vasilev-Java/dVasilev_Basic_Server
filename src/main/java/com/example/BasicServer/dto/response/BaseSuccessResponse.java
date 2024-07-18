package com.example.BasicServer.dto.response;

public class BaseSuccessResponse<T> {
    public Integer statusCode;
    public Boolean success;

    public BaseSuccessResponse(Integer statusCode,Boolean success) {
        this.statusCode = statusCode;
        this.success = success;
    }
}

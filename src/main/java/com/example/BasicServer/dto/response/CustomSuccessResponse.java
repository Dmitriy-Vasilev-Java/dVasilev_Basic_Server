package com.example.BasicServer.dto.response;

public class CustomSuccessResponse <T>  {
    public T data;
    public Integer statusCode;
    public Boolean success;

    public CustomSuccessResponse(T data) {
        this.data = data;
    }
}

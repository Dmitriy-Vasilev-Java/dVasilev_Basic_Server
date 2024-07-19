package com.example.BasicServer.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class CustomSuccessResponse <T> extends BaseSuccessResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> codes;

    public CustomSuccessResponse(Boolean success, Integer statusCode, T data, List<Integer> codes) {
        super(statusCode, success);
        this.data = data;
        this.codes = codes;
    }
}

package com.example.BasicServer.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CustomSuccessResponse<T> extends BaseSuccessResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Integer> codes;

    public CustomSuccessResponse(List<Integer> codes, Integer statusCode) {
        this.codes = codes;
        setStatusCode(statusCode);
    }
}

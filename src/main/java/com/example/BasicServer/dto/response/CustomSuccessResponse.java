package com.example.BasicServer.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import java.util.List;

@Getter
public class CustomSuccessResponse<T> extends BaseSuccessResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Integer> codes;

    public CustomSuccessResponse(Boolean success, Integer statusCode, T data, List<Integer> codes) {
        super(statusCode, success);
        this.data = data;
        this.codes = codes;
    }
}

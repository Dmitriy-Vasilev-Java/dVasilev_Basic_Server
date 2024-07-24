package com.example.BasicServer.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseSuccessResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Integer statusCode;
    private final Boolean success;
}

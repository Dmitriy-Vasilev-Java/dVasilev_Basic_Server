package com.example.BasicServer.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseSuccessResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer statusCode = 1;

    private Boolean success = true;
}

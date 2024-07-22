package com.example.BasicServer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetNewsDto<T> {
    private T content;
    private Long numberOfElements;
    private Long ready;
    private Long notReady;
}

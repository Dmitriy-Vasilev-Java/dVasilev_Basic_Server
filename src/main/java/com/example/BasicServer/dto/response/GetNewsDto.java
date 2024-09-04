package com.example.BasicServer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetNewsDto<T> {
    private final T content;

    private final Long numberOfElements;

    private final Long ready;

    private final Long notReady;
}

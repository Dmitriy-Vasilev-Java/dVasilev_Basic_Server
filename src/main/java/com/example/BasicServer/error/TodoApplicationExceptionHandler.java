package com.example.BasicServer.error;

import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.GetNewsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseSuccessResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new BaseSuccessResponse(ErrorCodes
                        .getErrorCodeByMessage( e.getBindingResult()
                                .getFieldError()
                                .getDefaultMessage()), true));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GetNewsDto> handleNNException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new GetNewsDto(ErrorCodes
                        .getErrorCodeByMessage(e.getBindingResult()
                                .getFieldError()
                                .getDefaultMessage()),true));
    }
}

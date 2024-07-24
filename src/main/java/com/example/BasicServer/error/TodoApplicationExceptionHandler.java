package com.example.BasicServer.error;

import com.example.BasicServer.dto.response.BaseSuccessResponse;
import com.example.BasicServer.dto.response.CustomSuccessResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TodoApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomSuccessResponse> handleConstraintViolationException(ConstraintViolationException e) {
        List<Integer> errorCodes = e.getConstraintViolations()
                .stream()
                .map(constraintViolation -> {
                    return ErrorCodes.getErrorCodeByMessage(constraintViolation.getMessageTemplate());
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(
                errorCodes.size() > 1
                        ? new CustomSuccessResponse(true, null, null, errorCodes)
                        : new CustomSuccessResponse(true, errorCodes.get(0), null, null));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseSuccessResponse>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new BaseSuccessResponse(ErrorCodes
                        .getErrorCodeByMessage(e
                                .getBindingResult()
                                .getFieldError()
                                .getDefaultMessage()), true));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseSuccessResponse> handleCustomException(CustomException e) {
        return ResponseEntity.badRequest().body(new BaseSuccessResponse(e.errorCodes.getErrorCode(), true));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseSuccessResponse> handleHttpMessageNotReadableException
            (HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest()
                .body(new BaseSuccessResponse(ErrorCodes
                        .getErrorCodeByMessage(ValidationConstants.HTTP_MESSAGE_NOT_READABLE_EXCEPTION), true));
    }
}

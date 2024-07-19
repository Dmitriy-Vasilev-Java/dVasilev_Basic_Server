package com.example.BasicServer.error;

import com.example.BasicServer.dto.response.BaseSuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TodoApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseSuccessResponse> handleValidationException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(
                new BaseSuccessResponse(ErrorCodes.getErrorCodeByMessage( e.getBindingResult().getFieldError().getDefaultMessage()), true));

        /*List<Integer> errorCodes = e.getConstraintViolations()
                .stream()
                .map(violation -> ErrorCodes.getErrorCodeByMessage(violation.getMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                errorCodes.size() > 1
                ? new CustomSuccessResponse<Void>(true, null, null, errorCodes)
                : new BaseSuccessResponse(errorCodes.get(0), true));*/
    }
}

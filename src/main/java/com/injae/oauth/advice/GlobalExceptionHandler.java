package com.injae.oauth.advice;

import com.injae.oauth.dto.base.BaseResponse;
import com.injae.oauth.dto.base.ErrorResponse;
import com.injae.oauth.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<BaseResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.getInstance(HttpStatus.BAD_REQUEST));
  }

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
      return ResponseEntity.status(exception.getErrorCode().getStatus()).body(ErrorResponse.getInstance(exception.getErrorCode()));
  }

}

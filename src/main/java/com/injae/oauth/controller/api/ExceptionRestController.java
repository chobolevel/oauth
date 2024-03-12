package com.injae.oauth.controller.api;

import com.injae.oauth.entity.BaseResponse;
import com.injae.oauth.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestController {

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<?> apiException(ApiException exception) {
    BaseResponse baseResponse = BaseResponse.getInstance(exception.getType().getStatus(), exception.getMessage());
    return new ResponseEntity<>(baseResponse, exception.getType().getStatus());
  }

}

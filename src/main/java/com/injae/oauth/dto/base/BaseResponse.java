package com.injae.oauth.dto.base;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class BaseResponse {

  private int statusCode;
  private String statusText;
  private LocalDateTime timestamp;
  private Object data;

  public static BaseResponse getInstance(HttpStatus status) {
    return BaseResponse
        .builder()
        .statusCode(status.value())
        .statusText(status.getReasonPhrase())
        .timestamp(LocalDateTime.now())
        .build();
  }

  public static BaseResponse getInstance(HttpStatus status, Object data) {
    return BaseResponse
        .builder()
        .statusCode(status.value())
        .statusText(status.getReasonPhrase())
        .timestamp(LocalDateTime.now())
        .data(data)
        .build();
  }

}

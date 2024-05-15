package com.injae.oauth.dto.base;

import com.injae.oauth.exception.ErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

  private int status;
  private String name;
  private String code;
  private String message;

  public static ErrorResponse getInstance(ErrorCode errorCode) {
    return ErrorResponse
      .builder()
      .status(errorCode.getStatus().value())
      .name(errorCode.name())
      .code(errorCode.getCode())
      .message(errorCode.getMessage())
      .build();
  }

}

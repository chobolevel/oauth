package com.injae.oauth.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "", "데이터를 찾을 수 없습니다.");

  private final HttpStatus status;
  private final String code;
  private final String message;

}

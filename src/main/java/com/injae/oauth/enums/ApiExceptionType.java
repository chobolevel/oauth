package com.injae.oauth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ApiExceptionType {

  MISSING_PARAMETER(HttpStatus.BAD_REQUEST, "필수 파라미터 (%s)%s 이/가 누락되었습니다."),
  USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "이미 존재하는 회원정보입니다.");

  private final HttpStatus status;
  private final String message;

}

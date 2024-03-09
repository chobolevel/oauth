package com.injae.oauth.enums.user;

import com.injae.oauth.enums.BaseEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserRoleType implements BaseEnum {

  ROLE_USER("일반 사용자"),
  ROLE_ADMIN("일반 관리자"),
  ROLE_MASTER("최고 관리자");

  private final String name;

  @Override
  public String getCode() {
    return name();
  }

  @Override
  public String getName() {
    return name;
  }
}

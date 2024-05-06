package com.injae.oauth.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateUserInput {

  private String username;
  private String password;
  private String socialId;
  private String loginType;
  private String name;
  private String phone;
  private String address;
  private String detailAddress;

}
package com.injae.oauth.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateUserInput {

  @NotBlank
  private String username;
  @NotBlank
  private String password;
  private String socialId;
  @NotBlank
  private String loginType;
  @NotBlank
  private String name;
  @NotBlank
  @Max(11)
  private String phone;
  @NotBlank
  private String address;
  private String detailAddress;

}
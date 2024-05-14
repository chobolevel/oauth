package com.injae.oauth.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateUserInput {

  @NotBlank
  private Long id;
  private String username;
  private String name;
  private String phone;
  private String address;
  private String detailAddress;

}

package com.injae.oauth.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.injae.oauth.enums.users.UserUpdateMaskType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateUserInput {

  private String name;
  private String phone;
  private String address;
  private String detailAddress;
  @NotEmpty
  private List<UserUpdateMaskType> updateMask;

}

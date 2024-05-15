package com.injae.oauth.dto.user;

import com.injae.oauth.enums.users.UserLoginType;
import com.injae.oauth.enums.users.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetail {

  private long id;
  private String username;
  private UserLoginType loginType;
  private String name;
  private String phone;
  private String address;
  private String detailAddress;
  private UserRoleType role;

}

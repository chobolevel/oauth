package com.injae.oauth.entity;

import com.injae.oauth.enums.user.UserRoleType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  private String id;
  private String username;
  private String password;
  private String name;
  private String email;
  private String address;
  private String mobile;
  private UserRoleType role;
  private String createDate;
  private String updateDate;

}

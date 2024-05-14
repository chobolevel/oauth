package com.injae.oauth.service.user.converter;

import com.injae.oauth.dto.user.CreateUserInput;
import com.injae.oauth.dto.user.UserDetail;
import com.injae.oauth.entity.user.User;
import com.injae.oauth.enums.users.UserLoginType;
import com.injae.oauth.enums.users.UserRoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

  private final BCryptPasswordEncoder passwordEncoder;

  public User convert(CreateUserInput createUserInput) {
    return User
        .builder()
        .username(createUserInput.getUsername())
        .password(passwordEncoder.encode(createUserInput.getPassword()))
        .socialId(createUserInput.getSocialId())
        .loginType(UserLoginType.GENERAL)
        .name(createUserInput.getName())
        .phone(createUserInput.getPhone())
        .address(createUserInput.getAddress())
        .detailAddress(createUserInput.getDetailAddress())
        .role(UserRoleType.ROLE_USER)
        .deleted(false)
        .build();
  }

  public UserDetail convert(User user) {
    return UserDetail
      .builder()
      .id(user.getId())
      .username(user.getUsername())
      .loginType(user.getLoginType())
      .name(user.getName())
      .phone(user.getPhone())
      .address(user.getAddress())
      .detailAddress(user.getDetailAddress())
      .role(user.getRole())
      .build();
  }

}

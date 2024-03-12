package com.injae.oauth.service.user.impl;

import com.injae.oauth.entity.User;
import com.injae.oauth.enums.ApiExceptionType;
import com.injae.oauth.enums.user.UserRoleType;
import com.injae.oauth.exception.ApiException;
import com.injae.oauth.mapper.user.UserMapper;
import com.injae.oauth.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;

  private final BCryptPasswordEncoder passwordEncoder;

  @Override
  public void save(User user) throws ApiException {
    if(user.getUsername() == null || user.getUsername().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "username");
    }
    if(user.getPassword() == null || user.getPassword().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "password");
    }
    if(user.getName() == null || user.getName().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "name");
    }
    if(user.getEmail() == null || user.getEmail().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "email");
    }
    if(user.getAddress() == null || user.getAddress().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "address");
    }
    if(user.getMobile() == null || user.getMobile().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "mobile");
    }
    user.setId(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(UserRoleType.ROLE_USER);
    userMapper.save(user);
  }

  @Override
  public void saveById(User user) throws ApiException {
    if(user.getId() == null || user.getId().trim().isEmpty()) {
      throw new ApiException(ApiExceptionType.MISSING_PARAMETER, "String", "id");
    }
    userMapper.saveById(user);
  }

  @Override
  public void checkDuplication(User user) throws ApiException {
    //TODO 파라미터가 없는 경우 예외 처리 필요할듯
    User findUser = userMapper.findOne(user);
    if(findUser != null) {
      throw new ApiException(ApiExceptionType.USER_ALREADY_EXISTS);
    }
  }

}

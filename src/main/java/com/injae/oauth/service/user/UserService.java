package com.injae.oauth.service.user;

import com.injae.oauth.dto.user.CreateUserInput;
import com.injae.oauth.entity.User;
import com.injae.oauth.repository.user.UserRepository;
import com.injae.oauth.service.user.converter.UserConverter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserConverter userConverter;
  private final UserRepository userRepository;

  @Transactional
  public Long create(CreateUserInput createUserInput) {
    User convertedUser = userConverter.convert(createUserInput);
    User savedUser = userRepository.save(convertedUser);
    return savedUser.getId();
  }

}

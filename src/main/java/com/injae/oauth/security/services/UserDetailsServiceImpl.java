package com.injae.oauth.security.services;

import com.injae.oauth.entity.User;
import com.injae.oauth.mapper.user.UserMapper;
import com.injae.oauth.security.details.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User findUser = userMapper.findOne(User.builder().username(username).build());
    if(findUser == null) {
      throw new UsernameNotFoundException("회원 정보를 찾을 수 없습니다.");
    }
    return new CustomUserDetails(findUser);
  }
}

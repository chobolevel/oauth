package com.injae.oauth.security;

import com.injae.oauth.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

//@Component
@RequiredArgsConstructor
public class SecurityAuthenticationManger  implements AuthenticationManager {

  private final UserRepository userRepository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // TODO username, password 비교 후 UsernamePasswordAuthenticationToken 반환
    // [Authentication]
    // Principals 사용자 아이디 또는 객체
    // credentials 사용자 비밀번호
    // authorities 인증된 사용자의 권한 목록
    // details 인증 부가 정보
    // Authenticated 인증 여부
    return null;
  }

}

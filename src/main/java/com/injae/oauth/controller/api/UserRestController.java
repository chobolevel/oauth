package com.injae.oauth.controller.api;

import com.injae.oauth.entity.BaseResponse;
import com.injae.oauth.entity.User;
import com.injae.oauth.exception.ApiException;
import com.injae.oauth.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserRestController {

  private final UserService userService;

  @GetMapping("/checking-duplication")
  public ResponseEntity<?> checkDuplication(User user) throws ApiException {
    userService.checkDuplication(user);
    return new ResponseEntity<>(BaseResponse.getInstance(HttpStatus.OK, "사용 가능한 아이디입니다."), HttpStatus.OK);
  }

}

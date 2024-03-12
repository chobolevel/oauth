package com.injae.oauth.controller.api;

import com.injae.oauth.entity.User;
import com.injae.oauth.exception.ApiException;
import com.injae.oauth.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/sign")
@RestController
@RequiredArgsConstructor
public class SignRestController {

  private final UserService userService;

  @PostMapping("/up")
  public ResponseEntity<?> signUp(@RequestBody User user) throws ApiException {
    userService.save(user);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

}

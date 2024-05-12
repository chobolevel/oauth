package com.injae.oauth.controller.v1;

import com.injae.oauth.dto.base.BaseResponse;
import com.injae.oauth.dto.user.CreateUserInput;
import com.injae.oauth.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/users")
  public ResponseEntity<BaseResponse> addUser(@RequestBody @Valid CreateUserInput createUserInput) {
    Long saveUserId = userService.create(createUserInput);
    return new ResponseEntity<>(BaseResponse.getInstance(HttpStatus.OK, saveUserId), HttpStatus.OK);
  }

}

package com.injae.oauth.controller.v1;

import com.injae.oauth.dto.base.BaseResponse;
import com.injae.oauth.dto.base.PaginationResponseDto;
import com.injae.oauth.dto.user.CreateUserInput;
import com.injae.oauth.dto.user.UserDetail;
import com.injae.oauth.enums.users.UserRoleType;
import com.injae.oauth.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<PaginationResponseDto<UserDetail>> getUsers(@RequestParam(required = false) String username,
                                                                    @RequestParam(required = false) UserRoleType role,
                                                                    @RequestParam(required = false) long skipCount,
                                                                    @RequestParam(required = false) long limitCount) {
    PaginationResponseDto<UserDetail> users = userService.getUsers(username, role, skipCount, limitCount);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping("/users")
  public ResponseEntity<BaseResponse> addUser(@RequestBody @Valid CreateUserInput createUserInput) {
    Long saveUserId = userService.create(createUserInput);
    return new ResponseEntity<>(BaseResponse.getInstance(HttpStatus.OK, saveUserId), HttpStatus.OK);
  }

}

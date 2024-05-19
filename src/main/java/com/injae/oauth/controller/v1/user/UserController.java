package com.injae.oauth.controller.v1.user;

import com.injae.oauth.dto.base.BaseResponse;
import com.injae.oauth.dto.base.PaginationResponse;
import com.injae.oauth.dto.user.CreateUserInput;
import com.injae.oauth.dto.user.UpdateUserInput;
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
  public ResponseEntity<PaginationResponse<UserDetail>> getUsers(@RequestParam(required = false) String username,
                                                                 @RequestParam(required = false) UserRoleType role,
                                                                 @RequestParam(required = false, defaultValue = "0") long skipCount,
                                                                 @RequestParam(required = false, defaultValue = "20") long limitCount) {
    PaginationResponse<UserDetail> users = userService.getUsers(username, role, skipCount, limitCount);
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping("/users")
  public ResponseEntity<BaseResponse> addUser(@RequestBody @Valid CreateUserInput createUserInput) {
    Long saveUserId = userService.create(createUserInput);
    return new ResponseEntity<>(BaseResponse.getInstance(HttpStatus.CREATED, saveUserId), HttpStatus.CREATED);
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<BaseResponse> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserInput updateUserInput) {
    long updatedUserId = userService.update(id, updateUserInput);
    return new ResponseEntity<>(BaseResponse.getInstance(HttpStatus.OK, updatedUserId), HttpStatus.OK);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<BaseResponse> deleteUser(@PathVariable Long id) {
    Long deleteUserId = userService.delete(id);
    return new ResponseEntity<>(BaseResponse.getInstance(HttpStatus.OK, deleteUserId), HttpStatus.OK);
  }

}

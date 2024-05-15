package com.injae.oauth.service.user.updater;

import com.injae.oauth.dto.user.UpdateUserInput;
import com.injae.oauth.entity.user.User;
import com.injae.oauth.enums.users.UserUpdateMaskType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUpdater {

  public User markAsUpdate(UpdateUserInput updateUserInput, User user) {
    List<UserUpdateMaskType> updateMask = updateUserInput.getUpdateMask();
    updateMask.forEach((mask) -> {
      switch (mask) {
        case NAME -> user.setName(updateUserInput.getName());
        case PHONE -> user.setPhone(updateUserInput.getPhone());
        case ADDRESS -> user.setAddress(updateUserInput.getAddress());
        case DETAIL_ADDRESS -> user.setDetailAddress(updateUserInput.getDetailAddress());
      }
    });
    return user;
  }

}

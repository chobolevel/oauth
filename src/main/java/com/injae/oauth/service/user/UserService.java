package com.injae.oauth.service.user;

import com.injae.oauth.entity.User;
import com.injae.oauth.exception.ApiException;

public interface UserService {

  void save(User user) throws ApiException;

  void saveById(User user) throws ApiException;

}

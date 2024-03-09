package com.injae.oauth.mapper.user;

import com.injae.oauth.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  void save(User user);

  User findOne(User user);

  void saveById(User user);

}

package com.injae.oauth.repository.user;

import com.injae.oauth.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

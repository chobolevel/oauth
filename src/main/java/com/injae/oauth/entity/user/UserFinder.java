package com.injae.oauth.entity.user;

import com.injae.oauth.dto.base.Pagination;
import com.injae.oauth.repository.user.UserCustomRepository;
import com.injae.oauth.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class UserFinder {

  private final UserRepository repository;
  private final UserCustomRepository customRepository;

  public List<User> search(UserQueryFilter queryFilter, Pagination pagination) {
    return customRepository.findByPredicates(queryFilter.toPredicates(), pagination);
  }

  public long searchCount(UserQueryFilter queryFilter) {
    return customRepository.countByPredicates(queryFilter.toPredicates());
  }

}

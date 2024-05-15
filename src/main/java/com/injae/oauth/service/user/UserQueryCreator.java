package com.injae.oauth.service.user;

import com.injae.oauth.dto.base.Pagination;
import com.injae.oauth.enums.users.UserRoleType;
import org.springframework.stereotype.Component;

@Component
public class UserQueryCreator {

  public UserQueryFilter createQueryFilter(String username, UserRoleType role) {
    return new UserQueryFilter(username, role);
  }

  public Pagination createPaginationFilter(long skipCount, long limitCount) {
    // 기본값 설정하기(kotlin 문법 참조)
    long limit = limitCount;
    long skip = skipCount;
    return new Pagination(limit, skip);
  }

}

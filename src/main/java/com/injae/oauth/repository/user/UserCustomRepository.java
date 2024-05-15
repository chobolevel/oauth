package com.injae.oauth.repository.user;

import com.injae.oauth.dto.base.Pagination;
import com.injae.oauth.entity.user.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.injae.oauth.entity.user.QUser.user;

@Repository
public class UserCustomRepository extends QuerydslRepositorySupport {

  public UserCustomRepository() {
    super(User.class);
  }

  public List<User> findByPredicates(List<BooleanExpression> predicates, Pagination pagination) {
    return from(user)
      .where(predicates.toArray(BooleanExpression[]::new))
      .limit(pagination.getLimit())
      .offset(pagination.getSkip())
      .distinct()
      .fetch();
  }

  public long countByPredicates(List<BooleanExpression> predicates) {
    return from(user)
      .select(user.id)
      .where(predicates.toArray(BooleanExpression[]::new))
      .distinct()
      .fetchCount();
  }

}

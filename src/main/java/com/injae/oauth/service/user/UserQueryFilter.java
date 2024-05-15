package com.injae.oauth.service.user;

import com.injae.oauth.enums.users.UserRoleType;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.injae.oauth.entity.user.QUser.user;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserQueryFilter {

  private String username;
  private UserRoleType role;

  public List<BooleanExpression> toPredicates() {
    ArrayList<BooleanExpression> predicates = new ArrayList<>();
    if(username != null) {
      predicates.add(user.username.eq(this.username));
    }
    if(role != null) {
      predicates.add(user.role.eq(this.role));
    }
    return predicates;
  }

}

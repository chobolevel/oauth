package com.injae.oauth.service.user;

import com.injae.oauth.dto.base.Pagination;
import com.injae.oauth.dto.base.PaginationResponse;
import com.injae.oauth.dto.user.CreateUserInput;
import com.injae.oauth.dto.user.UpdateUserInput;
import com.injae.oauth.dto.user.UserDetail;
import com.injae.oauth.entity.user.User;
import com.injae.oauth.enums.users.UserRoleType;
import com.injae.oauth.repository.user.UserRepository;
import com.injae.oauth.service.user.converter.UserConverter;
import com.injae.oauth.service.user.updater.UserUpdater;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserConverter userConverter;
  private final UserUpdater userUpdater;
  private final UserRepository userRepository;
  private final UserQueryCreator queryCreator;
  private final UserFinder userFinder;

  @Transactional
  public Long create(CreateUserInput createUserInput) {
    User convertedUser = userConverter.convert(createUserInput);
    User savedUser = userRepository.save(convertedUser);
    return savedUser.getId();
  }
  
  // TODO CRUD 작성
  public PaginationResponse<UserDetail> getUsers(String username, UserRoleType role, long skipCount, long limitCount) {
    // 검색 조건 만들기
    UserQueryFilter queryFilter = queryCreator.createQueryFilter(username, role);
    Pagination pagination = queryCreator.createPaginationFilter(skipCount, limitCount);
    // 검색 조건으로 찾기
    List<User> userList = userFinder.search(queryFilter, pagination);
    // 같은 검색 조건 레코드 개수 찾기
    long totalCount = userFinder.searchCount(queryFilter);
    return new PaginationResponse<>(totalCount, pagination.getSkip(), pagination.getLimit(), userList.stream().map(userConverter::convert).toList());
  }

  public long update(Long id, UpdateUserInput updateUserInput) {
    User findUser = userFinder.findById(id);
    User convertedUser = userUpdater.markAsUpdate(updateUserInput, findUser);
    return userRepository.save(convertedUser).getId();
  }

  public Long delete(Long id) {
    userRepository.deleteById(id);
    return id;
  }

}

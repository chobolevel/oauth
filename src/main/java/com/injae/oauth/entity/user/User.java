package com.injae.oauth.entity.user;

import com.injae.oauth.entity.BaseEntity;
import com.injae.oauth.enums.users.UserLoginType;
import com.injae.oauth.enums.users.UserRoleType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET is_delete = true WHERE id = ?")
@Audited
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @Column
  private String socialId;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserLoginType loginType;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String phone;
  @Column(nullable = false)
  private String address;
  @Column
  private String detailAddress;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private UserRoleType role;
  @Column(nullable = false)
  private boolean deleted;

}

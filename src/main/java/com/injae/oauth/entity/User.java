package com.injae.oauth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET is_delete = true WHERE id = ?")
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
  private String loginType;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String phone;
  @Column(nullable = false)
  private String address;
  @Column
  private String detailAddress;
  @Column(nullable = false)
  private String role;
  @Column(nullable = false)
  private boolean isDelete;

}

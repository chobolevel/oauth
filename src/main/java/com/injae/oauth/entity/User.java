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
  @Column
  private String username;
  @Column
  private String password;
  @Column
  private String socialId;
  @Column
  private String loginType;
  @Column
  private String name;
  @Column
  private String phone;
  @Column
  private String address;
  @Column
  private String detailAddress;
  @Column
  private boolean isDelete;

}

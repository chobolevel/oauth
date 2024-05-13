package com.injae.oauth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // BaseEntity 상속하는 경우 createdAt, updatedAt 컬럼으로 인식
@EntityListeners(value = AuditingEntityListener.class) // 해당 클래스에 Auditing 기능을 포함
@Audited
public class BaseEntity {

  @Column(nullable = false)
  @CreatedDate // entity 생성될 때 시간이 자동 저장
  private LocalDateTime createdAt;

  @Column(nullable = false)
  @LastModifiedDate // entity 값을 변경할 때 시간이 자동 저장
  private LocalDateTime updatedAt;

}

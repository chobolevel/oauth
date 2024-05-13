package com.injae.oauth.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Data
@Entity
@RevisionEntity
@Table(name = "revision_info")
public class RevisionInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @RevisionNumber
  @Column(name = "revision")
  private long id;

  @RevisionTimestamp
  @Column(name = "revision_stamp")
  private long revisionStamp;

}

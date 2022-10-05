package com.gyull.cookivel.domain.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @implNote 회원정보의 프로필이미지와 자기소개
 */
@Entity
@Table(name="profile")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"member_id"})
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="member_id", updatable = false)
  private long member_id;
  @Column(length = 200)
  private String intro;
  
  private String avatar_imgUrl;

  private String avatar_thumbUrl;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime regDate;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime updateDate;
}

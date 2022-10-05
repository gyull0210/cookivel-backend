package com.gyull.cookivel.domain.member;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @implNote 회원번호, 이메일, 비밀번호, 닉네임, 프로필이미지, 자기소개, 가입일, 수정일, 접속일
 */
@Entity
@Table(name="member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"member_id"})
@ToString(of = {"email", "nickName"})
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id", updatable = false)
  private long member_id;

  @AttributeOverride(name = "value", column = @Column(name = "email", nullable = false, unique = true, updatable = false, length = 50))
  private Email email;

  @Column(nullable = false, updatable = true, length = 20)
  private String password;

  @Column(nullable = false, unique = true, updatable = true, length = 10)
  private String nickName;

  @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name="member_id")
  private Profile profile;

  // @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	// @JoinColumn(name = "member_id")
	// private List<MemberRole> roles;
  
  @Temporal(TemporalType.TIMESTAMP)  
  private LocalDateTime createAt;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime modifiedAt;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime recentAt;


}

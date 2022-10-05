package com.gyull.cookivel.domain.role;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="member_role")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberRole {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name = "member_id", updatable = false)
  private long member_id;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @Column(name="role_id")
  private long role_id;
}

package com.gyull.cookivel.domain.count;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @implNote 작품 회차를 조회하면 등록된다. 동일 작품은 회차 데이터만 갱신된다.
 * 회원번호로 개인의 작품 조회목록을 불러온다.
 */
@Entity
@Table(name="read")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"read_id"})
public class Read {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "read_id", updatable = false)
  private long read_id;
  private long member_id;
  private long book_id;
  private long bookpage_id;
  private String title;
  private LocalDateTime regDate;
}

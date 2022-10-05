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
 * @implNote 개인이 구독한 작품 목록을 불러온다. 구독테이블과 작품테이블을 join하여 해당 작품의 정보를 추가로 가져온다.
 * 구독한 작품은 개인이 최근에 읽은 회차를 보여준다. 최근 등록된 회차가 있으면 new를 보여준다.
 * 구독번호, 회원번호, 책번호, 책페이지번호
 */
@Entity
@Table(name="subscribe")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"subscribe_id"})
public class Subscribe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscribe_id", updatable = false)
  private long subscribe_id;
  private long member_id;
  private long book_id;
  private long bookpage_id;
  private boolean status;
  private LocalDateTime regDate;
  private LocalDateTime updateDate;
}

package com.gyull.cookivel.domain.count;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @implNote 회원들의 좋아요를 등록하는 테이블
 * 좋아요는 특정페이지에서만 가능하다
 */
@Entity
@Table(name="like")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"like_id"})
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "like_id", updatable = false)
  private long like_id;
  private long member_id;
  private long book_id;
  private long bookpage_id;
  private Integer like;
  private LocalDateTime regDate;

  @Builder
  public Like(long member_id, long book_id, long bookpage_id, Integer like){
    this.member_id = member_id;
    this.book_id = book_id;
    this.bookpage_id = bookpage_id;
    this.like = like;
  }
}

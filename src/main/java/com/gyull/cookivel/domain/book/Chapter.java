package com.gyull.cookivel.domain.book;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
/**
 * @implNote 책페이지번호, 책번호, 회원번호, 제목, 카테고리, 본문, 공개여부, 등록일, 수정일, 조회수, 추천수
 */
@Entity
@Table(name="chapter")
public class Chapter {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "chapter_id", updatable = false)
 private long chapterId;
 private long bookId;
 private long memberId;
 private int chapterNo;
 private String chapterTitle;
 private Category category;
 private String article;
 private String isPublic;

 @Temporal(TemporalType.TIMESTAMP)
 private LocalDateTime createAt;

 @Temporal(TemporalType.TIMESTAMP)
 private LocalDateTime lastModifiedAt;
 
 private String reads;
 private String likes;

 public enum Category {
  NOTICE("공지사항"),
  PROLOGUE("프롤로그"),
  CHAPTER("연재"),
  EPILLOGUE("에필로그");
  
  private String text;
  Category(String text) {this.text = text;}

  public String getText() {return text;}
 }

 @Builder
 public Chapter() {

 }
}

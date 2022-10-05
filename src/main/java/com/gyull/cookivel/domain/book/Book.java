package com.gyull.cookivel.domain.book;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @implNote 책번호, 책이름, 회원번호, 작가이름, 책 소개, 장르, 연재종류, 연재상태, 공개유무, 해시태그, 등록일, 수정일, 조회수, 구독수, 추천수
 */
@Entity
@Table(name="book")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"bookId"})
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bookId", updatable = false)
  private long bookId;

  @Column(name = "memberId", updatable = false)
  private long memberId;

  @Column(name = "bookTitle", nullable=false)
  private String bookTitle;

  @Column(length=10, nullable=false)
  private String author;

  @Column(length=5000, unique=true, nullable=false)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false)
  private Genre genre;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false)
  private String writeType;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false)
  private Status bookStatus;

  @Enumerated(EnumType.STRING)
  @Column(nullable=false)
  private Public isPublic;

  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name="tags_id")
  @Column(name="tags_id", nullable=false)
  private long tagsId;

  private String coverImgUrl;

  private String coverImgThumbUrl;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime createAt;

  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastModifiedAt;

  private long chapters;

  private long reads;

  private long subscribes;

  private long likes;

  public enum Genre {
    Fantasy("판타지"),
    ModernFantasy("현대판타지"),
    Romance("로맨스"),
    RomanceFantasy("로맨스판타지"),
    BL("BL"),
    GL("GL");

  private String text;
  Genre(String text) {this.text = text;}

  public String getText() {return text;}
  }

  public enum Status {
    serialized("연재중"),
    Hiatus("연재중단"),
    Concluded("완결됨");

    private String text;
    Status(String text) {this.text = text;}
  
    public String getText() {return text;}
  }

  public enum Public {
    onPublic("공개"),
    onHidden("비공개");
   
    private String text;
    Public(String text) {this.text = text;}
  
    public String getText() {return text;}
  }

  @Builder
  public Book (long bookId, String bookTitle, String author, String description, Genre genre, 
  String writeType, Status bookStatus, Public isPublic, long tagsId, String coverImgUrl, String coverImgThumbUrl) {
    this.bookId = bookId;
    this.bookTitle = bookTitle;
    this.author = author;
    this.description = description;
    this.genre = genre;
    this.writeType = writeType;
    this.bookStatus = bookStatus;
    this.isPublic =isPublic;
    this.tagsId = tagsId;
    this.coverImgUrl = coverImgUrl;
    this.coverImgThumbUrl = coverImgThumbUrl;
  }
}

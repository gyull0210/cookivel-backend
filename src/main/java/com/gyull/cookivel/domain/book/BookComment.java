package com.gyull.cookivel.domain.book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="book.comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"bkcomment_id"})
public class BookComment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bkcomment_id", updatable = false)
  private long bkcomment_id;
  private long book_id;
  private long chapter_id;
  private long member_id;
  private Integer ref_id;

  @Column(length=1000, nullable = false)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ref_id")
  private BookComment reply;

  @OneToMany(mappedBy = "reply", orphanRemoval = true)
  private List<BookComment> children = new ArrayList<>();

  private LocalDateTime regDate;
}

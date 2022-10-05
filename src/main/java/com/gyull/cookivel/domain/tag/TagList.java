package com.gyull.cookivel.domain.tag;

import java.time.LocalDateTime;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tagList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(of = {"tags_id"})
public class TagList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "tags_id", updatable = false)
  private long tagsId;

  @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinColumn(name="tag_id")
  private String tagId;
  private LocalDateTime createAt;
}

package com.gyull.cookivel.dto.book;

import java.time.LocalDateTime;

import com.gyull.cookivel.domain.book.Book;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookDTO {
  private long book_id;
  private long member_id;
  private String title;
  private String author;
  private String intro;
  private String genre;
  private String writeType;
  private String status;
  private String isPublic;
  private String tag;
  private String cover_imgUrl;
  private LocalDateTime regDate;
  private LocalDateTime updateDate;
  private int chapters;
  private int reads;
  private int subscribes;
  private int likes;

  public Book toEntity(){
    Book book = Book.builder().build();
    
    return book;
  }

}

package com.gyull.cookivel.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiResponseDTO<T> {
  private String status;
  private String message;
  private String errorCode;
  private String errorMessage;

  @Builder
  public ApiResponseDTO(String status, String message, String errorCode, String errorMessage){
    this.status = status;
    this.message = message;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }


}

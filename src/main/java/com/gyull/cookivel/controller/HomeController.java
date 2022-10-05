package com.gyull.cookivel.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gyull.cookivel.domain.member.Member;
import com.gyull.cookivel.dto.response.ApiResponseDTO;

@Controller
public class HomeController {
  
  private final Logger logger = LogManager.getLogger(HomeController.class);

  public String getAllCustomer(){
    logger.warn("getAllCustomer");

    return "a";
  }

  @GetMapping(value = "/hello")
  public ApiResponseDTO getCustomer(@RequestBody Member member){
    logger.warn("getAllCustomer");
    ApiResponseDTO message = ApiResponseDTO.builder().status("200").message("its ok").build();
    return message;
  }
}

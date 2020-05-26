package com.nt.commons;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadCommand {
  private String ename;
  private String eadd;
  private MultipartFile epotho;
  private MultipartFile eresume;
  
}

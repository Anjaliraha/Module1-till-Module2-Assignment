package com.collegemanagementsystem.college.advices;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ApiResponse<T> {
  private T data;

  @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
  private LocalDateTime localDateTime;

  private ApiError apiError;

  public ApiResponse(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime.now();
  }

  public ApiResponse(T data) {
    this();
    this.data = data;
  }

  public ApiResponse(ApiError apiError) {
    this();
    this.apiError = apiError;
  }
}

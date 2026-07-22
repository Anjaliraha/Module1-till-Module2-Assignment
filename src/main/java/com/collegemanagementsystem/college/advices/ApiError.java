package com.collegemanagementsystem.college.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ApiError {

  private HttpStatus httpStatus;
  private String message;
  private String subError;
}

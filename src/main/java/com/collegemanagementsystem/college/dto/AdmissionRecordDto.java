package com.collegemanagementsystem.college.dto;

import com.collegemanagementsystem.college.entities.StudentEntity;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AdmissionRecordDto {
  private Long admissionRecordId;
  @Positive private Integer fees;
  private StudentEntity student;
}

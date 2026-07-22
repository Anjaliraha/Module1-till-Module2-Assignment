package com.collegemanagementsystem.college.dto;

import com.collegemanagementsystem.college.entities.ProfessorEntity;
import com.collegemanagementsystem.college.entities.StudentEntity;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class SubjectDto {
  private Long subjectId;

  @NotNull(message = "Subject Name cannot be empty")
  private String title;

  private ProfessorEntity professor;
  private List<StudentEntity> studentEntityList;
}

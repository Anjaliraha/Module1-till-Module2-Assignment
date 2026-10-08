package com.collegemanagementsystem.college.dto;

import com.collegemanagementsystem.college.entities.ProfessorEntity;
import com.collegemanagementsystem.college.entities.SubjectEntity;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class StudentDto {
  private Long studentId;

  @NotNull(message = "Student name cannot be null")
  private String name;

  List<ProfessorEntity> professorEntities;

  List<SubjectEntity> subjectEntityList;
}

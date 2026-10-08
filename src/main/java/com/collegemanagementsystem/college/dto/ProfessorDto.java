package com.collegemanagementsystem.college.dto;

import com.collegemanagementsystem.college.entities.StudentEntity;
import com.collegemanagementsystem.college.entities.SubjectEntity;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class ProfessorDto {
  private Long professorId;

  @NotNull(message = "Title cannot be empty")
  private String title;

  private List<SubjectEntity> subjectEntityList;
  private List<StudentEntity> studentEntitiesList;
}

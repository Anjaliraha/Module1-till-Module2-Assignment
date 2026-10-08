package com.collegemanagementsystem.college.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long subjectId;

  private String title;

  @ManyToOne
  @JoinColumn(name = "professor_subject")
  private ProfessorEntity professor;

  @ManyToMany(mappedBy = "subjectEntityList")
  private List<StudentEntity> studentEntityList;
}

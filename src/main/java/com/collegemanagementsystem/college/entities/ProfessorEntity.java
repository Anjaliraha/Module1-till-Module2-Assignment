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
public class ProfessorEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long professorId;

  private String title;

  @OneToMany(mappedBy = "professor")
  private List<SubjectEntity> subjectEntityList;

  @ManyToMany(mappedBy = "professorEntities")
  private List<StudentEntity> studentEntitiesList;
}

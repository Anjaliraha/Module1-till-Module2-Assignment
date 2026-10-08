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
public class StudentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "Student_Professor",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "professor_id"))
  List<ProfessorEntity> professorEntities;

  @JoinTable(
      name = "Student_Subject",
      joinColumns = @JoinColumn(name = "student_id"),
      inverseJoinColumns = @JoinColumn(name = "subject_id"))
  @ManyToMany
  List<SubjectEntity> subjectEntityList;

  @OneToOne(mappedBy = "student")
  private AdmissionRecordEntity admissionRecordEntity;
}

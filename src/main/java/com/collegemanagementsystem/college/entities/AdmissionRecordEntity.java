package com.collegemanagementsystem.college.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecordEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long admissionRecordId;

  private Integer fees;

  @OneToOne
  @JoinColumn(nullable = false, name = "student_admission_record", unique = true)
  private StudentEntity student;
}

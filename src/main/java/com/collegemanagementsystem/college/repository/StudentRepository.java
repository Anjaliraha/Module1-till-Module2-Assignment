package com.collegemanagementsystem.college.repository;

import com.collegemanagementsystem.college.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {}

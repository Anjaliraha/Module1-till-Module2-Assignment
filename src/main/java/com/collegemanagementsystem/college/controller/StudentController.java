package com.collegemanagementsystem.college.controller;

import com.collegemanagementsystem.college.dto.StudentDto;
import com.collegemanagementsystem.college.exception.RecordNotFoundException;
import com.collegemanagementsystem.college.services.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "university/")
public class StudentController {
  @Autowired private StudentService studentService;

  @GetMapping("all/")
  public ResponseEntity<List<StudentDto>> getAllStudents() {
    List<StudentDto> studentDtos = studentService.getAllStudent();
    return ResponseEntity.ok(studentDtos);
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<StudentDto> getStudentByID(@PathVariable Long id) {
    StudentDto studentDto = studentService.getStudentByID(id);
    if (studentDto.getProfessorEntities().isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(studentDto);
  }

  @PostMapping
  public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto) {
    try {
      StudentDto studentDto1 = studentService.createStudent(studentDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(studentDto1);

    } catch (RecordNotFoundException ex) {
      return ResponseEntity.notFound().build();
    }
  }
}

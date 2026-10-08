package com.collegemanagementsystem.college.services;

import com.collegemanagementsystem.college.dto.StudentDto;
import com.collegemanagementsystem.college.entities.ProfessorEntity;
import com.collegemanagementsystem.college.entities.StudentEntity;
import com.collegemanagementsystem.college.entities.SubjectEntity;
import com.collegemanagementsystem.college.exception.RecordNotFoundException;
import com.collegemanagementsystem.college.repository.AdmissionRecordRepository;
import com.collegemanagementsystem.college.repository.ProfessorRepository;
import com.collegemanagementsystem.college.repository.StudentRepository;
import com.collegemanagementsystem.college.repository.SubjectRepository;
import java.util.Collections;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final ModelMapper modelMapper;
  private final AdmissionRecordRepository admissionRecordRepository;
  private final ProfessorRepository professorRepository;
  private final StudentRepository studentRepository;
  private final SubjectRepository subjectRepository;

  public StudentService(
      ModelMapper modelMapper,
      AdmissionRecordRepository admissionRecordRepository,
      ProfessorRepository professorRepository,
      StudentRepository studentRepository,
      SubjectRepository subjectRepository) {

    this.modelMapper = modelMapper;
    this.admissionRecordRepository = admissionRecordRepository;
    this.professorRepository = professorRepository;
    this.studentRepository = studentRepository;
    this.subjectRepository = subjectRepository;
  }

  public List<StudentDto> getAllStudent() {
    List<StudentEntity> students = studentRepository.findAll();

    return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
  }

  public StudentDto getStudentByID(Long id) {
    StudentEntity studentEntity = studentRepository.findById(id).get();
    return modelMapper.map(studentEntity, StudentDto.class);
  }

  public StudentDto createStudent(StudentDto studentDto) {

    StudentEntity student = modelMapper.map(studentDto, StudentEntity.class);

    List<Long> professorIDs =
        studentDto.getProfessorEntities() == null
            ? Collections.emptyList()
            : studentDto.getProfessorEntities().stream()
                .map(professor -> professor.getProfessorId())
                .toList();

    List<Long> subjectIDs =
        studentDto.getSubjectEntityList() == null
            ? Collections.emptyList()
            : studentDto.getSubjectEntityList().stream()
                .map(subject -> subject.getSubjectId())
                .toList();

    List<ProfessorEntity> professorEntities = professorRepository.findAllById(professorIDs);

    if (professorIDs.size() != professorEntities.size()) {
      List<Long> id =
          professorIDs.stream()
              .filter(professorID -> !professorEntities.contains(professorID))
              .toList();
      throw new RecordNotFoundException("One or more professor IDs: " + id + " are invalid.");
    }

    student.setProfessorEntities(professorEntities);

    List<SubjectEntity> subjectEntityList = subjectRepository.findAllById(subjectIDs);

    if (subjectIDs.size() != subjectEntityList.size()) {
      List<Long> id =
          subjectIDs.stream().filter(subjectId -> !subjectEntityList.contains(subjectId)).toList();
      throw new RecordNotFoundException("One or more subject IDs: " + id + " are invalid.");
    }

    student.setSubjectEntityList(subjectEntityList);

    StudentEntity savedStudent = studentRepository.save(student);

    return modelMapper.map(savedStudent, StudentDto.class);
  }

  private boolean isExists(Long studentId) {
    if (studentRepository.existsById(studentId)) {
      throw new IllegalArgumentException("Id already exists.");
    }
    return false;
  }
}

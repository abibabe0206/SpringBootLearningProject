package com.example.SpringBootLearningProject.simpleSpringBootProject.service;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.student.Student;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     *
     * @return all Students
     */
    public List<Student> getStudents() {
       return studentRepository.findAll();
    }


    /**
     *  creates new student
     * @param student
     */
    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findAllByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }

    /**
     * deletes' a student
     * @param studentId
     */
    public void deleteStudent(Long studentId) {

       boolean exists =  studentRepository.existsById(studentId);
       if (!exists) {
           throw new IllegalStateException(
                   "student with id " + studentId + " does not exists"
           );
       }
       studentRepository.deleteById(studentId);
    }

    /**
     * updates a student
     * with the @Transactional annotation, we do not need to write any sql query in our repository.
     * @param studentId
     * @param name
     * @param email
     */
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student wit id " + studentId + " does not exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findAllByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }

    /**
     * this is used when we did not yet have a database connection
     */
    /*public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Maraim",
                        "maraim.ok@gmail.com",
                        LocalDate.of(2000, Month.JULY, 5),
                        21
                )
        );
    }*/
}


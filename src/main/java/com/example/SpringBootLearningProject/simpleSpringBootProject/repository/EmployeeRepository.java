package com.example.SpringBootLearningProject.simpleSpringBootProject.repository;

import com.example.SpringBootLearningProject.simpleSpringBootProject.model.employes.Employee;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long>  {

    @Query("SELECT e from  Employee e where e.id = ?1")
    Optional<Employee> findEmployeeById(Long id);
}

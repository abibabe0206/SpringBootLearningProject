package com.example.SpringBootLearningProject.simpleSpringBootProject.service;


import com.example.SpringBootLearningProject.simpleSpringBootProject.exception.UserNotFoundException;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.employes.Employee;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.student.Student;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     *  creates new employee
     * @param employee
     */
    public Employee addNewEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    /**
     *
     * @return all Employees
     */
    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }


    /**
     *
     * @param employee
     * @return
     */
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * deletes' a employee
     * @param employeeId
     */
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    /**
     *
     * @param id
     * @return
     */
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(
                    () -> new UserNotFoundException(
                        "User by id " + id + " was not found"                )
        );
    }

}

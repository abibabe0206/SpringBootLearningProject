package com.example.SpringBootLearningProject.simpleSpringBootProject.service;


import com.example.SpringBootLearningProject.simpleSpringBootProject.exception.UserNotFoundException;
import com.example.SpringBootLearningProject.simpleSpringBootProject.model.employes.Employee;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
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
    /*@Transactional
    public Employee updateEmployee(Long employeeId, Employee employee) {

        Employee emp = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException(
                        "employee with id " + employeeId + " does not exist"
                ));
        return employeeRepository.save(employee);
    }*/

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
                        "User by id " + id + " was not found"
                    )
        );
    }

}

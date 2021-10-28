package com.example.SpringBootLearningProject.streamTest;



public class Employee {

    private int id;
    private String employeeName;
    private double salary;

    public Employee(int id, String employeeName, double salary) {
        this.id = id;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSalary() {
        return (int) salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double salaryIncrement(double salary) {
        double newSalary = 0;
        if (this.salary == 100000) {
            newSalary = this.salary + Math.pow(salary, 4);
        } else if (this.salary == 200000) {
            newSalary = this.salary + (2 * Math.pow(salary, 4));
        } else {
            newSalary = this.salary + (3 * Math.pow(salary, 4));
        }
        return newSalary;
    }

    public Employee findById(int id) {
        Employee employee = new Employee(id, "Roger",300000);
        return employee;
    }
}

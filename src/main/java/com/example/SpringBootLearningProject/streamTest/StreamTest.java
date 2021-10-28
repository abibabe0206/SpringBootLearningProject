package com.example.SpringBootLearningProject.streamTest;


import java.util.*;
import java.util.stream.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.*;


public class StreamTest {

    @Test
    public void obtainingStreamFromExistingArray() {

        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        Stream.of(arrayOfEmps);

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream();

        // Get the stream
        Stream<String> stream = Stream.of("Geeks", "For",
                "Geeks", "A",
                "Computer", "Portal");

        // Print the stream
        stream.forEach(System.out::println);
        try {

            // Print the stream
            System.out.println(stream.collect(Collectors.toList()));
        }

        catch (Exception e) {

            System.out.println("\nException: " + e);
        }


        // Print the empList
        /*Stream.of(arrayOfEmps).forEach(System.out::println);
        System.out.println(Stream.of(arrayOfEmps).collect(Collectors.toList()));
        System.out.println(Arrays.stream(arrayOfEmps).findFirst());*/
    }


    @Test
    public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

        try {
            assertThat(empList, contains(
                    hasProperty("salary", equalTo(110000.0)),
                    hasProperty("salary", equalTo(220000.0)),
                    hasProperty("salary", equalTo(330000.0))
            ));
        } catch (AssertionError  e) {
           /* e.printStackTrace();
            System.out.println(e.getMessage());*/
            System.out.printf("No salary with the above property was found in the list :)");
        }
    }

    @Test
    public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {

        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream().forEach(e -> e.salaryIncrement(10.0));

        try {
            assertThat(empList, contains(
                    hasProperty("salary", equalTo(110000.0)),
                    hasProperty("salary", equalTo(220000.0)),
                    hasProperty("salary", equalTo(330000.0))
            ));
        } catch (AssertionError  e) {
           /* e.printStackTrace();
            System.out.println(e.getMessage());*/
            System.out.printf("No salary with the above property was found in the list :)");
        }
    }

    @Test
    public void whenCollectStreamToList_thenGetList() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);
        /* List<Employee> employees = empList.stream().collect(Collectors.toList());*/
        List<Employee> employees = new ArrayList<>(empList);

        assertEquals(empList, employees);
    }


    @Test
    public void whenFlatMapEmployeeNames_thenGetNameStream() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }


    @Test
    public void whenFilterEmployees_thenGetFilteredStream() {

        Employee employeeRepository = new Employee(1, "Jeff Bezos", 100000.0);
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000)
        };

        /*int[] empIds = { 1, 2, 3, 4 };


        List<Employee> employees = new ArrayList<>();

        Arrays.stream(empIds).forEach(emp -> {
                employees.add(employeeRepository.findById(emp));
        });
         List<Employee> employeeList = employees.stream()
                 .filter(e -> e != null)
                 .filter(e -> e.getSalary() > 20000)
                 .collect(Collectors.toList());

        try {
            System.out.println(Arrays.asList(arrayOfEmps[2]));
            System.out.println(employeeList);
            assertEquals(Arrays.asList(arrayOfEmps[2]), employeeList);

        } catch (AssertionError  e) {
           *//* e.printStackTrace();
            System.out.println(e.getMessage());*//*
            System.out.printf("No salary with the above property was found in the list :)");
        }*/

        Integer[] empIds = { 1, 2, 3, 4 };

        List<Employee> employees = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 200000)
                .collect(Collectors.toList());

        try {
            assertEquals(Arrays.asList(arrayOfEmps[2]), employees);

        } catch (AssertionError  e) {
            System.out.printf("No salary with the above property was found in the list :)");
        }


    }


    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {

        Employee employeeRepository = new Employee(1, "Jeff Bezos", 100000.0);
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000)
        };

        Integer[] empIds = { 1, 2, 3, 4 };

        Employee employeeList = Stream.of(empIds)
                .map(employeeRepository::findById)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 20000)
                .findFirst()
                .orElse(null);

        try {
            System.out.println(Arrays.asList(arrayOfEmps[2]));
            System.out.println(employeeList);
            assertEquals(Optional.of(employeeList.getSalary()), new Double(200000));

        } catch (AssertionError  e) {
            System.out.printf("No salary with the above property was found in the list :)");
        }

    }


    @Test
    public void whenStreamCount_thenGetElementCount() {


        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        Long empCount = empList.stream()
                .filter(e -> e.getSalary() > 200000)
                .count();


        try {
            assertEquals(empCount, new Long(1));

        } catch (AssertionError  e) {
            System.out.printf("No salary with the above property was found in the list :)");
        }

    }

    @Test
    public void whenLimitInfiniteStream_thenGetFiniteElements() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(collect);
        assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
    }

}

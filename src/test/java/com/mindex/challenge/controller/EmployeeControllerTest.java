package com.mindex.challenge.controller;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class EmployeeControllerTest {

    private EmployeeController employeeController;
    private EmployeeRepository mockEmployeeRepository;

    @BeforeEach
    public void setupEmployeeController() {
        mockEmployeeRepository = mock(EmployeeRepository.class);
        employeeController = new EmployeeController();
    }

//    @Test
//    void getReportsNoReports() {
//        List<Employee> testData = new ArrayList<>();
//        Employee employee1 = new Employee();
//        employee1.setEmployeeId("1");
//        employee1.setDepartment("testDept1");
//        employee1.setPosition("testPos1");
//        employee1.setFirstName("testFName");
//        employee1.setLastName("testLName");
//        employee1.setDirectReports(null);
//        testData.add(employee1);
//    }
}
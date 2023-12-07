package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);

        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }

    /**
     * Gets the report count for a specified employee
     * @param id the id of the employee to get the report count for
     * @return the reporting structure of the specified employee
     */
    @GetMapping("/employee/reports/{id}")
    public ReportingStructure getReports(@PathVariable String id) {
        LOG.debug("Received employee number of reports request for id [{}]", id);
        int maxReports = recursiveReports(id);
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(id);
        reportingStructure.setNumberOfReports(maxReports);
        return reportingStructure;

    }

    /**
     * Recursively searches an employee for their direct reports
     * @param id the id of the employee to search
     * @return the count of employee reports
     */
    private int recursiveReports(String id) {
        // Gets the current employee
        Employee curEmployee = employeeService.read(id);
        // Gets that employees direct reports
        List<Employee> directReports = curEmployee.getDirectReports();
        // Sets the counter to 0
        int currCount = 0;
        if (directReports == null) { // If there are no direct reports, return 0
            return 0;
        } else { // else, search the reports for their own reports
            for (Employee employee : directReports) {
                // This report counts as one and add any other reports under them
                currCount += recursiveReports(employee.getEmployeeId()) + 1;
            }
        }
        return currCount;
    }
}

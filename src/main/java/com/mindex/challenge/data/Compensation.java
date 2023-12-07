package com.mindex.challenge.data;

public class Compensation {

    // The id of the employee
    private String employee;
    // The salary of the employee
    private int salary;
    // The effective date of the employee
    private String effectiveDate;

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}

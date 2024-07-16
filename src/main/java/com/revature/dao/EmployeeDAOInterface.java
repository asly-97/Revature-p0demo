package com.revature.dao;

import com.revature.model.Employee;

import java.util.List;

public interface EmployeeDAOInterface {

    List<Employee> getAllEmployee();

    Employee addEmployee(Employee emp);

    //Employee getEmployeeById(int emp_id);
}

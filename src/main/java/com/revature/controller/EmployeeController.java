package com.revature.controller;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.EmployeeDAOInterface;
import com.revature.model.Employee;
import io.javalin.http.Handler;

public class EmployeeController {

    public Handler getAllEmployee = ctx ->{

        EmployeeDAOInterface employeeDAO = new EmployeeDAOImpl();

        ctx.json(employeeDAO.getAllEmployee());

        ctx.status(202);

    };

    public Handler addEmployee = ctx-> {

        Employee emp = ctx.bodyAsClass(Employee.class);

        EmployeeDAOInterface employeeDAO = new EmployeeDAOImpl();

        //employeeDAO.addEmployee(emp);

        ctx.status(201);
        //ctx.result("Hi------- "+ctx.body());
        ctx.result(ctx.body()+" \n -------- \n "+emp);

    };

}

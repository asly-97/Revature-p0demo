package com.revature;

import com.revature.controller.EmployeeController;
import com.revature.controller.RoleController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        try (Connection con = ConnectionUtil.getConnection()){
            System.out.println("Database Connected Successfully ");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        var app = Javalin.create().start(3000);

        app.get("/",ctx-> ctx.result("Hello Asly!"));

        EmployeeController ec = new EmployeeController();

        app.get("/employee",ec.getAllEmployee);

        app.post("/employee",ec.addEmployee);

        RoleController rc =  new RoleController();

        app.get("/role/{id}",rc.getRoleById);


    }
}
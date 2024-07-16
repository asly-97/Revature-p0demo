package com.revature.dao;

import com.revature.model.Employee;
import com.revature.model.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAOInterface{

    RoleDAOImpl roleDAO;

    public EmployeeDAOImpl() {
        roleDAO = new RoleDAOImpl();
    }

    @Override
    public List<Employee> getAllEmployee() {

        try(Connection con = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM employees";

            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery(sql);

            List<Employee> employeeList = new ArrayList<>();

            while(rs.next()){

                int role_id = rs.getInt("role_id_fk");
                Employee emp =  new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        roleDAO.getRoleById(role_id)

                );
                employeeList.add(emp);
            }


            return employeeList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee addEmployee(Employee emp) {

        try(Connection con = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO employees(first_name, last_name, role_id_fk)\n" +
                    "VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,emp.getFirst_name());
            ps.setString(2,emp.getLast_name());
            ps.setInt(3,emp.getRole_id_fk());

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }
}

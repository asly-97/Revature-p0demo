package com.revature.dao;

import com.revature.model.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAOInterface{
    @Override
    public Role getRoleById(int role_id) {
        try(Connection con = ConnectionUtil.getConnection()){

            String sql = "select * from roles where role_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,role_id);

            ResultSet rs = ps.executeQuery();

            Role role = null;
            while (rs.next()){
                role = new Role(
                        role_id,
                        rs.getString("role_title"),
                        rs.getInt("role_salary")
                );
            }

            return role;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

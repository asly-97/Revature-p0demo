package com.revature.controller;

import com.revature.dao.RoleDAOImpl;
import com.revature.dao.RoleDAOInterface;
import com.revature.model.Role;
import io.javalin.http.Handler;

public class RoleController {

    RoleDAOInterface roleDAO = new RoleDAOImpl();

    public Handler getRoleById = ctx ->{

        int role_id = Integer.parseInt(ctx.pathParam("id"));

        Role role = roleDAO.getRoleById(role_id);

        if(role != null){
            ctx.status(202);
            ctx.json(role);
        }
        else{
            ctx.status(404);
            ctx.result("Role Not Found");
        }

    };

}

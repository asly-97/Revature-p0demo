package com.revature.model;

public class Role {
    private int role_id;
    private String role_title;
    private int role_salary;

    public Role() {
    }

    public Role(int role_id, String role_title, int role_salary) {
        this.role_id = role_id;
        this.role_title = role_title;
        this.role_salary = role_salary;
    }

    public int getRole_salary() {
        return role_salary;
    }

    public String getRole_title() {
        return role_title;
    }

    public int getRole_id() {
        return role_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_title='" + role_title + '\'' +
                ", role_salary=" + role_salary +
                '}';
    }
}

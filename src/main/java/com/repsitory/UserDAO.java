package com.repsitory;

import java.sql.PreparedStatement;

import com.model.Users;
public class UserDAO extends DBConnection {

    public boolean register(Users user) {
        try {
            
            String sql = "INSERT INTO users(fullname,email,contact,username,password) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getContact());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());

            int rows = ps.executeUpdate();

            System.out.println("Inserted = " + rows);

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
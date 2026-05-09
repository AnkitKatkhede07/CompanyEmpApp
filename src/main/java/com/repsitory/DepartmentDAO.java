package com.repsitory;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.model.Department;

public class DepartmentDAO  extends DBConnection{
	public boolean addDepartment(Department d) {
	       try {
	      
	           String sql = "INSERT INTO department(dept_name) VALUES(?)";
	           PreparedStatement ps = con.prepareStatement(sql);
	           ps.setString(1, d.getDeptName());
	           return ps.executeUpdate() > 0;
	       } catch (SQLIntegrityConstraintViolationException e) {
	           // duplicate name
	           return false;
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return false;
	   }

	   public List<Department> getAll() {
	       List<Department> list = new ArrayList<>();
	       try {
	           String sql = "SELECT * FROM department ORDER BY dept_id";
	           PreparedStatement ps = con.prepareStatement(sql);
	           ResultSet rs = ps.executeQuery();

	           while (rs.next()) {
	               Department d = new Department();
	               d.setDeptId(rs.getInt("dept_id"));
	               d.setDeptName(rs.getString("dept_name"));
	               list.add(d);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return list;
	   }

	   public boolean delete(int id) {
	       try {
	           PreparedStatement ps = con.prepareStatement(
	               "DELETE FROM department WHERE dept_id=?"
	           );
	           ps.setInt(1, id);
	           return ps.executeUpdate() > 0;
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return false;
	   }

	   public boolean update(Department d) {
	       try {
	           PreparedStatement ps = con.prepareStatement(
	               "UPDATE department SET dept_name=? WHERE dept_id=?"
	           );
	           ps.setString(1, d.getDeptName());
	           ps.setInt(2, d.getDeptId());
	           return ps.executeUpdate() > 0;
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return false;
	   }
	   public List<String[]> getAllEmployees() {
		    List<String[]> list = new ArrayList<>();

		    try {
		        Connection con = DBConnection.getConnection();

		        String sql = "SELECT e.emp_id, e.name, e.email, e.contact, d.dept_name " +
		                     "FROM employee e JOIN department d ON e.dept_id = d.dept_id";

		        PreparedStatement ps = con.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();

		        while (rs.next()) {
		            String[] data = new String[5];
		            data[0] = rs.getString("emp_id");
		            data[1] = rs.getString("name");
		            data[2] = rs.getString("email");
		            data[3] = rs.getString("contact");
		            data[4] = rs.getString("dept_name");

		            list.add(data);
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
	}


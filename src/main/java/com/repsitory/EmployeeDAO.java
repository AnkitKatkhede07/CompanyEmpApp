package com.repsitory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class EmployeeDAO extends DBConnection {
	
	public boolean addEmployee(Employee emp) {

	    try {

	        String sql =
	        "INSERT INTO employee(name,email,contact,dept_id) VALUES(?,?,?,?)";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, emp.getName());
	        ps.setString(2, emp.getEmail());
	        ps.setString(3, emp.getContact());
	        ps.setInt(4, emp.getDeptId());

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	public List<String[]> getAllEmployees() {

	    List<String[]> list = new ArrayList<>();

	    try {


	        String sql =
	        "SELECT e.emp_id, e.name, e.email, e.contact, d.dept_name " +
	        "FROM employee e LEFT JOIN department d " +
	        "ON e.dept_id = d.dept_id";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {

	            String[] data = new String[5];

	            data[0] = rs.getString("emp_id");
	            data[1] = rs.getString("name");
	            data[2] = rs.getString("email");
	            data[3] = rs.getString("contact");
	            data[4] = rs.getString("dept_name");

	            list.add(data);

	            System.out.println("Employee Found");
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	///
	
	 public List<String[]> searchEmployees(String keyword) {
	        List<String[]> list = new ArrayList<>();

	        try {
	            String sql =
	                "SELECT e.emp_id, e.name, e.email, e.contact, d.dept_name " +
	                "FROM employee e LEFT JOIN department d ON e.dept_id = d.dept_id " +
	                "WHERE e.name LIKE ? OR e.email LIKE ? OR e.contact LIKE ? OR d.dept_name LIKE ? " +
	                "ORDER BY e.emp_id";

	            PreparedStatement ps = con.prepareStatement(sql);
	            String key = "%" + keyword + "%";
	            ps.setString(1, key);
	            ps.setString(2, key);
	            ps.setString(3, key);
	            ps.setString(4, key);

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

	    public boolean deleteEmployee(int id) {
	        try {
	            String sql = "DELETE FROM employee WHERE emp_id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public Employee getEmployeeById(int id) {
	        try {
	            String sql = "SELECT * FROM employee WHERE emp_id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                Employee emp = new Employee();
	                emp.setEmpId(rs.getInt("emp_id"));
	                emp.setName(rs.getString("name"));
	                emp.setEmail(rs.getString("email"));
	                emp.setContact(rs.getString("contact"));
	                emp.setDeptId(rs.getInt("dept_id"));
	                return emp;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public boolean updateEmployee(Employee emp) {
	        try {
	            String sql = "UPDATE employee SET name=?, email=?, contact=?, dept_id=? WHERE emp_id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, emp.getName());
	            ps.setString(2, emp.getEmail());
	            ps.setString(3, emp.getContact());
	            ps.setInt(4, emp.getDeptId());
	            ps.setInt(5, emp.getEmpId());

	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	}
	

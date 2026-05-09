
package com.service;

import java.util.List;

import com.model.Employee;
import com.repsitory.EmployeeDAO;

public class EmployeeService {

    EmployeeDAO dao = new EmployeeDAO();

    public boolean saveEmployee(Employee emp) {
        return dao.addEmployee(emp);
    }

    public List<String[]> getAll() {
        return dao.getAllEmployees();
    }
    public List<String[]> search(String keyword) {
        return dao.searchEmployees(keyword);
    }

    public boolean remove(int id) {
        return dao.deleteEmployee(id);
    }

    public Employee findById(int id) {
        return dao.getEmployeeById(id);
    }

    public boolean update(Employee emp) {
        return dao.updateEmployee(emp);
    }
}
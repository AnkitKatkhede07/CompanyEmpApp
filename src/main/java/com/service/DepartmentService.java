package com.service;

import java.util.List;

import com.model.Department;
import com.repsitory.DepartmentDAO;

public class DepartmentService {
	 private DepartmentDAO dao = new DepartmentDAO();

	   public boolean save(Department d) {
	       return dao.addDepartment(d);
	   }

	   public List<Department> list() {
	       return dao.getAll();
	   }

	   public boolean remove(int id) {
	       return dao.delete(id);
	   }

	   public boolean edit(Department d) {
	       return dao.update(d);
	   }
	   public List<String[]> getAll() {
		    return dao.getAllEmployees();
		}


}

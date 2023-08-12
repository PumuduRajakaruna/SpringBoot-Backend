package com.backend.springbootBackend.service;

import com.backend.springbootBackend.entity.Department;
import com.backend.springbootBackend.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department FetchDepartmentById(Long departmentID) throws DepartmentNotFoundException;

    public void DeleteDepartmentById(Long departmentID);

    public Department UpdateDepartment(Long departmentID, Department department);

    public Department FetchDepartmentByName(String departmentName);
}

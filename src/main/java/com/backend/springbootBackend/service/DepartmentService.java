package com.backend.springbootBackend.service;

import com.backend.springbootBackend.entity.Department;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department FetchDepartmentById(Long departmentID);

    public void DeleteDepartmentById(Long departmentID);
}

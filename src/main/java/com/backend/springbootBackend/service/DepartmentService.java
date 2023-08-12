package com.backend.springbootBackend.service;

import com.backend.springbootBackend.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();
}

package com.backend.springbootBackend.service;

import com.backend.springbootBackend.entity.Department;
import com.backend.springbootBackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department FetchDepartmentById(Long departmentID) {
        return departmentRepository.findById(departmentID).get();
    }

    @Override
    public void DeleteDepartmentById(Long departmentID) {
        departmentRepository.deleteById(departmentID);
    }
}

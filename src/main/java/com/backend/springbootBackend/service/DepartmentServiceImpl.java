package com.backend.springbootBackend.service;

import com.backend.springbootBackend.entity.Department;
import com.backend.springbootBackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Department UpdateDepartment(Long departmentID, Department department) {
        Department updateDep = departmentRepository.findById(departmentID).get();
        
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            updateDep.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            updateDep.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            updateDep.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(updateDep);
    }
}

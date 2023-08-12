package com.backend.springbootBackend.controller;

import com.backend.springbootBackend.entity.Department;
import com.backend.springbootBackend.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
           return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department FetchDepartmentById(@PathVariable("id") Long departmentID){
        return departmentService.FetchDepartmentById(departmentID);
    }
    @DeleteMapping("/departments/{id}")
    public String DeleteDepartmentById(@PathVariable("id") Long departmentID){
        departmentService.DeleteDepartmentById(departmentID);
        return "Department was successfully deleted";
    }
    @PutMapping("/departments/{id}")
    public Department UpdateDepartment(@PathVariable("id") Long departmentID,
                                   @RequestBody Department department){
        return departmentService.UpdateDepartment(departmentID, department);
    }
    @GetMapping("/departments/name/{name}")
    public Department FetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.FetchDepartmentByName(departmentName);
    }
}


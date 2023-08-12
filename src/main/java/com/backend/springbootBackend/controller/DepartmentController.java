package com.backend.springbootBackend.controller;

import com.backend.springbootBackend.entity.Department;
import com.backend.springbootBackend.error.DepartmentNotFoundException;
import com.backend.springbootBackend.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
           LOGGER.info("Inside saveDepartment of DepartmentController");
           return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department FetchDepartmentById(@PathVariable("id") Long departmentID) throws DepartmentNotFoundException {
        LOGGER.info("Inside FetchDepartmentById of DepartmentController");
        return departmentService.FetchDepartmentById(departmentID);
    }
    @DeleteMapping("/departments/{id}")
    public String DeleteDepartmentById(@PathVariable("id") Long departmentID){
        LOGGER.info("Inside DeleteDepartmentById of DepartmentController");
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


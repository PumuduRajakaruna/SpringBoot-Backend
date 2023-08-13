package com.backend.springbootBackend.repository;

import com.backend.springbootBackend.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.zip.DeflaterOutputStream;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("CS")
                .departmentAddress("Peradeniya")
                .departmentCode("IT209")
                .build();
        entityManager.persist(department);
    }
    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals("CS", department.getDepartmentName());
    }
}
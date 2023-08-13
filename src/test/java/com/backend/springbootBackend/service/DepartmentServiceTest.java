package com.backend.springbootBackend.service;

import com.backend.springbootBackend.entity.Department;
import com.backend.springbootBackend.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("IT")
                                                    .departmentAddress("Peradeniya")
                                                     .departmentCode("IT209")
                                                     .departmentId(3L)
                                                      .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_DepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = departmentService.FetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
//        assertNotEquals(departmentName, found.getDepartmentName());
    }
}
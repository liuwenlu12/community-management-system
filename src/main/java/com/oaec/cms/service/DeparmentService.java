package com.oaec.cms.service;

import com.oaec.cms.entity.Department;

import java.util.List;

public interface DeparmentService {

    List<Department> getDepartments(String name,Integer page);
    List<Department> getAllDepartments();
    Boolean insert(Department department);
    Boolean update(Department department);
    Boolean delete(Integer departmentId,Integer status);
}

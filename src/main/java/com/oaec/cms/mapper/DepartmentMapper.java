package com.oaec.cms.mapper;

import com.oaec.cms.entity.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface DepartmentMapper {
     List<Department> query(Map<String,Object> param);
     int doInsert(Department department);
     int doUpdate(Department department);
     int doDelete(Integer departmentId);
     int doNotDelete(Integer departmentId);
}

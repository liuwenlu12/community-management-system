package com.oaec.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Department;
import com.oaec.cms.mapper.DepartmentMapper;
import com.oaec.cms.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("deparmentService")
public class DepartmentServiceImpl implements DeparmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getDepartments(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return departmentMapper.query(param);
    }

    @Override
    public List<Department> getAllDepartments() {
        Map<String, Object> param = new HashMap<>();
        param.put("status",1);
        return departmentMapper.query(param);
    }

    @Override
    public Boolean insert(Department department) {
        return departmentMapper.doInsert(department)==1;
    }

    @Override
    public Boolean update(Department department) {
        return departmentMapper.doUpdate(department)==1;
    }

    @Override
    public Boolean delete(Integer departmentId,Integer status) {
        if(status==1){
            return departmentMapper.doDelete(departmentId)==1;
        }else{
            return departmentMapper.doNotDelete(departmentId)==1;
        }
    }
}

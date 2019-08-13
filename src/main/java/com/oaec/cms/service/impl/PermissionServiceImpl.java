package com.oaec.cms.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Permission;
import com.oaec.cms.mapper.PermissionMapper;
import com.oaec.cms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
  /*  @Override
    public List<Permission> getPermission(Integer adminId) {
        return permissionMapper.queryPermissionByRoleId(adminId);
    }
*/
    @Override
    public List<Permission> getPermissions(String name,Integer page) {
      Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return permissionMapper.query(param);
    }

    @Override
    public List<Permission> getAdminPermissions(Integer adminId) {
        return permissionMapper.queryPermissionLevle1(adminId);
    }

    @Override
    public List<Permission> getPermissionList() {

        return permissionMapper.queryPermissionLevle1List();
    }


    @Override
    public Boolean delete(Integer permissionId, Integer status) {
        Map<String, Object> param = new HashMap<>();
        param.put("permissionId",permissionId);
        param.put("status",status);
        return permissionMapper.doEditStatus(param)==1;
    }

    @Override
    public Boolean insert(Permission permission) {
        return permissionMapper.doInsert(permission)==1;
    }

    @Override
    public Boolean update(Permission permission) {
        return permissionMapper.doUpdate(permission)==1;
    }
}

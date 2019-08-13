package com.oaec.cms.service.impl;


import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Role;
import com.oaec.cms.mapper.RoleMapper;
import com.oaec.cms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRole(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return roleMapper.query(param);
    }

    @Override
    public List<Role> getAllRole() {
        Map<String, Object> param = new HashMap<>();
        param.put("status",1);
        return roleMapper.query(param);
    }

    @Override
    public Role insert(Role role) {
        roleMapper.doInsert(role);
        return role;
    }

    @Override
    public Boolean insertRolePermission(Integer roleId, Integer[] permissionIds) {
        int result = 0;
        for (Integer permissionId : permissionIds) {
            result+= roleMapper.doInsertRolePermission(roleId,permissionId);
        }
        return result>0;
    }

    @Override
    public Boolean update(Role role, Integer[] permissionIds) {
        Integer roleId = role.getRoleId();
        roleMapper.doDeleteRolePermission(roleId);
        for (Integer permissionId : permissionIds) {
            roleMapper.doInsertRolePermission(roleId,permissionId);
        }
        return roleMapper.doUpdate(role)==1;
    }

    @Override
    public Boolean delete(Integer roleId,Integer status) {
        if(status==1){
         return    roleMapper.doDelete(roleId)==1;
        }else{
         return    roleMapper.doNotDelete(roleId)==1;
        }
    }
}

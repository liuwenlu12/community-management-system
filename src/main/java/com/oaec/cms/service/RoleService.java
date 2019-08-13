package com.oaec.cms.service;

import com.oaec.cms.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRole(String name,Integer page);
    List<Role> getAllRole();
    Role insert(Role role);
    Boolean insertRolePermission(Integer roleId,Integer[] permissionId);
    Boolean update(Role role,Integer[] permissionIds);
    Boolean delete(Integer roleId,Integer status);

}

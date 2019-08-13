package com.oaec.cms.service;

import com.oaec.cms.entity.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
/*
    List<Permission> getPermission(Integer adminId);
*/

    List<Permission> getPermissions(String name,Integer page);
    List<Permission> getAdminPermissions(Integer adminId);
    List<Permission> getPermissionList();
    Boolean delete(Integer permissionId,Integer status);
    Boolean insert(Permission permission);
    Boolean update(Permission permission);
}

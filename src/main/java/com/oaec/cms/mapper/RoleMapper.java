package com.oaec.cms.mapper;

import com.oaec.cms.entity.Permission;
import com.oaec.cms.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RoleMapper {
    List<Role> query(Map<String,Object> param);
    int doInsert(Role role);
    int doInsertRolePermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);
    int doUpdate(Role role);
    int doDeleteRolePermission(Integer roleId);
    int doDelete(Integer roleId);
    int doNotDelete(Integer roleId);



}

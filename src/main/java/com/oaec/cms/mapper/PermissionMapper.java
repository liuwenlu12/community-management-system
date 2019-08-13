package com.oaec.cms.mapper;

import com.oaec.cms.entity.Permission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PermissionMapper {
/*
    List<Permission> queryPermissionByRoleId(Integer adminId);
*/

    List<Permission> query(Map<String,Object> param);

    List<Permission> queryPermissionLevle1(Integer adminId);
    List<Permission>  queryPermissionLevle2(Map<String,Object> param);

    List<Permission> queryPermissionLevle1List();
    List<Permission>  queryPermissionLevle2List(Integer permissionId);

    int doEditStatus(Map<String,Object> param);
    int doUpdate(Permission permission);
    int doInsert(Permission permission);

}

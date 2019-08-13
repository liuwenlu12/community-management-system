package com.oaec.cms.mapper;

import com.oaec.cms.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AdminMapper {

    Admin queryByName(String name);

    List<Admin> query(Map<String,Object> param);

    int doInsert(Admin admin);

    Admin queryByTel(String telNumber);
    Admin queryByEmail(String email);
    int doDeleteAdminRole( Integer adminId);
    int doDelete(Integer adminId);
    int doNotDelete(Integer adminId);
    int doUpdate(Admin admin);
    int doInsertRole2Admin(@Param("adminId") Integer adminId,@Param("roleId") Integer roleId);
    Admin queryById(Integer adminId);
    int doUpdatePassWord(Map<String,Object> param);
}

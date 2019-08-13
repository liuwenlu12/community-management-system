package com.oaec.cms.service;

import com.oaec.cms.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin login(String name, String password);
    List<Admin> getAdmin(String name,Integer page);
     Admin insert(Admin admin);
     Boolean  isRepeat(Admin admin);
     Boolean delete(Integer adminId,Integer status);
     Boolean insertRole2Admin(Integer adminId,Integer[] roleIds);
     Boolean update(Admin admin,Integer[] roleIds);
     Boolean updatePassWord(Integer adminId,String oldPass ,String name,String newPass);
}

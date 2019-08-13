package com.oaec.cms.service.impl;


import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Admin;
import com.oaec.cms.exception.HelloException;
import com.oaec.cms.mapper.AdminMapper;
import com.oaec.cms.service.AdminService;
import com.oaec.cms.util.ExceptionCode;
import com.oaec.cms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String name, String password) {
        Admin admin = adminMapper.queryByName(name);
        if(admin==null){
            /*throw new HelloException(102,"用户名不存在");*/
            throw new HelloException(ExceptionCode.USERNAME_NOT_EXISTS);
        }
        String ps = admin.getPassword();
        String md5 = MD5Util.getMd5(name.concat(password));
        if(!ps.equals(md5)){
            throw new HelloException(ExceptionCode.INVALID_PASSWORD);
        }
        admin.setPassword(null);
        return admin;
    }

    @Override
    public  List<Admin> getAdmin(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return adminMapper.query(param);
    }

    @Override
    public Admin insert(Admin admin) {
        String name = admin.getName();
        String password = admin.getPassword();
        admin.setPassword(MD5Util.getMd5(name.concat(password)));
        adminMapper.doInsert(admin);
        return admin;
    }

    @Override
    public Boolean isRepeat(Admin admin) {
        String name = admin.getName();
        String telNumber = admin.getTelNumber();
        String email = admin.getEmail();
        Admin admin1 = adminMapper.queryByName(name);
        Admin admin2 = adminMapper.queryByTel(telNumber);
        Admin admin3 = adminMapper.queryByEmail(email);
        if(admin1!=null){
            throw new HelloException(ExceptionCode.USERNAME_ALREADY_EXISTS);
        }else if(admin2!=null){
            throw new HelloException(ExceptionCode.TEL_NUMBER_ALREADY_EXISTS);
        }else if(admin3!=null){
            throw new HelloException(ExceptionCode.EMAIL_ALREADT_EXISTS);
        }
        return true;
    }

    @Override
    public Boolean delete(Integer adminId,Integer status) {
        if(status==1){
            return adminMapper.doDelete(adminId)==1;
        }else{
            return adminMapper.doNotDelete(adminId)==1;
        }
    }

    @Override
    public Boolean insertRole2Admin(Integer adminId, Integer[] roleIds) {
        int result = 0;
        for (Integer roleId : roleIds) {
           result+= adminMapper.doInsertRole2Admin(adminId,roleId);
        }
        return result>0;
    }

    @Override
    public Boolean update(Admin admin,Integer[] roleIds) {
        Integer adminId = admin.getAdminId();
            adminMapper.doDeleteAdminRole(adminId);
        for (Integer roleId : roleIds) {
            adminMapper.doInsertRole2Admin(adminId,roleId);
        }
        return adminMapper.doUpdate(admin)==1;
    }

    @Override
    public Boolean updatePassWord(Integer adminId,String oldPass,String name ,String newPass) {
        Admin admin = adminMapper.queryById(adminId);
        String md5 = MD5Util.getMd5(name.concat(oldPass));
        if(!admin.getPassword().equalsIgnoreCase(md5)){
            throw new HelloException(ExceptionCode.OLD_PASS_ERROR);
        }else{
            Map<String, Object> param = new HashMap<>();
            param.put("adminId",adminId);
            String newPassWord = MD5Util.getMd5(name.concat(newPass));
            param.put("newPass",newPassWord);
            return adminMapper.doUpdatePassWord(param)==1;
        }


    }
}

package com.oaec.cms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.oaec.cms.entity.Admin;
import com.oaec.cms.entity.Permission;
import com.oaec.cms.entity.Role;
import com.oaec.cms.service.AdminService;
import com.oaec.cms.service.PermissionService;
import com.oaec.cms.service.RoleService;
import com.oaec.cms.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    private Logger logger =  LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result login(String name, String password, HttpSession session){
        Admin admin = adminService.login(name, password);
        session.setAttribute("admin",admin);
      /*  Integer adminId = admin.getAdminId();
        List<Permission> permissionList = permissionService.getPermission(adminId);
        session.setAttribute("permissionList",permissionList);*/
        return new Result("登陆成功");
    }
    @GetMapping("/logout")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String admin(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<Admin> adminList = adminService.getAdmin(name, page);
        model.addAttribute("adminList",adminList);
        if(adminList instanceof Page){
            Page adminPage = (Page)adminList;
            int pageNum = adminPage.getPageNum();
            int pages = adminPage.getPages();
            int pageTotal = (int)adminPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "admin-list";
    }
    @GetMapping("/admin/add")
    public String adminAdd(Model model){
        List<Role> roleList = roleService.getAllRole();
       model.addAttribute("roleList",roleList);
        return "admin-add";
    }
    @PostMapping(value = "/admin/add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminAdd(Admin admin,Integer[] roleId){
        Boolean isRepeat = adminService.isRepeat(admin);
        if(isRepeat){
            Admin admin1 = adminService.insert(admin);
            Integer adminId = admin1.getAdminId();
            adminService.insertRole2Admin(adminId, roleId);
        }
        return new Result("添加成功");
    }



    @PostMapping(value = "/admin/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminDel(Integer adminId){
        adminService.delete(adminId,1);
        return new Result("删除成功");
    }

    @PostMapping(value = "/admin/status/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminStatusEdit(Integer adminId,Integer status){
        adminService.delete(adminId,status);
        return new Result("修改状态成功");
    }
    @GetMapping("/admin/edit")
    public String adminEdit(Model model){
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("roleList",roleList);
        return "admin-edit";
    }

    @PostMapping(value = "/admin/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminEdit(Admin admin,Integer[] roleId){
        adminService.update(admin,roleId);
        return new Result("修改成功");
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


    @GetMapping("/admin/password")
    public String adminPassword(){
        return "admin-password";
    }
    @PostMapping(value = "/admin/password",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminPassword(Integer adminId,String oldPass,String name,String newPass){
        Boolean update = adminService.updatePassWord(adminId, oldPass, name, newPass);
        if(update){
            return new Result("修改成功");
        }
       return new Result("修改失败");
    }


}

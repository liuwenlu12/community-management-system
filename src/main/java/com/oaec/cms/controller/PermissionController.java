package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Admin;
import com.oaec.cms.entity.Permission;
import com.oaec.cms.service.PermissionService;
import com.oaec.cms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/permission")
    public String permission(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<Permission> permissionList = permissionService.getPermissions(name,page);
        model.addAttribute("permissionList",permissionList);
        if(permissionList instanceof Page){
            Page permissionPage = (Page)permissionList;
            int pageNum = permissionPage.getPageNum();
            int pages = permissionPage.getPages();
            int pageTotal = (int)permissionPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "admin-rule";
    }

    @GetMapping("/index")
    public String index(HttpSession session, Model model){
        Admin admin = (Admin) session.getAttribute("admin");
        Integer adminId = admin.getAdminId();
        List<Permission> permissionList = permissionService.getAdminPermissions(adminId);
        model.addAttribute("permissionList",permissionList);
        return "index";
    }

    @PostMapping(value = "/permission/status/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminStatusEdit(Integer permissionId, Integer status){
        permissionService.delete(permissionId,status);
        return new Result("修改状态成功");
    }
    @GetMapping("/permission/add/edit")
    public String departmentAddOrEdit(){
        return "permission-add-edit";
    }
    @PostMapping(value = "/permission/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result departmentAddOrEdit(Permission permission){
        if(permission.getPermissionId()!=null){
            permissionService.update(permission);
            return  new Result("修改成功");

        }else{
            permissionService.insert(permission);
            return  new  Result("添加成功");
        }
    }

}

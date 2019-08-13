package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Department;
import com.oaec.cms.entity.Permission;
import com.oaec.cms.entity.Role;
import com.oaec.cms.service.DeparmentService;
import com.oaec.cms.service.PermissionService;
import com.oaec.cms.service.RoleService;
import com.oaec.cms.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private DeparmentService deparmentService;
    @GetMapping("/role")
    public String role(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<Role> roleList = roleService.getRole(name,page);
        model.addAttribute("roleList",roleList);
        if(roleList instanceof Page){
            Page rolePage = (Page)roleList;
            int pageNum = rolePage.getPageNum();
            int pages = rolePage.getPages();
            int pageTotal = (int)rolePage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "admin-role";
    }
    @GetMapping("/role/add/edit")
    public String roleAddOrEdit(Model model){
        List<Permission> permissionList = permissionService.getPermissionList();
        model.addAttribute("permissionList",permissionList);
        List<Department> departmentsList = deparmentService.getAllDepartments();
        model.addAttribute("departmentsList",departmentsList);

        return "role-add-edit";
    }

    @PostMapping(value = "/role/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result roleAddOrEdit(Role role,Integer[] permissionId){
        if(role.getRoleId()!=null){
            roleService.update(role,permissionId);
            return new Result("修改成功");
        }else{
            Role role1 = roleService.insert(role);
            Integer roleId = role1.getRoleId();
            roleService.insertRolePermission(roleId,permissionId);
            return new Result("添加成功");
        }

    }
    @PostMapping(value = "/role/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result roleDel(Integer roleId,Integer status){
        Boolean delete = roleService.delete(roleId,status);
        if(delete){
            return new Result("修改状态成功");
        }else {
            return new Result("修改状态失败");
        }
    }
}

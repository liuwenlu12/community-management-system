package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Department;
import com.oaec.cms.service.DeparmentService;
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
public class DepartmentController {

    @Autowired
    private DeparmentService deparmentService;
    @GetMapping("/department")
    public String department(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<Department> departmentList = deparmentService.getDepartments(name,page);
        model.addAttribute("departmentList",departmentList);
        if(departmentList instanceof Page){
            Page departmentPage = (Page)departmentList;
            int pageNum = departmentPage.getPageNum();
            int pages = departmentPage.getPages();
            int pageTotal = (int)departmentPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "department-list";
    }

    @GetMapping("/department/add/edit")
    public String departmentAddOrEdit(){
        return "department-add-edit";
    }
    @PostMapping(value = "/department/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result departmentAddOrEdit(Department department){
        if(department.getDepartmentId()!=null){
            deparmentService.update(department);
            return  new Result("修改成功");

        }else{
            deparmentService.insert(department);
            return  new  Result("添加成功");
        }
    }

    @PostMapping(value = "/department/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result areaDel(Integer departmentId){
        deparmentService.delete(departmentId,1);
        return new Result("删除成功");
    }
    @PostMapping(value = "/department/status/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminStatusEdit(Integer departmentId,Integer status){
        deparmentService.delete(departmentId,status);
        return new Result("修改状态成功");
    }
}

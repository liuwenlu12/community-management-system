package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Department;
import com.oaec.cms.entity.GarbageType;
import com.oaec.cms.service.GarbageTypeService;
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
public class GarbageTypeController {
    @Autowired
    private GarbageTypeService garbageTypeService;

    @GetMapping("/garbageType")
    public String garbageType(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<GarbageType> garbageTypeList = garbageTypeService.getGarbageTypes(name,page);
        model.addAttribute("garbageTypeList",garbageTypeList);
        if(garbageTypeList instanceof Page){
            Page garbageTypePage = (Page)garbageTypeList;
            int pageNum = garbageTypePage.getPageNum();
            int pages = garbageTypePage.getPages();
            int pageTotal = (int)garbageTypePage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "garbageType-list";
    }
    @GetMapping("/garbageType/add/edit")
    public String departmentAddOrEdit(){
        return "garbageType-add-edit";
    }
    @PostMapping(value = "/garbageType/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result departmentAddOrEdit(GarbageType garbageType){
        if(garbageType.getGarbageTypeId()!=null){
            garbageTypeService.update(garbageType);
            return  new Result("修改成功");

        }else{
            garbageTypeService.insert(garbageType);
            return  new  Result("添加成功");
        }
    }
    @PostMapping(value = "/garbageType/status/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminStatusEdit(Integer garbageTypeId,Integer status){
        garbageTypeService.delete(garbageTypeId,status);
        return new Result("修改状态成功");
    }


}

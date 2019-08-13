package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Garbage;
import com.oaec.cms.entity.GarbageType;
import com.oaec.cms.service.GarbageService;
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
public class GarbageController {
    @Autowired
    private GarbageService garbageService;
    @Autowired
    private GarbageTypeService garbageTypeService;
    @GetMapping("/garbage")
    public String garbage(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<Garbage> garbageList = garbageService.getGarbages(name, page);
        model.addAttribute("garbageList",garbageList);
        if(garbageList instanceof Page){
            Page garbagePage = (Page)garbageList;
            int pageNum = garbagePage.getPageNum();
            int pages = garbagePage.getPages();
            int pageTotal = (int)garbagePage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "garbage-list";
    }
    @GetMapping("/garbage/add/edit")
    public String departmentAddOrEdit(Model model){
        List<GarbageType> garbageTypeList = garbageTypeService.getGarbageTypes();
        model.addAttribute("garbageTypeList",garbageTypeList);
        return "garbage-add-edit";
    }
    @PostMapping(value = "/garbage/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result departmentAddOrEdit(Garbage garbage){
        if(garbage.getGarbageId()!=null){
            garbageService.update(garbage);
            return  new Result("修改成功");
        }else{
            garbageService.insert(garbage);
            return  new  Result("添加成功");
        }
    }
    @PostMapping(value = "/garbage/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result areaDel(Integer garbageId){
        garbageService.delete(garbageId);
        return new Result("删除成功");
    }
    @GetMapping("/garbage/user")
    public String garbageUser(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List<Garbage> garbageList = garbageService.getGarbages(name, page);
        model.addAttribute("garbageList",garbageList);
        if(garbageList instanceof Page){
            Page garbagePage = (Page)garbageList;
            int pageNum = garbagePage.getPageNum();
            int pages = garbagePage.getPages();
            int pageTotal = (int)garbagePage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "garbage-user-list";
    }
}

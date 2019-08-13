package com.oaec.cms.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.oaec.cms.entity.Resident;
import com.oaec.cms.service.AreaService;
import com.oaec.cms.service.ResidentService;
import com.oaec.cms.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ResidentController {

    @Autowired
    private ResidentService residentService;
    @Autowired
    private AreaService areaService;
    private Logger logger =  LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/resident")
    public String resident(String name,@RequestParam(required = false,defaultValue = "1") Integer page,Model model){
        List<Resident> residentList = residentService.getResident(name,page);
        model.addAttribute("residentList",residentList);
        if(residentList instanceof Page){
            Page residentPage = (Page)residentList;
            int pageNum = residentPage.getPageNum();
            int pages = residentPage.getPages();
            int pageTotal = (int)residentPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "member-list";
    }

    @GetMapping("/resident/add/edit")
    public String residentAddOrEdit(Model model){
        List areaList = areaService.getAreas();
        model.addAttribute("areaList",areaList);
        return "member-add-edit";
    }


    @PostMapping(value = "/resident/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result residentAddOrEdit(@RequestParam(required = false,value="areaId") Integer areaId, Resident resident){
        resident.setAreaId(areaId);
        if(resident.getResidentId()!=null){
            logger.debug(JSON.toJSONString(resident));
            residentService.update(resident);
            return new Result("修改成功");
        }else{
            residentService.save(resident);
            return new Result("添加成功");
        }

    }

    @GetMapping("/resident/edit")
    public String residentEdit(){
        return "member-edit";
    }
    @GetMapping("/resident/password")
    public String residentPassword(){
        return "admin-password";
    }


    @GetMapping("/resident/del")
    public String residentDel(String name,@RequestParam(required = false,defaultValue = "1") Integer page,Model model){
        List<Resident> residentDelList = residentService.getResidentDel(name,page);
        model.addAttribute("residentDelList",residentDelList);
        if(residentDelList instanceof Page){
            Page residentPage = (Page)residentDelList;
            int pageNum = residentPage.getPageNum();
            int pages = residentPage.getPages();
            int pageTotal = (int)residentPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }

        return "member-del";
    }

    @PostMapping(value = "/resident/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result residentDel(Integer residentId){
         residentService.delete(residentId);
        return new Result("删除成功");
    }


    @PostMapping(value = "/resident/recover",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result  residentRecover(Integer residentId){
        residentService.recover(residentId);
        return new Result("恢复成功");
    }



}

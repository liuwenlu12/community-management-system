package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Area;
import com.oaec.cms.service.AreaService;
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
public class AreaController {
    @Autowired
    private AreaService areaService;
    @GetMapping("/area")
    public String area(String name, @RequestParam(required = false,defaultValue = "1") Integer page, Model model){
        List areaList = areaService.getAllArea(name,page);
        model.addAttribute("areaList",areaList);
        if(areaList instanceof Page){
            Page areaPage = (Page)areaList;
            int pageNum = areaPage.getPageNum();
            int pages = areaPage.getPages();
            int pageTotal = (int)areaPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "area-list";
    }
    @GetMapping("/area/add/edit")
    public String areaAddOrEdit(){
        return "area-add-edit";
    }

    @PostMapping(value = "/area/add/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result areaAddOrEdit(Area area){
        if(area.getAreaId()!=null){
            areaService.update(area);
            return  new  Result("修改成功");

        }else{
            areaService.insert(area);
            return  new  Result("添加成功");
        }
    }
    @PostMapping(value = "/area/del",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result areaDel(Integer areaId){
        areaService.delete(areaId,1);
        return new Result("删除成功");
    }
    @PostMapping(value = "/area/status/edit",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result adminStatusEdit(Integer areaId,Integer status){
        areaService.delete(areaId,status);
        return new Result("修改状态成功");
    }

}

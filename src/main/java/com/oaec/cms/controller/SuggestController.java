package com.oaec.cms.controller;

import com.github.pagehelper.Page;
import com.oaec.cms.entity.Suggest;
import com.oaec.cms.service.SuggestService;
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
public class SuggestController {
    @Autowired
    private SuggestService suggestService;
    @GetMapping("/suggest/add")
    public String suggestAdd(){
        return "suggest-add";
    }

    @PostMapping(value = "/suggest/add",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result suggestAdd(Suggest suggest){

        Boolean insert = suggestService.insert(suggest);
        if(insert){
            return new Result("添加成功");
        }else{
            return new Result("添加失败");
        }
    }
    @GetMapping("/suggest/list")
    public String suggestList(@RequestParam(required = false,defaultValue = "1") Integer page,Model model){
        List<Suggest> suggestList = suggestService.getSuggest(page);
        model.addAttribute("suggestList",suggestList);
        if(suggestList instanceof Page){
            Page suggestPage = (Page)suggestList;
            int pageNum = suggestPage.getPageNum();
            int pages = suggestPage.getPages();
            int pageTotal = (int)suggestPage.getTotal();
            model.addAttribute("pageTotal",pageTotal);
            model.addAttribute("pageNum",pageNum);
            model.addAttribute("pages",pages);
        }
        return "suggest-list";
    }

}

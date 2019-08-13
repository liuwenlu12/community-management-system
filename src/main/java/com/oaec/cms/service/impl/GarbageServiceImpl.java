package com.oaec.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Garbage;
import com.oaec.cms.mapper.GarbageMapper;
import com.oaec.cms.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("garbageService")
public class GarbageServiceImpl implements GarbageService {
    @Autowired
    private GarbageMapper garbageMapper;
    @Override
    public List<Garbage> getGarbages(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return garbageMapper.query(param);
    }

    @Override
    public Boolean insert(Garbage garbage) {
        return garbageMapper.doInsert(garbage)==1;
    }

    @Override
    public Boolean update(Garbage garbage) {
        return garbageMapper.doUpdate(garbage)==1;
    }

    @Override
    public Boolean delete(Integer garbageId) {
        return garbageMapper.doDelete(garbageId)==1;
    }
}

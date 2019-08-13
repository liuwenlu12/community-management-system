package com.oaec.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.GarbageType;
import com.oaec.cms.mapper.GarbageTypeMapper;
import com.oaec.cms.service.GarbageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("garbageTypeService")
public class GarbageTypeServiceImpl implements GarbageTypeService {
    @Autowired
    private GarbageTypeMapper garbageTypeMapper;

    @Override
    public List<GarbageType> getGarbageTypes(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return garbageTypeMapper.query(param);
    }

    @Override
    public Boolean insert(GarbageType garbageType) {
        return garbageTypeMapper.doInsert(garbageType)==1;
    }

    @Override
    public Boolean update(GarbageType garbageType) {
        return garbageTypeMapper.doUpdate(garbageType)==1;
    }

    @Override
    public Boolean delete(Integer garbageTypeId, Integer status) {
        Map<String, Object> param = new HashMap<>();
        param.put("garbageTypeId",garbageTypeId);
        param.put("status",status);
        return garbageTypeMapper.doEditStatus(param)==1;
    }

    @Override
    public List<GarbageType> getGarbageTypes() {
        Map<String, Object> param = new HashMap<>();
        param.put("status",1);
        return garbageTypeMapper.query(param);
    }
}

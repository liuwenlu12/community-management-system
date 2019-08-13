package com.oaec.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Area;
import com.oaec.cms.exception.HelloException;
import com.oaec.cms.mapper.AreaMapper;
import com.oaec.cms.service.AreaService;
import com.oaec.cms.util.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;


    @Override
    public List<Area> getAllArea(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return areaMapper.query(param);
    }

    @Override
    public List<Area> getAreas() {
        Map<String, Object> param = new HashMap<>();
        param.put("status",1);
        return areaMapper.query(param);
    }

    @Override
    public Boolean insert(Area area) {
        String name = area.getName();
        Area area1 = areaMapper.queryByName(name);
        if(area1!=null){
            throw new HelloException(ExceptionCode.AREA_ALREADT_EXISTS);
        }
        return areaMapper.doInsert(area)==1;
    }

    @Override
    public Boolean update(Area area) {
        return areaMapper.doUpdate(area)==1;
    }

    @Override
    public Boolean delete(Integer areaId,Integer status) {
        if(status==1){
            return areaMapper.doDelete(areaId)==1;
        }else{
            return areaMapper.doNotDelete(areaId)==1;
        }
    }
}

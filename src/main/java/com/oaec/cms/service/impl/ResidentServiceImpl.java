package com.oaec.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Resident;
import com.oaec.cms.mapper.ResidentMapper;
import com.oaec.cms.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("residentService")
public class ResidentServiceImpl implements ResidentService {

    @Autowired
    private ResidentMapper residentMapper;

    @Override
    public List<Resident> getResident(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);

        return residentMapper.query(param);
    }

    @Override
    public Boolean save(Resident resident) {
        return residentMapper.doInsert(resident)==1;
    }

    @Override
    public Boolean delete(Integer residentId) {
        return residentMapper.doDelete(residentId)==1;
    }

    @Override
    public Boolean update(Resident resident) {
        return residentMapper.doUpdate(resident)==1;
    }

    @Override
    public List<Resident> getResidentDel(String name,Integer page) {
        Map<String, Object> param = new HashMap<>();
        param.put("name",name);
        PageHelper.startPage(page,4);
        return residentMapper.queryDel(param);
    }

    @Override
    public Boolean recover(Integer residentId) {
        return residentMapper.doRecover(residentId)==1;
    }
}

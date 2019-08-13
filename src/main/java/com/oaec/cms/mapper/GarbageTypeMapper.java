package com.oaec.cms.mapper;

import com.oaec.cms.entity.GarbageType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface GarbageTypeMapper {

     List<GarbageType> query(Map<String,Object> param);
    int doInsert(GarbageType garbageType);
    int doUpdate(GarbageType garbageType);

    int doEditStatus(Map<String,Object> param);
}

package com.oaec.cms.service;

import com.oaec.cms.entity.GarbageType;

import java.util.List;

public interface GarbageTypeService {

    List<GarbageType> getGarbageTypes(String name,Integer page);
    Boolean insert(GarbageType garbageType);
    Boolean update(GarbageType garbageType);
    Boolean delete(Integer garbageTypeId,Integer status);
    List<GarbageType> getGarbageTypes();
}

package com.oaec.cms.service;

import com.oaec.cms.entity.Garbage;

import java.util.List;

public interface GarbageService {

    List<Garbage> getGarbages(String name,Integer page);
    Boolean insert(Garbage garbage);
    Boolean update(Garbage garbage);
    Boolean delete(Integer garbageId);
}

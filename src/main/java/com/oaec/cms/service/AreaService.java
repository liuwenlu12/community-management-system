package com.oaec.cms.service;

import com.oaec.cms.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAllArea(String name,Integer page);
    List<Area> getAreas();
    Boolean insert(Area area);

    Boolean update(Area area);

    Boolean delete(Integer areaId,Integer status);
}

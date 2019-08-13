package com.oaec.cms.mapper;

import com.oaec.cms.entity.Area;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AreaMapper {
    Area queryByName(String name);

    List<Area> query(Map<String,Object> param);

    int doInsert(Area area);
    int doDelete(Integer areaId);
    int doUpdate(Area area);
    int doNotDelete(Integer areaId);
}

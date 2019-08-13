package com.oaec.cms.mapper;

import com.oaec.cms.entity.Garbage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface GarbageMapper {
   List<Garbage> query(Map<String,Object> param);
   int doUpdate(Garbage garbage);
   int doInsert(Garbage garbage);
   int doDelete(Integer garbageId);
}

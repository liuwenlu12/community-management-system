package com.oaec.cms.mapper;

import com.oaec.cms.entity.Resident;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ResidentMapper {

    List<Resident> query(Map<String,Object> param);

    int doInsert(Resident resident);

    int doDelete(Integer residentId);

    int doUpdate(Resident resident);

    List<Resident> queryDel(Map<String,Object> param);

    int doRecover(Integer residentId);
}

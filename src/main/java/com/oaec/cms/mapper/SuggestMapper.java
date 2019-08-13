package com.oaec.cms.mapper;

import com.oaec.cms.entity.Suggest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SuggestMapper {
    List<Suggest> query();

    int doInsert(Suggest suggest);

}

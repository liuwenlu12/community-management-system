package com.oaec.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.oaec.cms.entity.Suggest;
import com.oaec.cms.mapper.SuggestMapper;
import com.oaec.cms.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {
    @Autowired
    private SuggestMapper suggestMapper;
    @Override
    public List<Suggest> getSuggest(Integer page) {
        PageHelper.startPage(page,8);
        return suggestMapper.query();
    }

    @Override
    public Boolean insert(Suggest suggest) {
        return suggestMapper.doInsert(suggest)==1;
    }
}

package com.oaec.cms.service;

import com.oaec.cms.entity.Suggest;

import java.util.List;

public interface SuggestService {
    List<Suggest> getSuggest(Integer page);
    Boolean insert(Suggest suggest);
}

package com.oaec.cms.service;

import com.oaec.cms.entity.Resident;

import java.util.List;

public interface ResidentService {
    List<Resident> getResident(String name,Integer page);

    Boolean save(Resident resident);

    Boolean delete(Integer residentId);

    Boolean update(Resident resident);

    List<Resident> getResidentDel(String name,Integer page);
    Boolean recover( Integer residentId);
}

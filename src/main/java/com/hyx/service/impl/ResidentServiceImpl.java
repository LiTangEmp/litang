package com.hyx.service.impl;

import com.hyx.pojo.Resident;
import com.hyx.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.hyx.mapper.ResidentMapper;
import org.springframework.stereotype.Service;

@Service
public class ResidentServiceImpl implements ResidentService{

    @Autowired
    private ResidentMapper residentMapper;
    @Override
    public Resident getResidentById(Integer id) {
        return residentMapper.getResidentById(id);
    }
}

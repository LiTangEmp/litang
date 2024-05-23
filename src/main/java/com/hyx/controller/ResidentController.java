package com.hyx.controller;

import com.hyx.pojo.Resident;
import com.hyx.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* 试试数据库能不能连上，没用*/
@RestController
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @RequestMapping("/getResidentByID")
    public Resident getResidentById(Integer id) {
        return residentService.getResidentById(id);
    }
}

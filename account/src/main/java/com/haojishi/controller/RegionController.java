package com.haojishi.controller;

import com.haojishi.service.RegionService;
import com.haojishi.util.BusinessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    /**
     * 查询所有城市列表
     *
     * @return
     */
    @RequestMapping("getRegion")
    public BusinessMessage getRegion(){
        return regionService.getRegion();
    }

    /**
     * 获取所有省份信息
     * @return
     */
    @RequestMapping("getProvince")
    public BusinessMessage getProvince(){
        return regionService.getProvince();
    }

    /**
     * 获取所有省份信息
     * @return
     */
    @RequestMapping("getCityBypId")
    public BusinessMessage getCityBypId(Integer id){
        return regionService.getCityBypId(id);
    }
}

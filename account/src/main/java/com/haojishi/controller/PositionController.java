package com.haojishi.controller;

import com.haojishi.service.PositionService;
import com.haojishi.util.BusinessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 梁闯
 * @date 2018/03/19 17.14
 */
@RestController
@RequestMapping("position")
public class PositionController {
    @Autowired
    private PositionService positionService;


    /**
     * 个人端首页推荐职位
     *
     * @param session
     * @return
     */
    @RequestMapping("getPositionInIndex")
    public BusinessMessage getPositionInIndex(HttpServletRequest request,HttpSession session){
        return positionService.getPositionInIndex(request,session);
    }

    /**
     * 根据职位信息获取相关职位信息
     *
     * @param session
     * @return BusinessMessage - 相关职位信息
     */
    @RequestMapping("getPositionById")
    public BusinessMessage getPositionById(HttpSession session,HttpRequest request){
        return positionService.getPositionById(session,request);
    }

    /**
     * 获取同城职位信息
     *
     * @param session
     * @return BusinessMessage - 同城所有职位信息
     */
    @RequestMapping("getPosition")
    public BusinessMessage getPosition(HttpServletRequest request,HttpSession session){
        return positionService.getPosition(request,session);
    }

    /**
     * 求职者端 求职者页面条件查询
     *
     * @param session
     * @param type
     * @param city
     * @param money
     * @param scale
     * @return
     */
    @RequestMapping("getPositionByParams")
    public BusinessMessage getPositionByParams(HttpSession session,String type,
                                               String city,String money,String scale){
        return positionService.getPositionByParams(session, type, city, money, scale);
    }

    /**
     * 求职者端02 求职者页面条件查询
     *
     * @param positionType
     * @param city
     * @param money
     * @param scale
     * @return
     */
    @RequestMapping("getPositionByParams02")
    public BusinessMessage getPositionByParams02(String positionType,
                                                 String city,String money,String scale){
        return positionService.getPositionByParams02(positionType, city, money, scale);
    }

    /**
     * 根据企业id获取职位信息
     *
     * @param session
     * @return
     */
    @RequestMapping("getPositionByCid")
    public BusinessMessage getPositionByCid(HttpSession session){
        return positionService.getPositionByCid(session);
    }

    /**
     * 求职者端======根据搜索职位或者店铺查询相关职位
     * @param name
     * @return
     */
    @RequestMapping("getPositionByName")
    public BusinessMessage getPositionByName(String name){
        return positionService.getPositionByName(name);
    }

}

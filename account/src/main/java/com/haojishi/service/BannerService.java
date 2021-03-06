package com.haojishi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haojishi.config.CookiesUtil;
import com.haojishi.mapper.BannerMapper;
import com.haojishi.model.Banner;
import com.haojishi.util.BusinessMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * @author 梁闯
 * @date 2018/03/23 20.35
 */
@Slf4j
@Service
public class BannerService{

    @Autowired
    private BannerMapper bannerMapper;
    BusinessMessage businessMessage = new BusinessMessage();

    /**
     * 获取所有求职者端banner
     *
     * @return BusinessMessage
     */
    public BusinessMessage getPersonalBanner(){
        try {
            Example bannerExample = new Example(Banner.class);
            bannerExample.createCriteria().andEqualTo("classification",1);
            bannerExample.setOrderByClause("sort");
            List<Banner> bannerList = bannerMapper.selectByExample(bannerExample);
            if (bannerList != null && bannerList.size() > 0) {
                businessMessage.setData(bannerList);
                businessMessage.setSuccess(true);
                businessMessage.setMsg("获取banner成功");
            } else {
                businessMessage.setMsg("暂无数据");
                businessMessage.setSuccess(true);
            }
        }catch(Exception e){
            log.error("获取banner查询信息失败", e);
            businessMessage.setMsg("获取banner列表不存在，请重试");
        }
        return businessMessage;
    }

    /**
     * 获取所有企业端banner
     *
     * @return BusinessMessage
     */
    public BusinessMessage getCompanyBanner(){
        try {
            Example bannerExample = new Example(Banner.class);
            bannerExample.createCriteria().andEqualTo("classification",2);
            bannerExample.setOrderByClause("sort");
            List<Banner> bannerList = bannerMapper.selectByExample(bannerExample);
            if (bannerList != null && bannerList.size() > 0) {
                businessMessage.setData(bannerList);
                businessMessage.setSuccess(true);
                businessMessage.setMsg("获取banner成功");
            } else {
                businessMessage.setMsg("暂无数据");
                businessMessage.setSuccess(true);
            }
        }catch(Exception e){
            log.error("获取banner查询信息失败", e);
            businessMessage.setMsg("获取banner列表不存在，请重试");
        }
        return businessMessage;
    }

}

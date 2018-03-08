package com.haojishi.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haojishi.mapper.BannerMapper;
import com.haojishi.model.Banner;
import com.haojishi.util.BusinessMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;


@Slf4j
@Service
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    public BusinessMessage getAllBanner(Integer page,Integer size){
        BusinessMessage businessMessage = new BusinessMessage();
        try {
            if (null == page || page < 1) {
                page = 1;
            }
            if (null == size || size < 1) {
                size = 10;
            }
            // 设置分页信息
            PageHelper.startPage(page, size);
            Example bannerExample = new Example(Banner.class);
            bannerExample.setOrderByClause("sort");
            List<Banner> bannerList = bannerMapper.selectByExample(bannerExample);
            if (bannerList != null && bannerList.size() > 0) {
                businessMessage.setData(new PageInfo<>(bannerList));
                businessMessage.setSuccess(true);
                businessMessage.setMsg("获取banner成功");
            } else {
                businessMessage.setMsg("暂无数据");
                businessMessage.setSuccess(true);
            }
        }catch(Exception e){
            log.error("获取分页查询信息失败", e);
            businessMessage.setMsg("获取banner列表不存在，请重试");
        }
        return businessMessage;
    }

}

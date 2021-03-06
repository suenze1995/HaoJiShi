package com.haojishi.controller;

import com.haojishi.service.CommonService;
import com.haojishi.service.CompanyService;
import com.haojishi.util.BusinessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 梁闯
 * @date 2018/03/13 15.56
 */
@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CommonService commonService;

    /**
     * 获取所有企业信息
     *
     * @param name
     * @param phone
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/getAllCompany")
    public BusinessMessage getAllCompany(String name, String phone, Integer page, Integer size){
        return companyService.getAllCompany(name,phone,page,size);
    }

    /**
     * 企业列表
     * @param name
     * @param phone
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("positionNumSort")
    public BusinessMessage positionNumSort(String name, String phone, Integer page, Integer size){
        return companyService.positionNumSort(name,phone,page,size);
    }

    /**
     * 企业列表
     * @param name
     * @param phone
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("seeCountNumSort")
    public BusinessMessage seeCountNumSort(String name, String phone, Integer page, Integer size){
        return companyService.seeCountNumSort(name,phone,page,size);
    }

    /**
     * 企业列表
     * @param name
     * @param phone
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("payTimeSort")
    public BusinessMessage payTimeSort(String name, String phone, Integer page, Integer size){
        return companyService.payTimeSort(name,phone,page,size);
    }


    /**
     * 获取企业照片
     *
     * @param id
     * @return BusinessMessage - 企业照片
     */
    @RequestMapping("getCompanyPhotoById")
    public BusinessMessage getCompanyPhotoById(Integer id) {
        return companyService.getCompanyPhotoById(id);
    }

    /**
     * 更新企业信息
     *
     * @param id
     * @param company_name
     * @param company_scale
     * @param company_special_str
     * @param province
     * @param city
     * @param area
     * @param company_info
     * @param matstate
     * @param accountState
     * @param company_fu_ze_ren
     * @param company_addr
     * @param company_type
     * @param zhi_wu
     * @return
     */
    @PostMapping("updateCompanyById")
    public BusinessMessage update(Integer id, String company_name,String company_info,int matstate,int accountState,
                                  String company_scale, String company_special_str, Integer province, Integer city,
                                  Integer area,String zhi_wu,String phone,
                                  MultipartFile icon, String company_addr, String company_type, String company_fu_ze_ren) {
        return companyService.update(id, company_name,company_info, matstate, accountState,
         company_scale,  company_special_str,  province,  city,
                 area, zhi_wu, phone,
                 icon,  company_addr,  company_type,  company_fu_ze_ren);
    }
    /**
     * 读取城市列表根据pid
     * @param pid
     * @return
     */
    @RequestMapping("regionList")
    public BusinessMessage findRegionListByPid(Integer pid){
        return commonService.findRegionListByPid(pid);
    }

    /**
     * 根据企业ID获取企业信息
     * @param id
     * @return
     */
    @GetMapping("findCompanyInfoById")
    public BusinessMessage findById(Integer id) {
        return companyService.findOneByid(id);
    }

    /**
     * 添加照片
     * @param request
     * @param id
     * @param image_url
     * @return
     */
    @PostMapping("insertPhoto")
    public BusinessMessage insertPhoto(HttpServletRequest request,Integer id, MultipartFile image_url) {
        return companyService.insertPhoto(id,image_url);
    }

    /**
     * 获取企业营业执照审核结果
     *
     * @param name
     * @param phone
     * @param page
     * @param size
     * @return BusinessMessage - 企业营业执照审核结果
     */
    @RequestMapping("/getAllCompanyState")
    public BusinessMessage getAllCompanyState(String name,String phone,Integer page,Integer size){
        return companyService.getAllCompanyState(name,phone,page,size);
    }

    /**
     * 企业营业执照审核通过
     *
     * @param id
     * @return BusinessMessage - 企业营业执照审核通过信息
     */
    @RequestMapping("/approve")
    public BusinessMessage approve(Integer id){
        return companyService.approve(id);
    }

    /**
     * 企业营业执照审核未通过
     *
     * @param id
     * @return BusinessMessage - 企业营业执照审核通过信息
     */
    @RequestMapping("/auditFailed")
    public BusinessMessage auditFailed(Integer id){
        return companyService.auditFailed(id);
    }

    /**
     * 冻结企业账户
     *
     * @param companyCheck
     * @return BusinessMessage - 是否冻结成功信息
     */
    @RequestMapping("/frozenAccount")
    public BusinessMessage frozenAccount(String companyCheck){
        return companyService.frozenAccount(companyCheck);
    }

    /**
     * 删除企业账户
     *
     * @param companyCheck
     * @return BusinessMessage - 是否删除成功信息
     */
    @RequestMapping("/deleteAccount")
    public BusinessMessage deleteAccount(String companyCheck){
        return companyService.deleteAccount(companyCheck);
    }

    /**
     * 删除企业照片
     *
     * @param photoUrl
     * @return BusinessMessage - 是否成功删除企业照片信息
     */
    @RequestMapping("deleteCompanyPhoto")
    public BusinessMessage deleteCompanyPhoto(String photoUrl,Integer id){
        return companyService.deleteCompanyPhoto(photoUrl, id);
    }
}

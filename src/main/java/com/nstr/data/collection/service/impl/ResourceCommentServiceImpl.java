package com.nstr.data.collection.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.ip.IPInfoHelper;
import com.nstr.data.collection.model.CollectionData;
import com.nstr.data.collection.model.ip.IPInfo;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.model.pojo.ResourceCommentExample;
import com.nstr.data.collection.repository.ResourceCommentMapper;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.StringUtil;
import com.nstr.data.collection.util.UseragentUtil;
import com.nstr.data.collection.util.UseragentUtil.Entity;
import com.nstr.data.collection.util.UseragentUtil.UserAgentInfo;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("resourceCommentService")
public class ResourceCommentServiceImpl implements ResourceCommentService {

  @Resource
  private ResourceCommentMapper resourceCommentMapper;

  @Override
  public ResourceComment save(CollectionData cdata, String type) {
    if(cdata == null || StringUtil.isNullOrBlank(cdata.getAccount())
            || StringUtil.isNullOrBlank(cdata.getResourceid()) ){
       return null;
    }
    ResourceComment rc = new ResourceComment();
    rc.setAccount(cdata.getAccount());
    rc.setResourceid(cdata.getResourceid());
    rc.setUserid(cdata.getUserid());
    rc.setContent(cdata.getContent());
    rc.setScore(cdata.getScore());
    rc.setContact(cdata.getContact());

    rc.setUrl(cdata.getUrl());
    rc.setReferrer(cdata.getReferrer());

    rc.setTitle(cdata.getTitle());
    rc.setClientLang(cdata.getLang());

    String ua = cdata.getUa();
    rc.setUserAgent(ua);
    //解析ua
    UserAgentInfo uainfo = UseragentUtil.parse(ua);

    //设置浏览器数据
    Entity browser = uainfo.getBrowser();
    rc.setBrowser(browser.getName());
    rc.setBrowserType(browser.getType());
    rc.setBrowserVersion(browser.getVersion());

    //设置操作系统数据
    Entity os = uainfo.getOs();
    rc.setOs(os.getName());
    rc.setOsType(os.getType());
    rc.setOsVersion(os.getVersion());

    //解析ip
    IPInfo ip = IPInfoHelper.findIP(cdata.getIpaddr(), type);

    //设置ip信息
    rc.setArea(ip.getCountry());//有些会将区域当成国家，这里统一
    rc.setProvince(ip.getProvince());
    rc.setRegion(ip.getCity());
    rc.setLat(ip.getLatitude());
    rc.setLng(ip.getLongtitude());

    //最后再设置ip信息，并且ip信息是从返回的ipinfo里面获取
    rc.setIpaddr(ip.getIp());

    rc.setCreateTime(new Date().getTime());

    resourceCommentMapper.insertSelective(rc);
    return rc;
  }

  @Override
  public ResourceComment findOne(Long id) {
    ResourceComment resourceComment = resourceCommentMapper.selectByPrimaryKey(id);
    return resourceComment;
  }

  @Override
  public void delete(Long begin, long end) {
    ResourceCommentExample example = new ResourceCommentExample() ;
    example.createCriteria().andCreateTimeBetween(begin, end);
    resourceCommentMapper.deleteByExample(example);
  }

  @Override
  public List<ResourceComment> findByCreateTime(Long begin, long end) {
    ResourceCommentExample example = new ResourceCommentExample() ;
    example.createCriteria().andCreateTimeBetween(begin, end);
    return resourceCommentMapper.selectByExampleWithBLOBs(example);
  }

  @Override
  public PageInfo<ResourceComment> findPage(String account, String resourceid, String userid,
                                            Integer number, Integer size) {
    if(number < 0){
      number = 0;
    }

    if(size < 0){
      size = 10;
    }

    PageHelper.startPage(number,size,true);
    ResourceCommentExample example = new ResourceCommentExample();

    example.setOrderByClause("create_time DESC");

    ResourceCommentExample.Criteria criteria = example.createCriteria();
    criteria.andAccountEqualTo(account);

    if(!StringUtil.isNullOrBlank(resourceid)){
      criteria.andResourceidEqualTo(resourceid);
    }
    if(!StringUtil.isNullOrBlank(userid)){
      criteria.andUseridEqualTo(userid);
    }
    List<ResourceComment> comments = resourceCommentMapper.selectByExample(example);
    return new PageInfo<>(comments);
  }
}

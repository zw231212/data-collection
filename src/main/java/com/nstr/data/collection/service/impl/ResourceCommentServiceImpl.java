package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.ip.IPInfoHelper;
import com.nstr.data.collection.model.CollectionData;
import com.nstr.data.collection.model.ip.IPInfo;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.repository.ResourceCommentRepository;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.StringUtil;
import com.nstr.data.collection.util.UseragentUtil;
import com.nstr.data.collection.util.UseragentUtil.Entity;
import com.nstr.data.collection.util.UseragentUtil.UserAgentInfo;
import java.util.Date;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

@Service("resourceCommentService")
public class ResourceCommentServiceImpl implements ResourceCommentService {

  @Resource
  private ResourceCommentRepository resourceCommentRepository;

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
    rc.setUa(ua);
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

    rc = resourceCommentRepository.save(rc);

    return rc;
  }

  @Override
  public ResourceComment findOne(Long id) {
    Optional<ResourceComment> rcOptional = resourceCommentRepository.findById(id);
    return rcOptional.orElse(null);
  }

  @Override
  public Page<ResourceComment> findPage(String account, String resourceid, String userid,
      Integer number, Integer size) {
    if(number < 0){
      number = 0;
    }

    if(size < 0){
      size = 10;
    }
    Sort sort = Sort.by(Order.desc("createTime"));
    ResourceComment rc = new ResourceComment();
    rc.setAccount(account);
    Pageable pageable =PageRequest.of(number, size, sort);
    ExampleMatcher matcher = ExampleMatcher.matching()
        .withMatcher(account, match -> match.exact());
    if(!StringUtil.isNullOrBlank(resourceid)){
      rc.setResourceid(resourceid);
      matcher.withMatcher(resourceid, match -> match.exact());
    }
    if(!StringUtil.isNullOrBlank(userid)){
      rc.setUserid(userid);
      matcher.withMatcher(userid, match -> match.exact());
    }
    Example<ResourceComment> example = Example.of(rc,matcher);
    return resourceCommentRepository.findAll(example,pageable);
  }
}

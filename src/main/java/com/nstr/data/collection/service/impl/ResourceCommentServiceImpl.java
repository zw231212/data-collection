package com.nstr.data.collection.service.impl;

import com.nstr.data.collection.model.CollectionData;
import com.nstr.data.collection.model.pojo.ResourceComment;
import com.nstr.data.collection.repository.ResourceCommentRepository;
import com.nstr.data.collection.service.ResourceCommentService;
import com.nstr.data.collection.util.StringUtil;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resourceCommentService")
public class ResourceCommentServiceImpl implements ResourceCommentService {

  @Resource
  private ResourceCommentRepository resourceCommentRepository;

  @Override
  public ResourceComment save(CollectionData cdata) {
    if(cdata == null || StringUtil.isNullOrBlank(cdata.getAccount()) || StringUtil.isNullOrBlank(cdata.getResourceid())){

    }



    return null;
  }
}

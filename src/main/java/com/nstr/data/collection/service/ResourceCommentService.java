package com.nstr.data.collection.service;

import com.nstr.data.collection.model.CollectionData;
import com.nstr.data.collection.model.pojo.ResourceComment;
import org.springframework.data.domain.Page;

public interface ResourceCommentService {

  /**
   *
   * @param collectionData
   * @param type ip解析的类型，现在支持两种，将AppConstant里面的ipPluginNames
   * @return
   */
  ResourceComment save(CollectionData collectionData, String type);

  ResourceComment findOne(Long id);

  Page<ResourceComment> findPage(String account, String resourceid, String userid, Integer number, Integer size);
}

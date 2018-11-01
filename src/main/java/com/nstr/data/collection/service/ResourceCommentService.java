package com.nstr.data.collection.service;

import com.github.pagehelper.PageInfo;
import com.nstr.data.collection.model.CollectionData;
import com.nstr.data.collection.model.pojo.ResourceComment;

public interface ResourceCommentService {

  /**
   *
   * @param collectionData
   * @param type ip解析的类型，现在支持两种，将AppConstant里面的ipPluginNames
   * @return
   */
  ResourceComment save(CollectionData collectionData, String type);

  ResourceComment findOne(Long id);
  void delete(Long begin, long end);

  PageInfo<ResourceComment> findPage(String account, String resourceid, String userid, Integer number, Integer size);
}

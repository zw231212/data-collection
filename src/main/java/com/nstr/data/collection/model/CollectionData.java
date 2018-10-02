package com.nstr.data.collection.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CollectionData {

  private String id;
  private String ipaddr; //ip地址
  private Date createDate=new Date();
  private String domain; //网站域名
  private String url;  //页面url
  private String title; //页面title
  private int height; //屏幕高
  private int width; //屏幕宽
  private String referrer;
  private String ua;//user-agent
  private String navlan;//客户端语言
  private String account; //账号
  private String resourceid;//资源标识符id
  private List<String> keywords;//需要记录的查询关键词

}

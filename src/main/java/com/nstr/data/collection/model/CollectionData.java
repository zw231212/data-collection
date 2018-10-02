package com.nstr.data.collection.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CollectionData implements Serializable {

  private String ipaddr; //ip地址
  private String url;  //页面url
  private String title; //页面title
  private int height; //屏幕高
  private int width; //屏幕宽
  private String referrer; //网页referrer
  private String ua;//user-agent
  private String navlan;//客户端语言
  private String keywords;//需要记录的查询关键词

  private String account; //账号
  private String resourceid;//资源标识符id
  private String userid;
  
  private String contact;
  private String content;
  private Float score;


}

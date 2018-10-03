package com.nstr.data.collection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionData implements Serializable {

  private String ipaddr; //ip地址
  private String url;  //页面url
  private String title; //页面title
  private int height; //屏幕高
  private int width; //屏幕宽
  private String referrer; //网页referrer
  private String ua;//user-agent
  private String lang;//客户端语言
  private String keywords;//需要记录的查询关键词

  private String account; //账号id，唯一标识符
  private String resourceid;//资源标识符id
  private String userid;  //用户id
  
  private String contact; //联系方式
  private String content; //反馈内容
  private Float score;    //反馈分数


}

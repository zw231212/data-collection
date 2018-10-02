package com.nstr.data.collection.model.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resource_comment")
@Entity
public class ResourceComment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  //下面这两个就能锁定唯一的资源，account锁定所在组织，网站等信息，然后resourceid锁定每条信息
  //当然这两条信息不能是id，应为一个resource可以有好多的评论
  @Column(nullable = false)
  private String account;
  @Column(nullable = false)
  private String resourceid;
  private String userid;//用户的id这个是可选的

  //当前网页的数据
  @Column(length = 128)
  private String title;
  @Column(length = 500)
  private String url;
  @Column(length = 500)
  private String referrer;

  //评论的数据
  private String contact;
  @Column(columnDefinition = "text")
  private String content;
  private Float score;

  //ip相关的信息
  @Column(length = 128)
  private String ipaddr;
  private String area;//国家或地区
  private String province;//省份
  private String region; //地市或者县区
  private Double lat;  //经度
  private Double lng;  //维度

  //时间相关的数据
  @Column(name = "create_time")
  private Long createTime = new Date().getTime();

  //用户代理数据获取得到的相关的数据
  @Column(name = "user_agent",length = 500)
  private String ua;
  private String browser;
  @Column(name = "browser_version")
  private String browserVersion;
  @Column(name = "browser_type")
  private String browserType;

  private String os;
  @Column(name = "os_version")
  private String osVersion;
  @Column(name = "os_type")
  private String osType;
}

package com.nstr.data.collection.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Daily implements Serializable {

  private Integer id;

  private String account;//账户id信息
  private Integer commentNum;//评论信息

  //当前网页的数据
  private String day;//天数,格式XXXX-XX-XX：年月日
  private Float avgScore;//平均分数
  private Float minScore;//最低分数
  private Long createTime;

}

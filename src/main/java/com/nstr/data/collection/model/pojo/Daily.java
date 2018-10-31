package com.nstr.data.collection.model.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "nstr_daily")
@Entity
public class Daily implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String account;//账户id信息
  @Column(nullable = false,name = "comment_num")
  private Integer commentNum;//评论信息

  //当前网页的数据
  @Column(length = 8)
  private String day;//天数,格式XXXX-XX-XX：年月日
  @Column(name = "score",nullable = false)
  private Float score;//平均分数
  @Column(name = "lowest_score",nullable = false)
  private Float lowestScore;//最低分数

}

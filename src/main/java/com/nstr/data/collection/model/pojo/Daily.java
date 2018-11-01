package com.nstr.data.collection.model.pojo;

import com.nstr.data.collection.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Daily extends BaseModel implements Serializable {

  private Float avgScore;//平均分数
  private Float minScore;//最低分数

  @Override
  public String toString() {
    return "Daily{" +
            "avgScore=" + avgScore +
            ", minScore=" + minScore +
            ", id=" + id +
            ", account='" + account + '\'' +
            ", day='" + day + '\'' +
            ", value=" + value +
            ", createTime=" + createTime +
            '}';
  }
}

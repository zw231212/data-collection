package com.nstr.data.collection.model.pojo;

import com.nstr.data.collection.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DailyComment extends BaseModel implements Serializable {

    private String tags;

}

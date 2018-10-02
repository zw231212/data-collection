package com.nstr.data.collection.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta implements Serializable{

    private int code = 30001;
    private String msg;

    public Meta(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Meta{" +
            "code=" + code +
            ", msg='" + msg + '\'' +
            '}';
    }
}

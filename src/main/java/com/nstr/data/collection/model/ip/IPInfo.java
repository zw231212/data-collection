package com.nstr.data.collection.model.ip;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IPInfo implements Serializable{

    private String ip;//原始Ip地址
    private String country;//国家或者区域
    private String area;//区域
    private String province;//省
    private String region;//地区或者地市
    private String city;//城市
    private String county;//县
    private String isp;//运营商
    private String desc;//其他描述

    private Double latitude;//纬度
    private Double longtitude;//经度

    public IPInfo(String ipStr, String country, String province, String region){
         this.ip = ipStr;
         this.country = country;
         this.province = province;
         this.city = region;
    }
}

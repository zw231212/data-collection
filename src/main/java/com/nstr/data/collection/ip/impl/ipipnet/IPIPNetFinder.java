package com.nstr.data.collection.ip.impl.ipipnet;


import com.nstr.data.collection.model.ip.IPInfo;

/**
 */
public class IPIPNetFinder {

    public static IPInfo findIP(String ipStr){
        String[] infos = IPIP.find(ipStr);
        IPInfo ipInfo = new IPInfo();
        ipInfo.setCountry(infos[0]);
        ipInfo.setProvince(infos[1]);
        ipInfo.setCity(infos[2]);
        //ipInfo.setDesc(infos[3]);//第四个字段信息未名
        return ipInfo;
    }
}

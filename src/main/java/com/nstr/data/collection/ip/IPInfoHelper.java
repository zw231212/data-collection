package com.nstr.data.collection.ip;

import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.ip.impl.geoip.GeoIPFinder;
import com.nstr.data.collection.ip.impl.ipipnet.IPIPNetFinder;
import com.nstr.data.collection.model.ip.IPInfo;
import com.nstr.data.collection.util.StringUtil;

/**
 */
public class IPInfoHelper {

    /**
     * 查找ip信息
     * 如果没有查到再查远程淘宝和新浪的API
     * @param ipStr
     * @param type  ip 插件
     * @return
     */
    public static IPInfo findIP(String ipStr, String type){
        IPInfo ipInfo = new IPInfo(ipStr, AppConstant.UNKOWN_INFO, AppConstant.UNKOWN_INFO, AppConstant.UNKOWN_INFO);
        if(StringUtil.isNullOrBlank(ipStr)){
            return ipInfo;
        }
        if(type == null || "".equals(type.trim())){
              type = AppConstant.ipPluginNames.get(0);
        }

        //类型检查在controller里面
        switch (type){
            case "ipipnet":
                ipInfo =  IPIPNetFinder.findIP(ipStr);
                break;
            case "geoip":
                ipInfo =  GeoIPFinder.findIP(ipStr);
                break;
        }
        return ipInfo;
    }

}

package com.nstr.data.collection.ip.impl.geoip;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Subdivision;
import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.model.ip.IPInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class GeoIPFinder {

    private static final Logger logger = LoggerFactory.getLogger(GeoIPFinder.class);

    private static DatabaseReader reader = GeoIP2DataLoader.reader;

    private static final String DEFAULT_LOCAL="zh-CN";

    public static IPInfo findIP(String ipStr){
        IPInfo ipInfo = null;
        try {
            InetAddress ipAddress = InetAddress.getByName(ipStr);
            CityResponse response = reader.city(ipAddress);
            ipInfo = transResponse2IPInfo(response,DEFAULT_LOCAL);
        } catch (UnknownHostException e) {
            //e.printStackTrace();
            logger.error("UnknownHostException:["+e.getMessage()+"].");
        }catch (GeoIp2Exception e) {
            logger.error("GeoIp2Exception:["+e.getMessage()+"].");
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("IOException:["+e.getMessage()+"].");
        }
        if(ipInfo!=null) {
            ipInfo.setIp(ipStr);

        } else {
            ipInfo = new IPInfo(ipStr, AppConstant.UNKOWN_INFO, AppConstant.UNKOWN_INFO, AppConstant.UNKOWN_INFO);
        }
        return ipInfo;
    }

    /**
     * 将读取本地geoipcity得到的返回信息封装为我们的ip实体类
     * @param response 查询返回信息的封装类
     * @return 自定义封装的ip信息实体类
     */
    private IPInfo transResponse2IPInfo(CityResponse response) {
        if(response == null){
            return null;
        }

        IPInfo ipInfo = new IPInfo();
        Country country = response.getCountry();
        ipInfo.setCountry(country.getName());

        Subdivision subdivision = response.getMostSpecificSubdivision();
        ipInfo.setProvince(subdivision.getName());

        City city = response.getCity();
        ipInfo.setCity(city.getName());

        Location location = response.getLocation();
        ipInfo.setLatitude(location.getLatitude());
        ipInfo.setLongtitude(location.getLongitude());
        return ipInfo;
    }

    /**
     *将读取本地geoipcity得到的返回信息封装为我们的ip实体类
     * @param response
     * @param local 本地化的信息
     * @return
     */
    private static IPInfo transResponse2IPInfo(CityResponse response,String local) {
        if(response == null){
            return null;
        }
        IPInfo ipInfo = new IPInfo();

        Country country = response.getCountry();
        ipInfo.setCountry(country.getNames().get(local));

        Subdivision subdivision = response.getMostSpecificSubdivision();
        ipInfo.setProvince(subdivision.getNames().get(local));
        City city = response.getCity();
        ipInfo.setCity(city.getNames().get(local));
        Location location = response.getLocation();
        
        ipInfo.setLatitude(location.getLatitude());
        ipInfo.setLongtitude(location.getLongitude());
        return ipInfo;
    }
}

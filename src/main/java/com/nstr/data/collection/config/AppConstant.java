package com.nstr.data.collection.config;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

  public static final String IPNET_RESOURCE="/ip/ipipnet/17monipdb.dat";
  public static final String GEOIP2_CITY_RESOURCE="/ip/GeoLite2-City.mmdb";

  /**
   * 启用的ip解析的插件，分别是geoip（默认），ipipnet，不启用解析，不启用解析并且对ip进行模糊处理
   */
  public static List<String> ipPluginNames = Arrays.asList("geoip", "ipipnet", "NO", "FUZZY");
  public static final String UNKOWN_INFO = "UNKOWN";

}

package com.nstr.data.collection.config;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

  public static final String IPNET_RESOURCE="/ip/ipipnet/17monipdb.dat";
  public static final String GEOIP2_CITY_RESOURCE="/ip/GeoLite2-City.mmdb";

  public static List<String> ipPluginNames = Arrays.asList("geoip", "ipipnet");
  public static final String UNKOWN_INFO = "UNKOWN";

}

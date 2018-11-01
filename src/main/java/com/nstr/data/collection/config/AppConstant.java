package com.nstr.data.collection.config;

import java.util.Arrays;
import java.util.List;

public class AppConstant {

  public static final String IPNET_RESOURCE="/ip/ipipnet/17monipdb.dat";
  public static final String GEOIP2_CITY_RESOURCE="/ip/GeoLite2-City.mmdb";

  /**
   * 启用的ip解析的插件，分别是geoip（默认），ipipnet，不启用解析，不启用解析并且对ip进行模糊处理
   * 最后fuzzy2表示不启用解析并且模糊后两位
   */
  public static List<String> ipPluginNames = Arrays.asList("geoip", "ipipnet", "no", "fuzzy", "fuzzy2");
  public static List<String> dateTypes = Arrays.asList("day", "month", "year");
  public static final String UNKOWN_INFO = "UNKOWN";
  //评分分数区间
  public static List<Float> scoreRangs = Arrays.asList(5f,4f,3f,2f,1f);
  public static final String COMMENT_TABLE = "nstr_resource_comment";

}

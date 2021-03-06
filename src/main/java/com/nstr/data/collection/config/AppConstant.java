package com.nstr.data.collection.config;

import com.nstr.data.collection.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppConstant {

  public static final String IPNET_RESOURCE="/ip/ipipnet/17monipdb.dat";
  public static final String GEOIP2_CITY_RESOURCE="/ip/GeoLite2-City.mmdb";
  public static final String APP_DEFAULT_CONFIG = "/app.properties";

  /**
   * 启用的ip解析的插件，分别是geoip（默认），ipipnet，不启用解析，不启用解析并且对ip进行模糊处理
   * 最后fuzzy2表示不启用解析并且模糊后两位
   */
  public static List<String> ipPluginNames = Arrays.asList("geoip", "ipipnet", "no", "fuzzy", "fuzzy2");
  public static List<String> dateTypes = Arrays.asList("day", "week", "month", "year");
  public static final String UNKOWN_INFO = "UNKOWN";
  //评分分数区间
  public static List<Float> scoreRangs = Arrays.asList(5f,4f,3f,2f,1f);
  public static final String COMMENT_TABLE = "nstr_resource_comment";
  public static final String DAILY_TABLE = "nstr_daily";
  public static final String DAILY_COLUMN_TABLE = "nstr_daily_column";
  public static final String DAILY_COMMENT_TABLE = "nstr_daily_comment";
  public static List<String> statisticColumns= new ArrayList<>();

  public static final String DAILY_STATISTIC = AppPropLoader.get("schedule.dailyStatistic");
  public static final String BACKUP_HISTORY_COMMENT = AppPropLoader.get("schedule.backupHistoryComment");
  public static final String BACKUP_TYPE = AppPropLoader.get("backup.type");
  public static List<String> backupTypes= Arrays.asList("month", "week");
  public static int DEFAULT_TAG_SIZE = 20;

  static {
    //要统计哪些列信息
    String scs = AppPropLoader.get("statistic.columns");
    String[] scArr = scs.split(",");
    for (String s : scArr) {
      if(StringUtil.isNullOrBlank(s)){
        continue;
      }
      s = s.trim().toLowerCase();
      statisticColumns.add(s);
    }

    String s = AppPropLoader.get("tags.defaultSize");
    if(!StringUtil.isNullOrBlank(s)){
      DEFAULT_TAG_SIZE = Integer.parseInt(s);
    }
  }

}

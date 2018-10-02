package com.nstr.data.collection.ip.impl.geoip;

import com.maxmind.geoip2.DatabaseReader;
import com.nstr.data.collection.config.AppConstant;
import com.nstr.data.collection.util.PathUtil;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class GeoIP2DataLoader {
    private static Logger logger = LoggerFactory.getLogger(GeoIP2DataLoader.class);

    public static DatabaseReader reader = null;

    public static String CITY_DATABASE_PATH = null;

    static {    //读取配置文件数据库
      CITY_DATABASE_PATH = PathUtil.getClasspathFile(AppConstant.GEOIP2_CITY_RESOURCE);
      File database = new File(CITY_DATABASE_PATH);
      try {
        logger.info("导入本地的数据库:"+CITY_DATABASE_PATH);
        reader = new DatabaseReader.Builder(database).build();
      } catch (IOException e) {
        e.printStackTrace();
        logger.error("Build geoip2 database failed! The geoip2 database path is "+CITY_DATABASE_PATH);
      }
    }
}

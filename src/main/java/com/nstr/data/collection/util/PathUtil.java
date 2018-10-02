package com.nstr.data.collection.util;

import java.net.URL;

public class PathUtil {

  /**
   * 读取在classpath下默认的数据库：GeoLite2-City.mmdb的文件路径
   * @return 返回数据库的文件路径
   */
  public static String getClasspathFile(String name){
    if(name == null || "".equals(name.trim())){
      return null;
    }
    URL resource = PathUtil.class.getResource(name);
    return resource.getPath();
  }

}

package com.nstr.data.collection.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class URLUtil {

    public static Map<String,Object> parseArgs(String agrs){
        if(agrs == null || "".equals(agrs.trim())){
          return null;
        }
      String u = null;
      try {
          u = URLDecoder.decode(agrs, "UTF-8");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
      Map<String,Object> argInfos = new HashMap<String, Object>();
      String[] infos = u.split("&");
      for (String info : infos) {
        String[] split = info.split("=");
        if(split.length == 2){
          argInfos.put(split[0],split[1]);
        }
      }

      return argInfos;
    }
}

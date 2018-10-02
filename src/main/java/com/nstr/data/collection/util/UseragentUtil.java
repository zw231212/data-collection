package com.nstr.data.collection.util;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解析user agent 获取浏览器类型和操作系统类型
 * @author zzq
 * @email 191550636@qq.com
 */
public class UseragentUtil {


  public static UserAgentInfo parse(String uastr){
    UserAgent userAgent = UserAgent.parseUserAgentString(uastr);
    UserAgentInfo uai = new UserAgentInfo();
    Entity browser = new Entity();
    Browser bs1 = userAgent.getBrowser();
    browser.setName(bs1.getGroup().getName());
    browser.setVersion(bs1.getVersion(uastr).getVersion());
    browser.setManufacturer(bs1.getManufacturer().getName());
    browser.setType(bs1.getBrowserType().toString());

    uai.setBrowser(browser);

    Entity os = new Entity();
    OperatingSystem uaos = userAgent.getOperatingSystem();
    os.setName(uaos.getGroup().getName());
    String name = uaos.getName();
    if(name != null && name.split(" ").length==2){
      os.setVersion(name.split(" ")[1]);
    }
    os.setType(uaos.getDeviceType().getName());
    os.setManufacturer(uaos.getManufacturer().getName());
    uai.setOs(os);

     return uai;
  }


  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class UserAgentInfo{
    private Entity browser;
    private Entity os;

  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Entity{
    private String name;  //名称
    private String version; //所属型号，全部的
    private String type;//所属类型
    private String manufacturer;  //制造商
  }


}

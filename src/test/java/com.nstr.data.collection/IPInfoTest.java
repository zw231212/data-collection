package com.nstr.data.collection;

import com.nstr.data.collection.ip.IPInfoHelper;
import com.nstr.data.collection.model.ip.IPInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import junit.framework.Assert;
import org.junit.Test;

public class IPInfoTest {

  @Test
  public void testFindIP(){
    String ip = "124.207.169.10";
    long l1 = System.currentTimeMillis();
    IPInfo ipInfo = IPInfoHelper.findIP(ip,"geoip");
    long l2 = System.currentTimeMillis();
    System.out.println(ipInfo);
    System.out.println("所用时间："+(l2-l1) +" ms!");
    Assert.assertEquals("中国",ipInfo.getCountry());
  }

  @Test
  public void testIPS(){
    InputStream inputStream = IPInfoTest.class.getResourceAsStream("/ips.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    String line = null;
    long l1 = System.currentTimeMillis();
    int count = 0;
    try {
      while((line =br.readLine())!=null){
        count++;
        IPInfo ip = IPInfoHelper.findIP(line,"ipipnet");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      try {
        if(br!=null){
          br.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    long l2 = System.currentTimeMillis();
    System.out.println("查询数量"+count+",总共用时："+(l2-l1)+" ms");
  }

}

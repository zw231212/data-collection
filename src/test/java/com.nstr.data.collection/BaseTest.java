package com.nstr.data.collection;

import com.nstr.data.collection.config.AppConstant;
import java.util.Date;
import org.junit.Test;

public class BaseTest {

  @Test
  public void test(){
    System.out.println("Base Test!");
    long time = new Date().getTime();
    System.out.println(new Date(time));
    System.out.println(AppConstant.scoreRangs.get(0));
  }

}

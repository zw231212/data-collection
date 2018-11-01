package com.nstr.data.collection.config;

import java.io.InputStream;
import java.util.Properties;

public class AppPropLoader {

    private static Properties properties = new Properties();

    static {
        try{
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in =AppPropLoader.class.getResource(AppConstant.APP_DEFAULT_CONFIG).openStream();
            // 使用properties对象加载输入流
            properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 根据属性名或者属性值
     * @param key properties文件中的属性名
     * @return value properties文件中的属性值
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }

}

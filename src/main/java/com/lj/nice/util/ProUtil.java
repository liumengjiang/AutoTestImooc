package com.lj.nice.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProUtil {

    private Properties prop;
    private String filePath;

    /*
     * 构造方法
     * */
    //初始化new ProUtil是从外部传回一个properties文件的路径
    public ProUtil(String filePath)
    {
        //外部文件路径赋值给当前类的文件路径
        this.filePath=filePath;
        this.prop=readProperties();
    }
    /*
     * 读取配置文件
     *
     * */
    private Properties readProperties(){
        //创建一个Properties
        Properties properties=new Properties();
        try {
            //使用文件读取并且使用properties文件进行加载出来
            InputStream inputStream=new FileInputStream(filePath);
            BufferedInputStream bis=new BufferedInputStream(inputStream);
            properties.load(bis);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return properties;
    }

    /*
     * 封装配置文件中的getProperty方法
     * */
    public String getPro(String key){
        //判断properties文件中是否包含key信息
        if(prop.containsKey(key))
        {
            String username=prop.getProperty(key);
            return username;
        }else{
            System.out.println("你获取的值不存在");
            return "";
        }

    }

    /**
     * 写入内容
     * */
    public void writePro(String key,String value){
        Properties pro = new Properties();
        try {
            FileOutputStream file = new FileOutputStream(filePath);
            pro.setProperty(key, value);
            pro.store(file, key);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

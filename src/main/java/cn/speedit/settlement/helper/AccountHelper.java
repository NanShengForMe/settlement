package cn.speedit.settlement.helper;

import java.io.*;
import java.util.Properties;

/**
 * @author Zoujidi
 * @title: AcountHelper
 * @projectName settlement
 * @description: 从配置文件中获取userkek等信息
 * @date 2019/9/19 13:56
 */
public final class AccountHelper {

    /**
     * 合工大配置文件路径
     */
    // private static final String path = "/account_hfut.properties";

    /**
     * 川大配置文件路径
     */
    private static final String path = "/account_scu.properties";


    private AccountHelper(){}

    /**
     * 获取account.properties对象
     * @return
     */
    private static Properties getProperties(){
        Properties properties = new Properties();
        InputStream inputStream = AccountHelper.class.getResourceAsStream(path);

        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getUrl(){
        return getProperties().getProperty("ws.url");
    }

    public static String getUserId(){
        return getProperties().getProperty("ws.userid");
    }

    public static String getUserName(){
        return getProperties().getProperty("ws.username");
    }

    public static String getUserKey(){
        return getProperties().getProperty("ws.userkey");
    }

    public static String getVersion(){
        return getProperties().getProperty("ws.verison");
    }

    public static String getEncode(){
        return getProperties().getProperty("ws.encode");
    }

}

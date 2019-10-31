package cn.speedit.settlement.util;

import cn.speedit.settlement.bean.Record;
import cn.speedit.settlement.bean.rtn.*;
import cn.speedit.settlement.helper.LogHelper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.TimeZone;

/**
 * @author Zoujidi
 * @title: XmlParseUtil
 * @projectName XStream
 * @description: xml与bean相互转换工具类
 * @date 2019/7/24 11:32
 */
public class XmlParseUtil {

    // 解决双下划线
    public static final XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder("-_", "_");

    // 编码格式
    private static final String ENCODING = "UTF-8";

    // dom解析驱动
    private static final DomDriver fixDriver = new DomDriver(ENCODING, nameCoder);

    // 通用解析器
    // public static final XStream XSTREAM = new XStream(fixDriver);

    // 时区(对象中有日期时需注意)
    private static final String CHINA_TIME_ZONE = "Asia/Shanghai";

    // 添加需要授权的bean
    private static final Class[] allowClazzs = new Class[]{
            ErrorRtn.class,
            FileUploadRtn.class,
            FileDownloadRtn.class,
            FileDownloadsRtn.class,
            ProvRegRtn.class,
            QueryPrjRecsRtn.class,
            QueryPrjRecsesRtn.class,
            BudgetRtn.class,
            QueryPrjRtn.class,
            QueryPrjInfoRtn.class,
            SubApplyRtn.class
    };

    // 初始化XStream
    static {
        // 时区处理
//        TimeZone zone = TimeZone.getTimeZone(CHINA_TIME_ZONE); //获得时区
//        XSTREAM.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
//        XSTREAM.autodetectAnnotations(true); //开启序列化的注解形式
//        XSTREAM.setMode(XStream.NO_REFERENCES);//取消引用,如果没有这一步,会出现xml引用格式reference
//        XStream.setupDefaultSecurity(XSTREAM);
//        XSTREAM.allowTypes(allowClazzs);
//        XSTREAM.registerConverter(new XStreamDateConverter());
//        XSTREAM.registerConverter(new XStreamDateConverterHMS());
    }



    public static final String XML_HEAD = "<?xml version=\"1.0\" encoding=\":encode\" ?>";

    /**
    　　* @description: bean转换xm方法
    　　* @author Zoujidi
    　　* @date 2019/7/24 11:38
    　　*/
    public static String bean2Xml(Object obj) {
        XStream xstream = compose(new XStream(fixDriver));
        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    /**
    　　* @description: xml转bean方法
    　　* @throws
    　　* @author Zoujidi
    　　* @date 2019/9/25 16:23
    　　*/
    public static <T> T xml2Bean(String xmlData, Class<T> clazz){
        T t = null;
        XStream xstream = compose(new XStream(fixDriver));
        xstream.processAnnotations(clazz);//开启此类的解析,否则无法解析
        try {
            t = (T)xstream.fromXML(xmlData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
    　　* @description: bean转xml（以文件方式输出）
    　　* @author Zoujidi
    　　* @date 2019/7/24 11:42
    　　*/
    public static void outputFile(Object obj, String filePath) throws FileNotFoundException {
        XStream xstream = compose(new XStream(fixDriver));
        xstream.processAnnotations(obj.getClass());
        // create target file
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        // output
        xstream.toXML(obj, fileOutputStream);
    }


    public static XStream compose(XStream xStream){
        // 时区处理
        TimeZone zone = TimeZone.getTimeZone(CHINA_TIME_ZONE); //获得时区
        xStream.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
        xStream.autodetectAnnotations(true); //开启序列化的注解形式
        xStream.setMode(XStream.NO_REFERENCES);//取消引用,如果没有这一步,会出现xml引用格式reference
        try{
            XStream.setupDefaultSecurity(xStream);
        }catch (IllegalArgumentException e){
            LogHelper.record("xstream安全等级已设置");
        }
        xStream.allowTypes(allowClazzs);
        xStream.registerConverter(new XStreamDateConverter());
        xStream.registerConverter(new XStreamDateConverterHMS());
        return xStream;
    }

}

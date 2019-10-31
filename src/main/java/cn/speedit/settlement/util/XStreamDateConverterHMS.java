package cn.speedit.settlement.util;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zoujidi
 * @title: XStreamDateConverter
 * @projectName settlement
 * @description: 时间格式转换器（xml2bean）
 * @date 2019/9/25 21:43
 */
public class XStreamDateConverterHMS implements SingleValueConverter {

    @Override
    public boolean canConvert(Class arg0) {
        return Date.class == arg0;
    }

    @Override
    public Object fromString(String arg0) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            if(StringUtils.isNotEmpty(arg0)){
                return format.parse(arg0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString(Object arg0) {
        return arg0.toString();
    }

}

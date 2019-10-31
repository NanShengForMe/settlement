package cn.speedit.settlement.util;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Zoujidi
 * @title: DateConvert
 * @projectName XStream
 * @description: 日期格式转换器
 * @date 2019/7/24 10:28
 */
public class DateConvert implements Converter {
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        Date date = (Date) source;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        writer.setValue(format.format(calendar.getTime()));
    }

    @Override
    public Date unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        String dateStr = reader.getValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // Calendar calendar = Calendar.getInstance();
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public boolean canConvert(Class clazz) {
        return (Date.class).equals(clazz);
    }
}

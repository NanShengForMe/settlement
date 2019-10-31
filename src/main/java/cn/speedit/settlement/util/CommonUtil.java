package cn.speedit.settlement.util;

/**
 * @author Zoujidi
 * @title: CommonUtil
 * @projectName settlement
 * @description: 常用工具
 * @date 2019/9/19 9:45
 */
public class CommonUtil {

    public static boolean isNe(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof CharSequence) {
            if (o.toString().trim().length() == 0) {
                return true;
            }
        } else if (o.getClass().isArray()) {
            if (o.getClass() == byte[].class) {
                byte[] bt = (byte[]) o;
                if (bt.length == 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (o.getClass() == char[].class) {
                char[] bt = (char[]) o;
                if (bt.length == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            if (o instanceof Object[]) {
                Object[] to = (Object[]) o;
                for (int i = 0; i < to.length; i++) {
                    if (!isNe(to[i])) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}

package cn.speedit.settlement.helper;

import cn.speedit.settlement.constant.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zoujidi
 * @title: LogHelper
 * @projectName settlement
 * @description: 上下文记录器
 * @date 2019/9/19 9:58
 */
public final class LogHelper {

    /**
     * 记录信息的默认格式: 前缀-信息体
     */
    private static final String defaultPattern = "{}-{}";

    /**
     * Thread.currentThread().getStackTrace()返回一个堆栈轨迹元素数组
     * @return
     */
    private static Logger getLogger() {
        final String callerClassName = Thread.currentThread().getStackTrace()[3].getClassName();
        return LoggerFactory.getLogger(callerClassName);
    }

    private LogHelper() {
    }

    /**
     * @param formatMessage 格式消息
     * @param parameters 消息参数
     */
    public static void record(String formatMessage, Object... parameters) {
        getLogger().info(defaultPattern, GlobalConstant.SETTLEMENT, String.format(formatMessage, parameters));
    }

    public static void record(String message) {
        getLogger().info(defaultPattern, GlobalConstant.SETTLEMENT, message);
    }

    public static void record(Object o) {
        getLogger().info(defaultPattern, GlobalConstant.SETTLEMENT, o.toString());
    }

}

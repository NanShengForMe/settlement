package cn.speedit.settlement.exception;

import cn.speedit.settlement.constant.GlobalConstant;

/**
　　* @description: 运行异常 抽象
　　* @author Zoujidi
　　* @date 2019/9/19 10:43
　　*/
public abstract class AbstractRuntimeException extends RuntimeException {

    /**
     * 真正的异常信息
     */
    private String realMessage;

    /**
     * 构建运行异常
     * @param message
     */
    public AbstractRuntimeException(String message) {
        super();
        this.realMessage = String.format("%s-%s", GlobalConstant.SETTLEMENT, message);
    }

    /**
     * 构建运行异常
     * @param cause
     */
    public AbstractRuntimeException(Throwable cause) {
        super();
        /*while (Objects.nonNull(cause.getCause()))
            cause = cause.getCause();*/
        this.realMessage = String.format("%s-%s", GlobalConstant.SETTLEMENT, cause.getMessage());
    }

    @Override
    public String getMessage() {
        return this.realMessage;
    }

}

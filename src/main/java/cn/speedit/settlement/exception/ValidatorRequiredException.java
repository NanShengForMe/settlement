package cn.speedit.settlement.exception;

/**
 * @author Zoujidi
 * @title: ValidatorRequiredException
 * @projectName settlement
 * @description: 验证必填项异常
 * @date 2019/9/19 11:27
 */
public class ValidatorRequiredException extends AbstractRuntimeException {


    /**
     * 验证必填项异常
     * @param message
     */
    public ValidatorRequiredException(String message) {
        super(message);
    }

}

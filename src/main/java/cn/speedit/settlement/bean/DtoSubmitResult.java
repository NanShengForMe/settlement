package cn.speedit.settlement.bean;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author Zoujidi
 * @title: DtoSubmitResult
 * @projectName finance-middleware
 * @description: 提交结果返回内容
 * @date 2019/11/11 11:37
 */
public class DtoSubmitResult<T>  {

    /** 是否操作成功 */
    private boolean success;
    /** 操作成功返回数据 */
    private T record;
    /** 错误码 */
    private String code;
    /** 错误信息 */
    private String msg;

    /***
     * Description:  有参构造
     * @param success
     * @param code
     * @param msg
     * @return
     * @author ZouJiDi
     * @date 2019/11/11 11:41
     */
    public DtoSubmitResult(boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.record = null;
    }

    /***
     * Description:  有参构造
     * @param success
     * @param record
     * @return
     * @author ZouJiDi
     * @date 2019/11/12 15:46
     */
    public DtoSubmitResult(boolean success, T record) {
        this.success = success;
        this.record = record;
        this.code = null;
        this.msg = null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

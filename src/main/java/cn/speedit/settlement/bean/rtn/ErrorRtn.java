package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
　　* @description: 错误返回信息
　　* @throws
　　* @author Zoujidi
　　* @date 2019/9/25 19:51
　　*/
@XStreamAlias("error")
public class ErrorRtn implements Serializable {

    private final static long serialVersionUID = 1L;
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_MSG = "msg";

    /** 错误代码 */
    @XStreamAlias("type")
    private String type;

    /** 错误信息 */
    @XStreamAlias("msg")
    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

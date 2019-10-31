package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Zoujidi
 * @title: ProvRegRtn
 * @projectName settlement
 * @description: 注册供应商返回信息
 * @date 2019/9/25 19:59
 */
@XStreamAlias("return")
public class ProvRegRtn implements Serializable {

    private final static long serialVersionUID = 1L;
    public static final String FIELD_PROV_CODE = "prov_code";

    /** 供应商编码 */
    @XStreamAlias("prov_code")
    private String provCode;

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Zoujidi
 * @title: SubApplyRtn
 * @projectName settlement
 * @description: 申请结算返回
 * @date 2019/9/26 8:42
 */
@XStreamAlias("body")
public class SubApplyRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 结算申请号 */
    @XStreamAlias("apply_no")
    private String applyNo;

    /** 预约单号 */
    @XStreamAlias("serial_no")
    private String serialNo;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

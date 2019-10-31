package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Zoujidi
 * @title: BudgetRtn
 * @projectName settlement
 * @description: 返回预算项
 * @date 2019/9/25 20:41
 */
@XStreamAlias("budget")
public class BudgetRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 预算代码 */
    @XStreamAlias("bu_code")
    private String buCode;

    /** 预算名称 */
    @XStreamAlias("bu_name")
    private String buName;

    /** 最大可用额度 */
    @XStreamAlias("max_amt")
    private BigDecimal maxAmt;

    /** 当前剩余额度 */
    @XStreamAlias("balance")
    private BigDecimal balance;

    /**  */
    @XStreamAlias("grantee_sno")
    private String granteeSno;

    /**  */
    @XStreamAlias("grantee_name")
    private String granteeName;

    /**  */
    @XStreamAlias("grantee_prj_code")
    private String granteePrjCode;

    /**  */
    @XStreamAlias("grantee_prj_name")
    private String granteePrjName;

    /**  */
    @XStreamAlias("grant_id")
    private String grantId;

    /**  */
    @XStreamAlias("grant_type")
    private String grantType;

    /**  */
    @XStreamAlias("grant_kind")
    private String grantKind;


    public String getBuCode() {
        return buCode;
    }

    public void setBuCode(String buCode) {
        this.buCode = buCode;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public BigDecimal getMaxAmt() {
        return maxAmt;
    }

    public void setMaxAmt(BigDecimal maxAmt) {
        this.maxAmt = maxAmt;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getGranteeSno() {
        return granteeSno;
    }

    public void setGranteeSno(String granteeSno) {
        this.granteeSno = granteeSno;
    }

    public String getGranteeName() {
        return granteeName;
    }

    public void setGranteeName(String granteeName) {
        this.granteeName = granteeName;
    }

    public String getGranteePrjCode() {
        return granteePrjCode;
    }

    public void setGranteePrjCode(String granteePrjCode) {
        this.granteePrjCode = granteePrjCode;
    }

    public String getGranteePrjName() {
        return granteePrjName;
    }

    public void setGranteePrjName(String granteePrjName) {
        this.granteePrjName = granteePrjName;
    }

    public String getGrantId() {
        return grantId;
    }

    public void setGrantId(String grantId) {
        this.grantId = grantId;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getGrantKind() {
        return grantKind;
    }

    public void setGrantKind(String grantKind) {
        this.grantKind = grantKind;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

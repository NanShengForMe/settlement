package cn.speedit.settlement.bean.rtn;

import cn.speedit.settlement.util.XStreamDateConverterHMS;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zoujidi
 * @title: QueryApplyProgressRtn
 * @projectName settlement
 * @description: 查询结算进度返回
 * @date 2019/9/26 8:49
 */
@XStreamAlias("return")
public class QueryApplyProgressRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 供应商编码 */
    @XStreamAlias("prov_code")
    private String provCode;

    /** 结算申请号 */
    @XStreamAlias("apply_no")
    private String applyNo;

    /** 供应商名称 */
    @XStreamAlias("prov_name")
    private String provName;

    /** 账号 */
    @XStreamAlias("acnt")
    private String acnt;

    /** 开户行 */
    @XStreamAlias("accbank")
    private String accbank;

    /** 联行号 */
    @XStreamAlias("branchcode")
    private String branchCode;

    /** 申请结算金额 */
    @XStreamAlias("apply_amt")
    private String applyAmt;

    /** 申请结算人 */
    @XStreamAlias("apply_user")
    private String applyUser;

    /** 申请结算时间 */
    @XStreamAlias("apply_date")
    @XStreamConverter(value = XStreamDateConverterHMS.class)
    private Date applyDate;

    /** 预约单号 */
    @XStreamAlias("req_no")
    private String reqNo;

    /** 入账凭证号 */
    @XStreamAlias("pz_uni_no")
    private String pzUniNo;

    /** 支付状态(尚未支付/正在支付/支付成功/支付失败) */
    @XStreamAlias("pay_status")
    private String payStatus;

    /** 支付时间 */
    @XStreamAlias("pay_date")
    @XStreamConverter(value = XStreamDateConverterHMS.class)
    private Date payDate;

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getAcnt() {
        return acnt;
    }

    public void setAcnt(String acnt) {
        this.acnt = acnt;
    }

    public String getAccbank() {
        return accbank;
    }

    public void setAccbank(String accbank) {
        this.accbank = accbank;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getApplyAmt() {
        return applyAmt;
    }

    public void setApplyAmt(String applyAmt) {
        this.applyAmt = applyAmt;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getPzUniNo() {
        return pzUniNo;
    }

    public void setPzUniNo(String pzUniNo) {
        this.pzUniNo = pzUniNo;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

package cn.speedit.settlement.bean.rtn;

import cn.speedit.settlement.util.XStreamDateConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Zoujidi
 * @title: QueryPrjRtn
 * @projectName settlement
 * @description: 查询项目信息返回（根据项目代码和费用项查询）
 * @date 2019/9/25 20:33
 */
@XStreamAlias("return")
public class QueryPrjInfoRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 项目代码 */
    @XStreamAlias("uni_prj_code")
    private String uniPrjCode;

    /** 项目名称 */
    @XStreamAlias("uni_prj_name")
    private String uniPrjName;

    /** 负责人工号 */
    @XStreamAlias("charge_sno")
    private String chargeSno;

    /** 负责人姓名 */
    @XStreamAlias("charge_name")
    private String chargeName;

    /** 项目所属部门代码 */
    @XStreamAlias("sa_depart")
    private String saDepart;

    /** 是否国库项目(Y/N) */
    @XStreamAlias("gk_flag")
    private String gkFlag;

    /**  */
    @XStreamAlias("p_code")
    private String pCode;

    /** 结题日期(YYYY-MM-DD) */
    @XStreamAlias("finish_date")
    @XStreamConverter(value = XStreamDateConverter.class)
    private Date finishDate;

    /** 额度 */
    @XStreamAlias("max_amt")
    private BigDecimal maxAmt;

    /**  */
    @XStreamAlias("balance")
    private BigDecimal balance;

    /** 预算代码 */
    @XStreamAlias("bu_code")
    private String buCode;

    /** 预算名称 */
    @XStreamAlias("bu_name")
    private String buName;

    /**  */
    @XStreamAlias("attach_act")
    private String attachAct;

    /**  */
    @XStreamAlias("sa_f01")
    private String saF01;

    /**  */
    @XStreamAlias("sa_f02")
    private String saF02;

    /**  */
    @XStreamAlias("sa_f03")
    private String saF03;

    /**  */
    @XStreamAlias("sa_f04")
    private String saF04;

    /**  */
    @XStreamAlias("sa_f05")
    private String saF05;

    /**  */
    @XStreamAlias("sa_f06")
    private String saF06;

    /**  */
    @XStreamAlias("sa_f07")
    private String saF07;

    /**  */
    @XStreamAlias("sa_f08")
    private String saF08;

    /**  */
    @XStreamAlias("sa_f09")
    private String saF09;

    /**  */
    @XStreamAlias("sa_f10")
    private String saF10;

    /**  */
    @XStreamAlias("sa_f11")
    private String saF11;

    /**  */
    @XStreamAlias("sa_f12")
    private String saF12;

    /**  */
    @XStreamAlias("sa_f13")
    private String saF13;

    /**  */
    @XStreamAlias("sa_f14")
    private String saF14;

    /**  */
    @XStreamAlias("sa_f15")
    private String saF15;

    /**  */
    @XStreamAlias("sa_f16")
    private String saF16;

    /**  */
    @XStreamAlias("sa_f17")
    private String saF17;

    /**  */
    @XStreamAlias("sa_f18")
    private String saF18;

    /**  */
    @XStreamAlias("sa_f19")
    private String saF19;

    /**  */
    @XStreamAlias("sa_f20")
    private String saF20;

    /** 预算项 */
    @XStreamAlias("budgets")
    private List<BudgetRtn> budgetRtns;

    public String getUniPrjCode() {
        return uniPrjCode;
    }

    public void setUniPrjCode(String uniPrjCode) {
        this.uniPrjCode = uniPrjCode;
    }

    public String getUniPrjName() {
        return uniPrjName;
    }

    public void setUniPrjName(String uniPrjName) {
        this.uniPrjName = uniPrjName;
    }

    public String getChargeSno() {
        return chargeSno;
    }

    public void setChargeSno(String chargeSno) {
        this.chargeSno = chargeSno;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getSaDepart() {
        return saDepart;
    }

    public void setSaDepart(String saDepart) {
        this.saDepart = saDepart;
    }

    public String getGkFlag() {
        return gkFlag;
    }

    public void setGkFlag(String gkFlag) {
        this.gkFlag = gkFlag;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public BigDecimal getMaxAmt() {
        return maxAmt;
    }

    public void setMaxAmt(BigDecimal maxAmt) {
        this.maxAmt = maxAmt;
    }

    public List<BudgetRtn> getBudgetRtns() {
        return budgetRtns;
    }

    public void setBudgetRtns(List<BudgetRtn> budgetRtns) {
        this.budgetRtns = budgetRtns;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSaF01() {
        return saF01;
    }

    public void setSaF01(String saF01) {
        this.saF01 = saF01;
    }

    public String getSaF02() {
        return saF02;
    }

    public void setSaF02(String saF02) {
        this.saF02 = saF02;
    }

    public String getSaF03() {
        return saF03;
    }

    public void setSaF03(String saF03) {
        this.saF03 = saF03;
    }

    public String getSaF04() {
        return saF04;
    }

    public void setSaF04(String saF04) {
        this.saF04 = saF04;
    }

    public String getSaF05() {
        return saF05;
    }

    public void setSaF05(String saF05) {
        this.saF05 = saF05;
    }

    public String getSaF06() {
        return saF06;
    }

    public void setSaF06(String saF06) {
        this.saF06 = saF06;
    }

    public String getSaF07() {
        return saF07;
    }

    public void setSaF07(String saF07) {
        this.saF07 = saF07;
    }

    public String getSaF08() {
        return saF08;
    }

    public void setSaF08(String saF08) {
        this.saF08 = saF08;
    }

    public String getSaF09() {
        return saF09;
    }

    public void setSaF09(String saF09) {
        this.saF09 = saF09;
    }

    public String getSaF10() {
        return saF10;
    }

    public void setSaF10(String saF10) {
        this.saF10 = saF10;
    }

    public String getSaF11() {
        return saF11;
    }

    public void setSaF11(String saF11) {
        this.saF11 = saF11;
    }

    public String getSaF12() {
        return saF12;
    }

    public void setSaF12(String saF12) {
        this.saF12 = saF12;
    }

    public String getSaF13() {
        return saF13;
    }

    public void setSaF13(String saF13) {
        this.saF13 = saF13;
    }

    public String getSaF14() {
        return saF14;
    }

    public void setSaF14(String saF14) {
        this.saF14 = saF14;
    }

    public String getSaF15() {
        return saF15;
    }

    public void setSaF15(String saF15) {
        this.saF15 = saF15;
    }

    public String getSaF16() {
        return saF16;
    }

    public void setSaF16(String saF16) {
        this.saF16 = saF16;
    }

    public String getSaF17() {
        return saF17;
    }

    public void setSaF17(String saF17) {
        this.saF17 = saF17;
    }

    public String getSaF18() {
        return saF18;
    }

    public void setSaF18(String saF18) {
        this.saF18 = saF18;
    }

    public String getSaF19() {
        return saF19;
    }

    public void setSaF19(String saF19) {
        this.saF19 = saF19;
    }

    public String getSaF20() {
        return saF20;
    }

    public void setSaF20(String saF20) {
        this.saF20 = saF20;
    }

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

    public String getAttachAct() {
        return attachAct;
    }

    public void setAttachAct(String attachAct) {
        this.attachAct = attachAct;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}

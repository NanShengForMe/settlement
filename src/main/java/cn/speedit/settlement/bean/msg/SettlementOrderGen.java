/**
 * Copyright (c) 2017, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package cn.speedit.settlement.bean.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 简介：生成订单
 * 
 * @author 李珂 2017年10月21日 下午2:56:22
 */
public class SettlementOrderGen implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_PROV_CODE = "prov_code";
	public static final String FIELD_ORDER_NO = "order_no";
	public static final String FIELD_FROZEN_USER = "frozen_user";
	public static final String FIELD_UNI_PRJ_CODE = "uni_prj_code";
	public static final String FIELD_BU_CODE = "bu_code";
	public static final String FIELD_GRANT_ID  = "grant_id ";
	public static final String FIELD_B_CODE = "b_code";
	public static final String FIELD_ZC_FLAG = "zc_flag";
	public static final String FIELD_FROZEN_AMT = "frozen_amt";
	public static final String FIELD_FROZEN_REMARK = "frozen_remark";

	/** 供应商编码 */
	@Size(max = 10, message = "provCode 最大长度不能大于10")
	@NotNull(message = "provCode 不能为空")
	private String provCode;
	/** 订单号 */
	@Size(max = 20, message = "orderNo 最大长度不能大于20")
	@NotNull(message = "orderNo 不能为空")
	private String orderNo;
	/** 冻结人 */
	@Size(max = 20, message = "frozenUser 最大长度不能大于20")
	@NotNull(message = "frozenUser 不能为空")
	private String frozenUser;
	/** 项目代码 */
	@Size(max = 32, message = "uniPrjCode 最大长度不能大于32")
	@NotNull(message = "uniPrjCode 不能为空")
	private String uniPrjCode;
	/** 预算项代码【如果budgets.size>1】 */
	@Size(max = 20, message = "buCode 最大长度不能大于20")
	private String buCode;
	/** 授权码 */
	@Size(max = 20, message = "grantId 最大长度不能大于20")
	private String grantId;
	/** 费用项代码 */
	@Size(max = 8, message = "bCode 最大长度不能大于8")
	@NotNull(message = "bCode 不能为空")
	private String bCode;
	/** 是否资产预约单（Y/N） */
	@Size(max = 1, message = "zcFlag 最大长度不能大于1")
	@NotNull(message = "zcFlag 不能为空")
	private String zcFlag;
	/** 冻结金额 */
	@NotNull(message = "frozenAmt 不能为空")
	private BigDecimal frozenAmt;
	/** 冻结原因 */
	@Size(max = 20, message = "frozenRemark 最大长度不能大于20")
	private String frozenRemark;

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getProvCode() {
		return this.provCode;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setFrozenUser(String frozenUser) {
		this.frozenUser = frozenUser;
	}

	public String getFrozenUser() {
		return this.frozenUser;
	}

	public void setUniPrjCode(String uniPrjCode) {
		this.uniPrjCode = uniPrjCode;
	}

	public String getUniPrjCode() {
		return this.uniPrjCode;
	}

	public void setBCode(String bCode) {
		this.bCode = bCode;
	}

	public String getBCode() {
		return this.bCode;
	}

	public void setFrozenAmt(BigDecimal frozenAmt) {
		this.frozenAmt = frozenAmt;
	}

	public BigDecimal getFrozenAmt() {
		return this.frozenAmt;
	}

	public String getBuCode() {
		return buCode;
	}

	public void setBuCode(String buCode) {
		this.buCode = buCode;
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	public String getZcFlag() {
		return zcFlag;
	}

	public void setZcFlag(String zcFlag) {
		this.zcFlag = zcFlag;
	}

	public String getFrozenRemark() {
		return frozenRemark;
	}

	public void setFrozenRemark(String frozenRemark) {
		this.frozenRemark = frozenRemark;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
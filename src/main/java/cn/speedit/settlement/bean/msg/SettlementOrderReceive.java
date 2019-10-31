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
 * 简介：收货确认的报文BEAN
 * 
 * @author 李珂 2017年10月21日 下午4:40:59
 */
public class SettlementOrderReceive implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_PROV_CODE = "prov_code";
	public static final String FIELD_ORDER_NO = "order_no";
	public static final String FIELD_CONFIRM_USER = "confirm_user";
	public static final String FIELD_ORDER_AMT = "order_amt";
	public static final String FIELD_ORDER_DOC = "order_doc";

	/** 供应商编码 */
	@Size(max = 10, message = "provCode 最大长度不能大于10")
	@NotNull(message = "provCode 不能为空")
	private String provCode;
	/** 订单号 */
	@Size(max = 20, message = "orderNo 最大长度不能大于20")
	@NotNull(message = "orderNo 不能为空")
	private String orderNo;
	/** 确认人 */
	@Size(max = 20, message = "confirmUser 最大长度不能大于20")
	@NotNull(message = "confirmUser 不能为空")
	private String confirmUser;
	/** 确认金额 */
	@NotNull(message = "orderAmt 不能为空")
	private BigDecimal orderAmt;
	/** 订单附件（调用1399接口生成） */
	@Size(max = 4000, message = "orderDoc 最大长度不能大于4000")
	@NotNull(message = "orderDoc 不能为空")
	private String orderDoc;

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

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public String getConfirmUser() {
		return this.confirmUser;
	}

	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}

	public BigDecimal getOrderAmt() {
		return this.orderAmt;
	}

	public void setOrderDoc(String orderDoc) {
		this.orderDoc = orderDoc;
	}

	public String getOrderDoc() {
		return this.orderDoc;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
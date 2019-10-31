/**
 * Copyright (c) 2017, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package cn.speedit.settlement.bean.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 简介：取消订单
 * 
 * @author 李珂 2017年10月21日 下午3:42:04
 */
public class SettlementOrderCancel implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_PROV_CODE = "prov_code";
	public static final String FIELD_ORDER_NO = "order_no";
	public static final String FIELD_CANCEL_USER = "cancel_user";

	/** 供应商编码 */
	@Size(max = 10, message = "provCode 最大长度不能大于10")
	@NotNull(message = "provCode 不能为空")
	private String provCode;
	/** 订单号 */
	@Size(max = 20, message = "orderNo 最大长度不能大于20")
	@NotNull(message = "orderNo 不能为空")
	private String orderNo;
	/** 取消人 */
	@Size(max = 20, message = "cancelUser 最大长度不能大于20")
	private String cancelUser;

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

	public String getCancelUser() {
		return cancelUser;
	}

	public void setCancelUser(String cancelUser) {
		this.cancelUser = cancelUser;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
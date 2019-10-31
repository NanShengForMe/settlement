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


public class SettlementPrjChange implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_PROV_CODE="prov_code";
	public static final String FIELD_ORDER_NO="order_no";
	public static final String FIELD_OLD_UNI_PRJ_CODE="old_uni_prj_code";
	public static final String FIELD_NEW_UNI_PRJ_CODE="new_uni_prj_code";

	/** 供应商编码 */
	@Size(max = 10, message = "provCode 最大长度不能大于10")
	@NotNull(message = "provCode 不能为空")
	private String provCode;	 
	/** 订单号 */
	@Size(max = 20, message = "orderNo 最大长度不能大于20")
	@NotNull(message = "orderNo 不能为空")
	private String orderNo;	 
	/** 原项目代码 */
	@Size(max = 32, message = "oldUniPrjCode 最大长度不能大于32")
	@NotNull(message = "oldUniPrjCode 不能为空")
	private String oldUniPrjCode;	 
	/** 新项目代码 */
	@Size(max = 32, message = "newUniPrjCode 最大长度不能大于32")
	@NotNull(message = "newUniPrjCode 不能为空")
	private String newUniPrjCode;	 

	public void setProvCode(String provCode){
		this.provCode = provCode;
	}
	public String getProvCode(){
		return this.provCode;
	}
	public void setOrderNo(String orderNo){
		this.orderNo = orderNo;
	}
	public String getOrderNo(){
		return this.orderNo;
	}
	public void setOldUniPrjCode(String oldUniPrjCode){
		this.oldUniPrjCode = oldUniPrjCode;
	}
	public String getOldUniPrjCode(){
		return this.oldUniPrjCode;
	}
	public void setNewUniPrjCode(String newUniPrjCode){
		this.newUniPrjCode = newUniPrjCode;
	}
	public String getNewUniPrjCode(){
		return this.newUniPrjCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
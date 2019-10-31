/**
 * Copyright (c) 2017, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package cn.speedit.settlement.bean.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 简介：收货确认-订单明细BEAN
 * 
 * @author 李珂 2017年10月21日 下午4:40:59
 */
public class SettlementOrderReceiveDetail implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_BRAND = "brand";
	public static final String FIELD_ITEM_NO = "item_no";
	public static final String FIELD_SPEC = "spec";
	public static final String FIELD_NUM = "num";
	public static final String FIELD_PRICE = "price";

	/** 品牌 */
	@Size(max = 200, message = "brand 最大长度不能大于200")
	@NotNull(message = "brand 不能为空")
	private String brand;
	/** 货号 */
	@Size(max = 200, message = "itemNo 最大长度不能大于200")
	@NotNull(message = "itemNo 不能为空")
	private String itemNo;
	/** 规格 */
	@Size(max = 200, message = "spec 最大长度不能大于200")
	@NotNull(message = "spec 不能为空")
	private String spec;
	/** 数量 */
	@Max(value = 200, message = "num 最大长度不能大于200")
	@NotNull(message = "num 不能为空")
	private Long num;
	/** 单价 */
	@NotNull(message = "price 不能为空")
	private BigDecimal price;

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemNo() {
		return this.itemNo;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getNum() {
		return this.num;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
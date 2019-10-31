/**
 * Copyright (c) 2017, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package cn.speedit.settlement.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 简介：集中结算.供应商表
 * 
 * @author 李珂 2017年10月25日 上午10:10:16
 */
public class ShoppingProviderMapping implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_PROV_NO = "prov_no";
	public static final String FIELD_PROV_CODE = "prov_code";
	public static final String FIELD_BRANCHCODE = "branchcode";
	public static final String FIELD_PROV_NAME = "prov_name";
	public static final String FIELD_ACNT = "acnt";
	public static final String FIELD_ACCBANK = "accbank";
	public static final String FIELD_E_INVOICE = "e_invoice";
	public static final String FIELD_INPUT_USER = "input_user";

	/** 商城供应商编码 */
	@Size(max = 32, message = "provNo 最大长度不能大于32")
	@NotNull(message = "provNo 不能为空")
	private String provNo;
	/** 供应商编码 */
	@Size(max = 10, message = "provCode 最大长度不能大于10")
	private String provCode;
	/** 联行号 */
	@Size(max = 12, message = "branchcode 最大长度不能大于12")
	private String branchcode;
	/** 供应商名称 */
	@Size(max = 100, message = "provName 最大长度不能大于100")
	private String provName;
	/** 帐号 */
	@Size(max = 40, message = "acnt 最大长度不能大于40")
	private String acnt;
	/** 开户行 */
	@Size(max = 100, message = "accbank 最大长度不能大于100")
	private String accbank;
	/** 是否开具电子发票（Y/N） */
	@Size(max = 1, message = "eInvoice 最大长度不能大于1")
	private String eInvoice;
	/** 登记人 */
	@Size(max = 20, message = "inputUser 最大长度不能大于20")
	private String inputUser;

	public void setProvNo(String provNo) {
		this.provNo = provNo;
	}

	public String getProvNo() {
		return this.provNo;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getProvCode() {
		return this.provCode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getBranchcode() {
		return this.branchcode;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setAcnt(String acnt) {
		this.acnt = acnt;
	}

	public String getAcnt() {
		return this.acnt;
	}

	public void setAccbank(String accbank) {
		this.accbank = accbank;
	}

	public String getAccbank() {
		return this.accbank;
	}

	/**
	 * @return the eInvoice
	 */
	public String getEInvoice() {
		return eInvoice;
	}

	/**
	 * @param eInvoice
	 *            the eInvoice to set
	 */
	public void setEInvoice(String eInvoice) {
		this.eInvoice = eInvoice;
	}

	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}

	public String getInputUser() {
		return this.inputUser;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
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
 * 简介：供应商基本信息<br>
 * 
 * @author 李珂 2017年10月21日 上午10:10:23
 */
public class SettlementProvider implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_PROV_NAME = "prov_name";
	public static final String FIELD_SHORT_NAME = "short_name";
	public static final String FIELD_TAS_NO = "tas_no";
	public static final String FIELD_TAX_ADDR = "tax_addr";
	public static final String FIELD_INVOICE_NAME = "invoice_name";
	public static final String FIELD_ACNT = "acnt";
	public static final String FIELD_ACCBANK = "accbank";
	public static final String FIELD_BRANCHCODE = "branchcode";
	public static final String FIELD_CONTACT_ADDR = "contact_addr";
	public static final String FIELD_CONTACT = "contact";
	public static final String FIELD_TEL = "tel";
	public static final String FIELD_MOBILEPHONE = "mobilephone";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PAYMENT_DAYS = "payment_days";
	public static final String FIELD_DEPOSIT = "deposit";
	public static final String FIELD_E_INVOICE = "e_invoice";
	public static final String FIELD_PROV_DOV = "prov_dov";
	public static final String FIELD_REMARK = "remark";
	public static final String FIELD_INPUT_USER = "input_user";
	public static final String FIELD_PROV_CODE = "prov_code";

	/** 供应商名称 */
	@Size(max = 100, message = "provName 最大长度不能大于100")
	@NotNull(message = "provName 不能为空")
	private String provName;
	/** 供应商简称 */
	@Size(max = 40, message = "shortName 最大长度不能大于40")
	private String shortName;
	/** 税号 */
	@Size(max = 20, message = "tasNo 最大长度不能大于20")
	private String taxNo;
	/** 税务登记地址、开票地址 */
	@Size(max = 100, message = "taxAddr 最大长度不能大于100")
	private String taxAddr;
	/** 开票单位名称 */
	@Size(max = 100, message = "invoiceName 最大长度不能大于100")
	private String invoiceName;
	/** 账号 */
	@Size(max = 40, message = "acnt 最大长度不能大于40")
	@NotNull(message = "acnt 不能为空")
	private String acnt;
	/** 开户行 */
	@Size(max = 100, message = "accbank 最大长度不能大于100")
	@NotNull(message = "accbank 不能为空")
	private String accbank;
	/** 联行号 */
	@Size(max = 12, message = "branchcode 最大长度不能大于12")
	@NotNull(message = "branchcode 不能为空")
	private String branchcode;
	/** 联系地址 */
	@Size(max = 100, message = "contactAddr 最大长度不能大于100")
	private String contactAddr;
	/** 联系人 */
	@Size(max = 40, message = "contact 最大长度不能大于40")
	private String contact;
	/** 联系电话 */
	@Size(max = 40, message = "tel 最大长度不能大于40")
	private String tel;
	/** 手机 */
	@Size(max = 11, message = "mobilephone 最大长度不能大于11")
	private String mobilephone;
	/** Email */
	@Size(max = 40, message = "email 最大长度不能大于40")
	private String email;
	/** 账期 */
	private Long paymentDays;
	/** 押金 */
	private BigDecimal deposit;
	/** 是否开具电子发票（Y/N） */
	@Size(max = 1, message = "eInvoice 最大长度不能大于1")
	private String eInvoice;
	/** 供应商附件（调用1399接口生成） */
	@Size(max = 4000, message = "provDov 最大长度不能大于4000")
	private String provDov;
	/** 备注 */
	@Size(max = 400, message = "remark 最大长度不能大于400")
	private String remark;
	/** 登记人 */
	@Size(max = 20, message = "inputUser 最大长度不能大于20")
	@NotNull(message = "inputUser 不能为空")
	private String inputUser;
	/** 供应商编码 */
	@Size(max = 10, message = "provCode 最大长度不能大于10")
	private String provCode;

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getProvName() {
		return this.provName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getTaxNo() {
		return this.taxNo;
	}

	public void setTaxAddr(String taxAddr) {
		this.taxAddr = taxAddr;
	}

	public String getTaxAddr() {
		return this.taxAddr;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getInvoiceName() {
		return this.invoiceName;
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

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getBranchcode() {
		return this.branchcode;
	}

	public void setContactAddr(String contactAddr) {
		this.contactAddr = contactAddr;
	}

	public String getContactAddr() {
		return this.contactAddr;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return this.contact;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return this.tel;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPaymentDays(Long paymentDays) {
		this.paymentDays = paymentDays;
	}

	public Long getPaymentDays() {
		return this.paymentDays;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getDeposit() {
		return this.deposit;
	}

	public void setEInvoice(String eInvoice) {
		this.eInvoice = eInvoice;
	}

	public String getEInvoice() {
		return this.eInvoice;
	}

	public void setProvDov(String provDov) {
		this.provDov = provDov;
	}

	public String getProvDov() {
		return this.provDov;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}

	public String getInputUser() {
		return this.inputUser;
	}

	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	public String getProvCode() {
		return this.provCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
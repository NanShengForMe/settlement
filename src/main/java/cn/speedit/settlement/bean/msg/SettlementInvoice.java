/**
 * Copyright (c) 2017, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package cn.speedit.settlement.bean.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 简介：发票BEAN
 * 
 * @author 李珂 2017年10月21日 下午5:16:40
 */
public class SettlementInvoice implements Serializable {

	private final static long serialVersionUID = 1L;
	public static final String FIELD_INVOICE_TYPE = "invoice_type";
	public static final String FIELD_INVOICE_CODE = "invoice_code";
	public static final String FIELD_INVOICE_NO = "invoice_no";
	public static final String FIELD_INVOICE_DATE = "invoice_date";
	public static final String FIELD_INVOICE_AMT = "invoice_amt";
	public static final String FIELD_INVOICE_DOC = "invoice_doc";
	public static final String FIELD_E_INVOICE = "e_invoice";

	/** 发票类型（增值税普票/增值税专票） */
	@Size(max = 40, message = "invoiceType 最大长度不能大于40")
	@NotNull(message = "invoiceType 不能为空")
	private String invoiceType;
	/** 发票代码 */
	@Size(max = 20, message = "invoiceCode 最大长度不能大于20")
	@NotNull(message = "invoiceCode 不能为空")
	private String invoiceCode;
	/** 发票号码 */
	@Size(max = 20, message = "invoiceNo 最大长度不能大于20")
	@NotNull(message = "invoiceNo 不能为空")
	private String invoiceNo;
	/** 开票日期（YYYY-MM-DD） */
	@NotNull(message = "invoiceDate 不能为空")
	private Date invoiceDate;
	/** 发票金额 */
	@NotNull(message = "invoiceAmt 不能为空")
	private BigDecimal invoiceAmt;
	/** 发票附件（调用1399接口生成） */
	@Size(max = 4000, message = "invoiceDoc 最大长度不能大于4000")
	@NotNull(message = "invoiceDoc 不能为空")
	private String invoiceDoc;
	/** 是否电子发票（Y/N） */
	@Size(max = 1, message = "eInvoice 最大长度不能大于1")
	@NotNull(message = "eInvoice 不能为空")
	private String eInvoice;

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceCode() {
		return this.invoiceCode;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceAmt(BigDecimal invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public BigDecimal getInvoiceAmt() {
		return this.invoiceAmt;
	}

	public void setInvoiceDoc(String invoiceDoc) {
		this.invoiceDoc = invoiceDoc;
	}

	public String getInvoiceDoc() {
		return this.invoiceDoc;
	}

	public void setEInvoice(String eInvoice) {
		this.eInvoice = eInvoice;
	}

	public String getEInvoice() {
		return this.eInvoice;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
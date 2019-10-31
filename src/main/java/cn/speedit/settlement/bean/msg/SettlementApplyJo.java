package cn.speedit.settlement.bean.msg;

import java.math.BigDecimal;
import java.util.List;

/**
 * 简介：结算申请BEAN JO<br>
 * 详细说明：
 * <ul>
 * <li>List&lt;String&gt; orderNoList : 订单号列表</li>
 * <li>List&lt;PaymentInvoice&gt; invoiceList : 发票列表</li>
 * </ul>
 * 
 * @author 李珂 2017年10月21日 下午5:17:42
 */
public class SettlementApplyJo {

	private String provCode; // 供应商编码
	private String applyUser; // 结算申请人
	private String remark; // 备注
	private BigDecimal applyAmt; // 申请结算金额

	private List<String> orderNoList; // 订单号列表
	private List<SettlementInvoice> invoiceList; // 发票列表

	/**
	 * @return the provCode
	 */
	public String getProvCode() {
		return provCode;
	}

	/**
	 * @param provCode
	 *            the provCode to set
	 */
	public void setProvCode(String provCode) {
		this.provCode = provCode;
	}

	/**
	 * @return the applyUser
	 */
	public String getApplyUser() {
		return applyUser;
	}

	/**
	 * @param applyUser
	 *            the applyUser to set
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	/**
	 * @return the applyAmt
	 */
	public BigDecimal getApplyAmt() {
		return applyAmt;
	}

	/**
	 * @param applyAmt
	 *            the applyAmt to set
	 */
	public void setApplyAmt(BigDecimal applyAmt) {
		this.applyAmt = applyAmt;
	}

	/**
	 * @return the orderNoList
	 */
	public List<String> getOrderNoList() {
		return orderNoList;
	}

	/**
	 * @param orderNoList
	 *            the orderNoList to set
	 */
	public void setOrderNoList(List<String> orderNoList) {
		this.orderNoList = orderNoList;
	}

	/**
	 * @return the invoiceList
	 */
	public List<SettlementInvoice> getInvoiceList() {
		return invoiceList;
	}

	/**
	 * @param invoiceList
	 *            the invoiceList to set
	 */
	public void setInvoiceList(List<SettlementInvoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}

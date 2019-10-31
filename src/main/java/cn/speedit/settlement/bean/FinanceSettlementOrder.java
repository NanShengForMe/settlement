package cn.speedit.settlement.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 财务结算订单
 * @author liaogm
 *
 */
/**
 * @author liaogm
 *
 */
@SuppressWarnings("serial")
public class FinanceSettlementOrder implements Serializable {
	
	private String orderNo;
	
	private String syncId;
	
	private String acceptanceBpmNo;
	
	private String outlayCardNo;
	
	private String outlayCardName;
	
	private String financeOutlaySubject;
	
	private String financeOutlaySubjectName;
	
	private BigDecimal amount;

	/**
	 * @return the orderId
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the syncId
	 */
	public String getSyncId() {
		return syncId;
	}

	/**
	 * @param syncId the syncId to set
	 */
	public void setSyncId(String syncId) {
		this.syncId = syncId;
	}

	/**
	 * @return the acceptanceBpmNo
	 */
	public String getAcceptanceBpmNo() {
		return acceptanceBpmNo;
	}

	/**
	 * @param acceptanceBpmNo the acceptanceBpmNo to set
	 */
	public void setAcceptanceBpmNo(String acceptanceBpmNo) {
		this.acceptanceBpmNo = acceptanceBpmNo;
	}

	/**
	 * @return the outlayCardNo
	 */
	public String getOutlayCardNo() {
		return outlayCardNo;
	}

	/**
	 * @param outlayCardNo the outlayCardNo to set
	 */
	public void setOutlayCardNo(String outlayCardNo) {
		this.outlayCardNo = outlayCardNo;
	}

	/**
	 * @return the outlayCardName
	 */
	public String getOutlayCardName() {
		return outlayCardName;
	}

	/**
	 * @param outlayCardName the outlayCardName to set
	 */
	public void setOutlayCardName(String outlayCardName) {
		this.outlayCardName = outlayCardName;
	}

	/**
	 * @return the financeOutlaySubject
	 */
	public String getFinanceOutlaySubject() {
		return financeOutlaySubject;
	}

	/**
	 * @param financeOutlaySubject the financeOutlaySubject to set
	 */
	public void setFinanceOutlaySubject(String financeOutlaySubject) {
		this.financeOutlaySubject = financeOutlaySubject;
	}

	/**
	 * @return the financeOutlaySubjectName
	 */
	public String getFinanceOutlaySubjectName() {
		return financeOutlaySubjectName;
	}

	/**
	 * @param financeOutlaySubjectName the financeOutlaySubjectName to set
	 */
	public void setFinanceOutlaySubjectName(String financeOutlaySubjectName) {
		this.financeOutlaySubjectName = financeOutlaySubjectName;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

}

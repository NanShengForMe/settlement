package cn.speedit.settlement.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 结算单
 * @author liaogm
 *
 */
@SuppressWarnings("serial")
public class Settlement implements Serializable {
	
	private String settlementCode;
	  
	private Date settlementDate;
	
	private String providerCode; 
	
	private String providerName;   
	  
	private BigDecimal amount;          
	  
	private BigDecimal fixedAmount;    
	  
	private BigDecimal materialAmount; 
	  
	private Float state;           
	  
	private String op;              
	  
	private Long applyNo;   
	  
	private Long reqNo;         
	
	private String pzUniNo;       
	  
	private String payStatus;      
	  
	private Date payDate;
	
	private String subject;
	
	

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the settlementCode
	 */
	public String getSettlementCode() {
		return settlementCode;
	}

	/**
	 * @param settlementCode the settlementCode to set
	 */
	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}

	/**
	 * @return the settlementDate
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	/**
	 * @return the providerCode
	 */
	public String getProviderCode() {
		return providerCode;
	}

	/**
	 * @param providerCode the providerCode to set
	 */
	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	/**
	 * @return the providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * @param providerName the providerName to set
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
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

	/**
	 * @return the fixedAmount
	 */
	public BigDecimal getFixedAmount() {
		return fixedAmount;
	}

	/**
	 * @param fixedAmount the fixedAmount to set
	 */
	public void setFixedAmount(BigDecimal fixedAmount) {
		this.fixedAmount = fixedAmount;
	}

	/**
	 * @return the materialAmount
	 */
	public BigDecimal getMaterialAmount() {
		return materialAmount;
	}

	/**
	 * @param materialAmount the materialAmount to set
	 */
	public void setMaterialAmount(BigDecimal materialAmount) {
		this.materialAmount = materialAmount;
	}

	/**
	 * @return the state
	 */
	public Float getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(Float state) {
		this.state = state;
	}

	/**
	 * @return the op
	 */
	public String getOp() {
		return op;
	}

	/**
	 * @param op the op to set
	 */
	public void setOp(String op) {
		this.op = op;
	}

	/**
	 * @return the applyNo
	 */
	public Long getApplyNo() {
		return applyNo;
	}

	/**
	 * @param applyNo the applyNo to set
	 */
	public void setApplyNo(Long applyNo) {
		this.applyNo = applyNo;
	}

	/**
	 * @return the reqNo
	 */
	public Long getReqNo() {
		return reqNo;
	}

	/**
	 * @param reqNo the reqNo to set
	 */
	public void setReqNo(Long reqNo) {
		this.reqNo = reqNo;
	}

	/**
	 * @return the pzUniNo
	 */
	public String getPzUniNo() {
		return pzUniNo;
	}

	/**
	 * @param pzUniNo the pzUniNo to set
	 */
	public void setPzUniNo(String pzUniNo) {
		this.pzUniNo = pzUniNo;
	}

	/**
	 * @return the payStatus
	 */
	public String getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @return the payDate
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
}

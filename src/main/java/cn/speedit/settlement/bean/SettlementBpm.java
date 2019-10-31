package cn.speedit.settlement.bean;

import java.io.Serializable;

public class SettlementBpm implements Serializable {
	
	private String settlementCode;
	
	private String bpmNo;

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
	 * @return the bpmNo
	 */
	public String getBpmNo() {
		return bpmNo;
	}

	/**
	 * @param bpmNo the bpmNo to set
	 */
	public void setBpmNo(String bpmNo) {
		this.bpmNo = bpmNo;
	}
	
}

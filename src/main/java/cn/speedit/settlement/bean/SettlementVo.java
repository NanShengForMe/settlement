package cn.speedit.settlement.bean;

/**
 * 简介：已汇总结算Vo
 * 
 * @author 李珂 2017年10月27日 下午1:05:56
 */
public class SettlementVo extends Settlement {
	private static final long serialVersionUID = 1L;

	private Long bpmNum; // 订单数量
	private String stateName; // 结算状态名称

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName
	 *            the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return the bpmNum
	 */
	public Long getBpmNum() {
		return bpmNum;
	}

	/**
	 * @param bpmNum
	 *            the bpmNum to set
	 */
	public void setBpmNum(Long bpmNum) {
		this.bpmNum = bpmNum;
	}

}

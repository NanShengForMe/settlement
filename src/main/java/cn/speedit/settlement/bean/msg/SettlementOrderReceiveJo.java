package cn.speedit.settlement.bean.msg;

import java.util.List;

/**
 * 简介：收货确认BEAN JO<br>
 * 详细说明：
 * <ul>
 * <li>PaymentOrderReceive orderReceive : 订单基本信息</li>
 * <li>List&lt;PaymentOrderReceiveDetail&gt; orderReceiveDetailList : 订单明细</li>
 * </ul>
 * 
 * @author 李珂 2017年10月21日 下午4:51:44
 */
public class SettlementOrderReceiveJo {

	private SettlementOrderReceive orderReceive;
	private List<SettlementOrderReceiveDetail> orderReceiveDetailList;

	/**
	 * @return the orderReceive
	 */
	public SettlementOrderReceive getOrderReceive() {
		return orderReceive;
	}

	/**
	 * @param orderReceive
	 *            the orderReceive to set
	 */
	public void setOrderReceive(SettlementOrderReceive orderReceive) {
		this.orderReceive = orderReceive;
	}

	/**
	 * @return the orderReceiveDetailList
	 */
	public List<SettlementOrderReceiveDetail> getOrderReceiveDetailList() {
		return orderReceiveDetailList;
	}

	/**
	 * @param orderReceiveDetailList
	 *            the orderReceiveDetailList to set
	 */
	public void setOrderReceiveDetailList(List<SettlementOrderReceiveDetail> orderReceiveDetailList) {
		this.orderReceiveDetailList = orderReceiveDetailList;
	}

}

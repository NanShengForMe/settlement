package cn.speedit.settlement.bean;

public class SettlementBpmVo extends SettlementBpm {
	
	private static final long serialVersionUID = 1L;

	private String assetsTypeName;
	
	private String syncId;
	
	private String acceptanceId;
	

	/**
	 * @return the acceptanceId
	 */
	public String getAcceptanceId() {
		return acceptanceId;
	}

	/**
	 * @param acceptanceId the acceptanceId to set
	 */
	public void setAcceptanceId(String acceptanceId) {
		this.acceptanceId = acceptanceId;
	}

	/**
	 * @return the assetsTypeName
	 */
	public String getAssetsTypeName() {
		return assetsTypeName;
	}

	/**
	 * @param assetsTypeName the assetsTypeName to set
	 */
	public void setAssetsTypeName(String assetsTypeName) {
		this.assetsTypeName = assetsTypeName;
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

}

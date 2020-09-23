package com.sxhalo.lmb.domain;

public class ForwardShareRecord extends ForwardShareRecordKey {
	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 0拉煤宝 1快煤宝 2网页
	 */
	private Integer shareType;

	/**
	 * 分享所得佣金(分)
	 */
	private Integer shareBrokerage;

	/**
	 * 是否领取奖励 0未领取 1领取
	 */
	private Integer receiveBrokerage;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShareType() {
		return shareType;
	}

	public void setShareType(Integer shareType) {
		this.shareType = shareType;
	}

	public Integer getShareBrokerage() {
		return shareBrokerage;
	}

	public void setShareBrokerage(Integer shareBrokerage) {
		this.shareBrokerage = shareBrokerage;
	}

	public Integer getReceiveBrokerage() {
		return receiveBrokerage;
	}

	public void setReceiveBrokerage(Integer receiveBrokerage) {
		this.receiveBrokerage = receiveBrokerage;
	}
}
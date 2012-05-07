package com.cleeng.api.domain;

import java.io.Serializable;

public class AccessStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean accessGranted;
	private Boolean voted;
	private String socialCommissionUrl;

	public Boolean getAccessGranted() {
		return accessGranted;
	}

	public void setAccessGranted(Boolean accessGranted) {
		this.accessGranted = accessGranted;
	}

	public Boolean getVoted() {
		return voted;
	}

	public void setVoted(Boolean voted) {
		this.voted = voted;
	}

	public String getSocialCommissionUrl() {
		return socialCommissionUrl;
	}

	public void setSocialCommissionUrl(String socialCommissionUrl) {
		this.socialCommissionUrl = socialCommissionUrl;
	}

}

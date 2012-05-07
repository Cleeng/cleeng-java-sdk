package com.cleeng.api.domain;

import java.io.Serializable;

public class ItemOffer implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String url;
	private String pageTitle;
	private double price;
	private int publisherId;
	private String currency;
	private String currencySymbol;
	private String description;
	private Boolean socialCommissionEnabled;
	private double socialCommissionRate;
	private String shortUrl;
	private String type;
	private Boolean hasLayerDates;
	private String layerStartDate;
	private String layerEndDate;
	private int myId;
	private String publisherName;
	private int averageRating;
	private String createdAt;
	private String updatedAt;
	private String myData;

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getMyData() {
		return myData;
	}

	public void setMyData(String myData) {
		this.myData = myData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getSocialCommissionEnabled() {
		return socialCommissionEnabled;
	}

	public void setSocialCommissionEnabled(Boolean socialCommissionEnabled) {
		this.socialCommissionEnabled = socialCommissionEnabled;
	}

	public double getSocialCommissionRate() {
		return socialCommissionRate;
	}

	public void setSocialCommissionRate(double socialCommissionRate) {
		this.socialCommissionRate = socialCommissionRate;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getHasLayerDates() {
		return hasLayerDates;
	}

	public void setHasLayerDates(Boolean hasLayerDates) {
		this.hasLayerDates = hasLayerDates;
	}

	public String getLayerStartDate() {
		return layerStartDate;
	}

	public void setLayerStartDate(String layerStartDate) {
		this.layerStartDate = layerStartDate;
	}

	public String getLayerEndDate() {
		return layerEndDate;
	}

	public void setLayerEndDate(String layerEndDate) {
		this.layerEndDate = layerEndDate;
	}

	public int getMyId() {
		return myId;
	}

	public void setMyId(int myId) {
		this.myId = myId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

}

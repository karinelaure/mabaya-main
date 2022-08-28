package com.mabaya.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDto {
	
	private Long serialNumber;
	private BigDecimal price;
	private String title;
	private String category;
	private List<Long> campaignIds;
	
	
	public ProductDto() {
	
	}
	

	public ProductDto(Long serialNumber, BigDecimal price, String title, String category, List<Long> campaignIds) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.title = title;
		this.category = category;
		this.campaignIds = campaignIds;
	}
	
	public Long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public List<Long> getCampaignIds() {
		return campaignIds;
	}

	public void setCampaignIds(List<Long> campaignIds) {
		this.campaignIds = campaignIds;
	}
	
	
	
	

}

package com.mabaya.dto;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CampaignDto {
	@NotBlank
	private String name;
	@NotNull
	private BigDecimal bid ;
	@NotEmpty
	private Set<Long> prodList;
	@NotBlank
	private String startDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getBid() {
		return bid;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	public Set<Long> getProdList() {
		return prodList;
	}
	public void setProdList(Set<Long> prodList) {
		this.prodList = prodList;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


}

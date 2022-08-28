package com.mabaya.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3032495464066932051L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serialNumber;
	private BigDecimal price;
	private String title;
	private String category;
	
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	private Set<Campaign> campaigns = new HashSet();
	
	public Product() {
		
	}

	public Product(Long id, BigDecimal price, String title, Long serialNumber, String category, Set<Campaign> campaigns) {
		this.price = price;
		this.title = title;
		this.serialNumber = serialNumber;
		this.category = category;
		this.campaigns = campaigns;
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

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}


	public Set<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(Set<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [serialNumber=" + serialNumber + ", price=" + price + ", title=" + title + ", category="
				+ category  + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, price, serialNumber, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return  Objects.equals(category, other.category)
				&& Objects.equals(price, other.price) && Objects.equals(serialNumber, other.serialNumber)
				&& Objects.equals(title, other.title);
	}
	
	

}
	
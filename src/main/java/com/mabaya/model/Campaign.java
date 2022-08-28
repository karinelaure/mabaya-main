package com.mabaya.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Campaign implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7547012797375965386L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal bid;
	private LocalDateTime startDate;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_serialNumber")
	private List<Product> products = new ArrayList<>();
	
	public Campaign() {
	}

	public Campaign(Long id, String name, BigDecimal bid, LocalDateTime startDate, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.bid = bid;
		this.startDate = startDate;
		this.products = products;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", bid=" + bid + ", startDate=" + startDate + ", products="
				+ products + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bid, id, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campaign other = (Campaign) obj;
		return Objects.equals(bid, other.bid) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
			 && startDate == other.startDate;
	}
	
	

}

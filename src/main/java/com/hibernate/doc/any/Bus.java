package com.hibernate.doc.any;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bus implements Vehicle {

	@Id
	@GeneratedValue
	private Long id;
	private Long buyingPrice;
	private String modelNumber;
	private Long engineCapacity;
	private int seatCount;
	private boolean acAvailable;

	public Bus(final Long buyingPrice, final String modelNumber, final Long engineCapacity, final int seatCount, final boolean acAvailable) {
		this.buyingPrice = buyingPrice;
		this.modelNumber = modelNumber;
		this.engineCapacity = engineCapacity;
		this.seatCount = seatCount;
		this.acAvailable = acAvailable;
	}

	@Override
	public Long getBuyingPrice() {
		return this.buyingPrice;
	}
	
	public void setBuyingPrice(Long buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	@Override
	public String getModelNumber() {
		return this.modelNumber;
	}
	
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	@Override
	public Long getEngineCapacity() {
		return this.engineCapacity;
	}
	
	public void setEngineCapacity(Long engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public boolean isAcAvailable() {
		return acAvailable;
	}

	public void setAcAvailable(boolean acAvailable) {
		this.acAvailable = acAvailable;
	}

}

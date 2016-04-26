package com.hibernate.doc.any;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Truck implements Vehicle {

	@Id
	@GeneratedValue
	private Long id;
	private Long buyingPrice;
	private String modelNumber;
	private Long engineCapacity;
	private Long trunkVolumeCapacity;

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

	public Long getTrunkVolumeCapacity() {
		return trunkVolumeCapacity;
	}

	public void setTrunkVolumeCapacity(Long trunkVolumeCapacity) {
		this.trunkVolumeCapacity = trunkVolumeCapacity;
	}

}

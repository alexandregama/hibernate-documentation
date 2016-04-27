package com.hibernate.doc.any;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.MetaValue;

@Entity
public class SaleTransaction {

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date saleDate;
	
	private Long salePrice;
	
	@Any(metaColumn = @Column(name = "vehicleType"))
	@AnyMetaDef(
			idType = "long", metaType = "string",
			metaValues = {
					@MetaValue(targetEntity = Bus.class, value = "bus"),
					@MetaValue(targetEntity = Truck.class, value = "truck")
			}
	)
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;
	
	public SaleTransaction(final Date saleDate, Long salePrice, Vehicle vehicle) {
		this.saleDate = saleDate;
		this.salePrice = salePrice;
		this.vehicle = vehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Long getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Long salePrice) {
		this.salePrice = salePrice;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}

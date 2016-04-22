package com.hibernate.doc.shipping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Shippings")
@Entity
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "weight")
	private Long weight;

	@Column(name = "height")
	private Long height;

	@Column(name = "width")
	private Long width;
	
	public Shipping(Long weight, Long height, Long width) {
		this.weight = weight;
		this.height = height;
		this.width = width;
	}

	public Long getId() {
		return id;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

}

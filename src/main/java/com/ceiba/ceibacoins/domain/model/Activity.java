package com.ceiba.ceibacoins.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * 
 * @since 06/02/2020
 * @author sergio.portilla
 */
@Entity
@Table(name = "actividad")
public class Activity {

	/**	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idActivity;
	
	/**	 */
	@NotEmpty
	private String name;
	/**	 */
	@NotEmpty
	private Double price;
	
	/**
	 * 
	 * @param name
	 * @param price
	 */
	public Activity(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public Activity() {
	}
	
	public Long getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}

package com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Entidad de las actividades que tienen valor en Ceiba
 *
 * @since 06/02/2020
 * @author sergio.portilla
 */
@Entity
@Table(name = "actividad")
public class ActivityDTO {

	/**	Id de la Actividad */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idActivity;
	
	/**	Nombre de la actividad */
	@NotEmpty
	private String name;

	/**	Precio indicado para la actividad */
	@NotEmpty
	private Double price;
	
	/**
	 * Constructor de acrtividad
	 *
	 * @param name Nombre de la actividad
	 * @param price Precio indicado para la actividad
	 */
	public ActivityDTO(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public ActivityDTO() {
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

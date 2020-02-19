package com.ceiba.ceibacoins.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Entidad de las actividades que tienen valor en Ceiba
 *
 * @since 06/02/2020
 * @author sergio.portilla
 */
public class Activity {

    /**
     * Id de la Actividad
     */
    private Long idActivity;

    /**
     * Nombre de la actividad
     */
    private String name;

    /**
     * Precio indicado para la actividad
     */
    private Double price;

    /**
     * Constructor de acrtividad
     *
     * @param name  Nombre de la actividad
     * @param price Precio indicado para la actividad
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

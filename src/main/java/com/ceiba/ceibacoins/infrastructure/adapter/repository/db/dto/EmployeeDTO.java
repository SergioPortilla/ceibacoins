package com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad de los empleados registrados de Ceiba
 *
 * @since 06/02/2020
 * @author sergio.portilla
 */
@Entity
@Table(name = "empleado")
public class EmployeeDTO {
	
	/** Numero unico de identificacion personal*/
	@Id
	private Long nuip;

	/** Nombre del empleado */
	@NotEmpty
    private String employeeName;

	/**	Apellido del empleado */
	@NotEmpty
    private String employeeLastName;

	/**	Dia de nacimiento */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

	/**	Dia de ingreso a Ceiba */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entry;

	/**	Cantidad de ceibaCoins obtenidos por el empleado */
    private Double ceibaCoins;

    /** Estado del empleado, si se encuentra en la empresa o no */
    private Boolean state;
    
    /**
     * Constructor del empleado
	 *
     * @param nuip Numero unico de identificacion personal
     * @param employeeName Nombre del empleado
     * @param employeeLastName Apellido del empleado
     * @param birthday Dia de nacimiento
     * @param entry Dia de ingreso a Ceiba
     * @param ceibaCoins Cantidad de ceibaCoins obtenidos por el empleado
     * @param state Estado del empleado, si se encuentra en la empresa o no
     */
    public EmployeeDTO(Long nuip, @NotEmpty String employeeName, @NotEmpty String employeeLastName, Date birthday, Date entry,
					   Double ceibaCoins, Boolean state) {
		super();
		this.nuip = nuip;
		this.employeeName = employeeName;
		this.employeeLastName = employeeLastName;
		this.birthday = birthday;
		this.entry = entry;
		this.ceibaCoins = ceibaCoins;
		this.state = state;
	}
    
	public EmployeeDTO() {
	}

	public Long getNuip() {
        return nuip;
    }

    public void setNuip(Long nuip) {
        this.nuip = nuip;
    }

    public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Double getCeibaCoins() {
        return ceibaCoins;
    }

    public void setCeibaCoins(Double ceibaCoins) {
        this.ceibaCoins = ceibaCoins;
    }

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
}

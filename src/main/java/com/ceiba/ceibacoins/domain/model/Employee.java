package com.ceiba.ceibacoins.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @since 06/02/2020
 * @author sergio.portilla
 *
 */
@Entity
@Table(name = "empleado")
public class Employee {
	
	/** Numero unico de identificacion personal*/
	@Id
	private Long nuip;

	/**  */
	@NotEmpty
    private String employeeName;
	/**	 */
	@NotEmpty
    private String employeeLastName;

	/**	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
	/**	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entry;

	/**	 */
    private Double ceibaCoins;
    /**  */
    private Boolean state;
    
    /**
     * 
     * @param nuip
     * @param employeeName
     * @param employeeLastName
     * @param birthday
     * @param entry
     * @param ceibaCoins
     * @param state
     */
    public Employee(Long nuip, @NotEmpty String employeeName, @NotEmpty String employeeLastName, Date birthday, Date entry,
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
    
	public Employee() {
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

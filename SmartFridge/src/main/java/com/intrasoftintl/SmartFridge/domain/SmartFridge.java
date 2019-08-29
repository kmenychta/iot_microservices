package com.intrasoftintl.SmartFridge.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intrasoftintl.iot.entity.Device;


@Entity
@Table(name="SmartFridge2")
public class SmartFridge {

	@Id
	@Column(name = "deviceid")
	@JsonIgnore
	protected int id;
	
	@Column(name="freezer_temperature")
	private int freezertemp;
	
	@Column(name="fridge_temperature")
	private int fridgetemp;


	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinColumn(name="deviceid", insertable = true, updatable = true, nullable=false)
	private Device device;
	 

	public SmartFridge(int id, int freezertemp,int fridgetemp,Device device) {
		this.id = id;
		this.freezertemp=freezertemp;
		this.fridgetemp=fridgetemp;
		this.device=device;
	}

	public SmartFridge() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getFreezertemp() {
		return freezertemp;
	}

	public void setFreezertemp(int freezertemp) {
		this.freezertemp = freezertemp;
	}

	public int getFridgetemp() {
		return fridgetemp;
	}

	public void setFridgetemp(int fridgetemp) {
		this.fridgetemp = fridgetemp;
	}

	public Device getDevice() {
		return device;
	}


	public void setDevice(Device device) {
		this.device = device;
	}


	@Override
	public String toString() {
		return "SmartFridge [freezertemp=" + freezertemp + ", fridgetemp=" + fridgetemp + "]";
	}
	
	
}

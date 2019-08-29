package com.intrasoftintl.CoffeeMaker.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intrasoftintl.iot.entity.Device;

@Entity
@Table(name = "CoffeeMaker1")
public class CoffeeMaker {

	@Id
	@JsonIgnore
	@Column(name = "deviceid")
	protected int id;

	@Column(name = "temperature")
	private int temperature;

	@Enumerated(EnumType.STRING)
	@Column(name = "mode")
	private CoffeeMode mode;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinColumn(name="deviceid", insertable = true, updatable = true, nullable=false)
	private Device device;
	 

	public CoffeeMaker() {

	}

	public CoffeeMaker(int id, int temperature, CoffeeMode mode,Device device) {
		this.id = id;
		this.temperature = temperature;
		this.mode = mode;
		this.device=device;

	}

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void increaseTemperature() {
		if (temperature < 100)
			temperature++;

	}

	public void decreaseTemperature() {
		if (temperature >= 0)
			temperature--;

	}

	public void setMode(String modename) {
		switch (modename.toLowerCase()) {
		case "coffee":
			mode = CoffeeMode.COFFEE;
			break;
		}

	}


	public int getTemperature() {
		return temperature;
	}

	public CoffeeMode getMode() {
		return mode;
	}


	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String toString() {
		return "ACUnit [ temperature=" + temperature + ", mode=" + mode  + "]";
	}

}

package com.intrasoftintl.ACUnit.domain;

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
@Table(name = "ACUnit4")
public class ACUnit {

	@Id
	@JsonIgnore
	@Column(name = "deviceid")
	protected int id;

	@Column(name = "temperature")
	private int temperature;

	@Enumerated(EnumType.STRING)
	@Column(name = "mode")
	private Mode mode;

	@Enumerated(EnumType.STRING)
	@Column(name = "fanspeed")
	private FanSpeed fanspeed;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinColumn(name="deviceid", insertable = true, updatable = true, nullable=false)
	private Device device;
	 

	public ACUnit() {

	}

	public ACUnit(int id, int temperature, Mode mode, FanSpeed fanspeed,Device device) {
		this.id = id;
		this.temperature = temperature;
		this.mode = mode;
		this.fanspeed = fanspeed;
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
		if (temperature < 37)
			temperature++;

	}

	public void decreaseTemperature() {
		if (temperature >= 0)
			temperature--;

	}

	public void setMode(String modename) {
		switch (modename.toLowerCase()) {
		case "auto":
			mode = Mode.AUTO;
			break;
		case "cool":
			mode = Mode.COOL;
			break;
		case "dry":
			mode = Mode.DRY;
			break;
		case "fan":
			mode = Mode.FAN;
			break;
		case "heat":
			mode = Mode.HEAT;
			break;
		}

	}

	public void setFanSpeed(String fanspeedname) {
		switch (fanspeedname.toLowerCase()) {
		case "low":
			fanspeed = FanSpeed.LOW;
			break;
		case "medium":
			fanspeed = FanSpeed.MEDIUM;
			break;
		case "high":
			fanspeed = FanSpeed.HIGH;
			break;
		}
	}

	public int getTemperature() {
		return temperature;
	}

	public Mode getMode() {
		return mode;
	}

	public FanSpeed getFanSpeed() {
		return fanspeed;
	}
	

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String toString() {
		return "ACUnit [ temperature=" + temperature + ", mode=" + mode + ", fanspeed="
				+ fanspeed + "]";
	}

}

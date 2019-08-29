package com.intrasoftintl.Lock.domain;

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
@Table(name="Lock3")
public class Lock {

	@Id
	@Column(name = "deviceid")
	@JsonIgnore
	protected int id;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="islocked")
	private IsLocked isLocked;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinColumn(name="deviceid", insertable = true, updatable = true, nullable=false)
	private Device device;
	 

	public Lock(int id, IsLocked isLocked,Device device) {
		this.id = id;
		this.isLocked = isLocked;
		this.device=device;
	}


	public Lock() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public IsLocked getIsLocked() {
		return isLocked;
	}


	public void setIsLocked(IsLocked isLocked) {
		this.isLocked = isLocked;
	}


	public Device getDevice() {
		return device;
	}


	public void setDevice(Device device) {
		this.device = device;
	}


	@Override
	public String toString() {
		return "Lock [isLocked=" + isLocked + "]";
	}
	
	
}

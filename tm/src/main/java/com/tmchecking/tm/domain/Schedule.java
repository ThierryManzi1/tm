package com.tmchecking.tm.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Long id;
	private LocalDate date;
	private LocalTime time;
	private String address;
	private boolean isBooked;
	private boolean isComplete;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

}

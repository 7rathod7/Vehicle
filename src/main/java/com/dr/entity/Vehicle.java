package com.dr.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String model;
	private String year;
	private String manufacturer;
	
	@Enumerated
	private VehicleType type;
	
	private enum VehicleType {
		SEDAN, SUV, HATCHBACK
	}
}

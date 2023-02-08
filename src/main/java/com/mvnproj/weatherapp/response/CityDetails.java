package com.mvnproj.weatherapp.response;

import java.time.LocalDate;

public class CityDetails {

	private long id;

	private String name;

	private String region;

	private String country;

	private double lat;

	private double lon;

	private String tz_id;

	private double temp_c;

	private double temp_f;

	private String createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getTz_id() {
		return tz_id;
	}

	public void setTz_id(String tz_id) {
		this.tz_id = tz_id;
	}

	public double getTemp_c() {
		return temp_c;
	}

	public void setTemp_c(double temp_c) {
		this.temp_c = temp_c;
	}

	public double getTemp_f() {
		return temp_f;
	}

	public void setTemp_f(double temp_f) {
		this.temp_f = temp_f;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}

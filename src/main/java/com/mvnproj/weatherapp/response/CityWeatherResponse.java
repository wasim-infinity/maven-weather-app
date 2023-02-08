package com.mvnproj.weatherapp.response;
import java.time.LocalDateTime;

public class CityWeatherResponse {

	public CityWeatherResponse() {
	}

	public CityLocation getLocation() {
		return location;
	}

	public void setLocation(CityLocation location) {
		this.location = location;
	}

	public CurrentTemp getCurrent() {
		return current;
	}

	public void setCurrent(CurrentTemp current) {
		this.current = current;
	}

	CityLocation location;

	CurrentTemp current;

	public static class CityLocation {
		String name;
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
		public Double getLat() {
			return lat;
		}
		public void setLat(Double lat) {
			this.lat = lat;
		}
		public Double getLon() {
			return lon;
		}
		public void setLon(Double lon) {
			this.lon = lon;
		}
		public String getTz_id() {
			return tz_id;
		}
		public void setTz_id(String tz_id) {
			this.tz_id = tz_id;
		}
		public String getLocaltime_epoch() {
			return localtime_epoch;
		}
		public void setLocaltime_epoch(String localtime_epoch) {
			this.localtime_epoch = localtime_epoch;
		}
		public LocalDateTime getLocaltime() {
			return localtime;
		}
		public void setLocaltime(LocalDateTime localtime) {
			this.localtime = localtime;
		}
		String region;
		String country;
		Double lat;
		Double lon;
		String tz_id;
		String localtime_epoch;
		LocalDateTime localtime;
	}

	public static class CurrentTemp {
		String temp_c;
		public String getTemp_c() {
			return temp_c;
		}
		public void setTemp_c(String temp_c) {
			this.temp_c = temp_c;
		}
		public String getTemp_f() {
			return temp_f;
		}
		public void setTemp_f(String temp_f) {
			this.temp_f = temp_f;
		}
		String temp_f;
	}

}

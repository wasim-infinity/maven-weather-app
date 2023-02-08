package com.mvnproj.weatherapp.util;

public enum WeatherAppAPIs {

	BASE_URL("Base Url", "http://localhost:8082/"),
	GET_CITY_WEATHER_DETAILS("Get city weather details", "api/get-city-weather-dtls"),
	GET_ALL_CITY_WEATHER_DETAILS("Get all city details", "api/get-all-city-dtls");

	private final String key;

	private final String value;

	WeatherAppAPIs(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}
}

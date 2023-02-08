package com.mvnproj.weatherapp.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mvnproj.weatherapp.response.CityWeatherResponse;

public class CommonUtils {

	public static Object jsonStringToObj(String jsonString, Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		CityWeatherResponse cityWeatherResponse = null;
		try {
			cityWeatherResponse = objectMapper.readValue(jsonString, CityWeatherResponse.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		return cityWeatherResponse;
	}

	public static JsonNode getParamJsonValue(String jsonData, String data) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		JsonNode val = null;
		try {
			node = mapper.readTree(jsonData);
			val = node.findValue(data);
			return val;
		} catch (JsonProcessingException e) {
		} catch (Exception ex) {
		}
		return val;
	}
}

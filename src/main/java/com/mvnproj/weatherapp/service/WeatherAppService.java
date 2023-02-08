package com.mvnproj.weatherapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvnproj.weatherapp.response.CityDetails;
import com.mvnproj.weatherapp.response.CityWeatherResponse;
import com.mvnproj.weatherapp.util.CommonUtils;
import com.mvnproj.weatherapp.util.WeatherAppAPIs;

@Service
public class WeatherAppService {

	@Autowired
	private SoapService soapService;

	@Autowired
	private GenerateReportService generateReportService;

	public void getCityWeatherDetails(String city, String weatherDate) {
		String url = null;
		String response = null;
		if ("report".contentEquals(city)) {
			url = WeatherAppAPIs.BASE_URL.getValue() + WeatherAppAPIs.GET_ALL_CITY_WEATHER_DETAILS.getValue();
			response = soapService.soapServiceCall(url);
			List<CityDetails> cityDetailsList = (List<CityDetails>) this.processJsonArray(response, true);
			generateReportService.generateReport(cityDetailsList);
			System.out.println("Successfully excel file created !!!");
			return;

		} else {
			url = WeatherAppAPIs.BASE_URL.getValue() + WeatherAppAPIs.GET_CITY_WEATHER_DETAILS.getValue() + "?city="
					+ city + "&weatherDate=" + weatherDate;
			response = soapService.soapServiceCall(url);
			List<CityWeatherResponse> cityWeatherResponseList = (List<CityWeatherResponse>) this.processJsonArray(response, false);
			this.displayResult(cityWeatherResponseList);

		}
	}

	public void displayResult(List<CityWeatherResponse> cityWeatherResponseList) {
		if (Objects.isNull(cityWeatherResponseList) || "null".equals(cityWeatherResponseList.get(0).getLocation().getName())) {
			System.out.println("Please provide a valid city name");
			return;
		}
		System.out.println("|---------------------------------|------------------------------------|");
		System.out.println("|                 city            |               temp(c)              |");
		System.out.println("|----------------------------------------------------------------------|");
		for (CityWeatherResponse cityResponse : cityWeatherResponseList) {
			String temp = cityResponse.getCurrent().getTemp_c();
			String city = cityResponse.getLocation().getName();
			System.out.println("|             " + city + "        |           " + temp + "             |");
		}
		System.out.println("------------------------------------------------------------------------");
	}

	public Object processJsonArray(String response, boolean reportFlag) {
		if (reportFlag) {
			List<CityDetails> cityDetailsList = new ArrayList<CityDetails>();
			if (response.startsWith("[")) {

				JSONArray jsonArrAccounts = new JSONArray(response);

				for (int i = 0; i < jsonArrAccounts.length(); i++) {
					JSONObject jsonObj = jsonArrAccounts.getJSONObject(i);
					String name = CommonUtils.getParamJsonValue(jsonObj.toString(), "name").toString().replace("\"",
							" ");
					String temp_c = CommonUtils.getParamJsonValue(jsonObj.toString(), "temp_c").toString().replace("\"",
							" ");
					String temp_f = CommonUtils.getParamJsonValue(jsonObj.toString(), "temp_f").toString().replace("\"",
							" ");

					String createdAt = CommonUtils.getParamJsonValue(jsonObj.toString(), "createdAt").toString()
							.replace("\"", " ");

					CityDetails cityDetails = new CityDetails();
					cityDetails.setName(name);
					cityDetails.setTemp_f(Double.parseDouble(temp_f));
					cityDetails.setTemp_c(Double.parseDouble(temp_c));
					cityDetails.setCreatedAt(createdAt);

					cityDetailsList.add(cityDetails);

				}
			}
			return cityDetailsList;
		} else {

			List<CityWeatherResponse> cityWeatherResponseList = new ArrayList<CityWeatherResponse>();
			if (response.startsWith("[")) {

				JSONArray jsonArrAccounts = new JSONArray(response);

				for (int i = 0; i < jsonArrAccounts.length(); i++) {
					JSONObject jsonObj = jsonArrAccounts.getJSONObject(i);
					String name = CommonUtils.getParamJsonValue(jsonObj.toString(), "name").toString().replace("\"",
							" ");
					String temp_c = CommonUtils.getParamJsonValue(jsonObj.toString(), "temp_c").toString().replace("\"",
							" ");
					String temp_f = CommonUtils.getParamJsonValue(jsonObj.toString(), "temp_f").toString().replace("\"",
							" ");

					CityWeatherResponse cityWeatherResponse = new CityWeatherResponse();
					CityWeatherResponse.CityLocation cityLocation = new CityWeatherResponse.CityLocation();
					CityWeatherResponse.CurrentTemp currentTemp = new CityWeatherResponse.CurrentTemp();
					cityLocation.setName(name);
					currentTemp.setTemp_f(temp_f);
					currentTemp.setTemp_c(temp_c);
					cityWeatherResponse.setCurrent(currentTemp);
					cityWeatherResponse.setLocation(cityLocation);

					cityWeatherResponseList.add(cityWeatherResponse);

				}
			}
			return cityWeatherResponseList;

		}

	}

}

package com.mvnproj.weatherapp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvnproj.weatherapp.service.WeatherAppService;

public class WeatherApp {

	public static void main(String[] args) {

		if (args.length > 0) {
			String city = args[0];
			String weatherDate = args.length > 1 ? args[1] : "";

			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
			WeatherAppService weatherAppService = applicationContext.getBean(WeatherAppService.class);
			weatherAppService.getCityWeatherDetails(city, weatherDate);

		} else {
			System.out.println("please provide a city name");
		}

	}

}

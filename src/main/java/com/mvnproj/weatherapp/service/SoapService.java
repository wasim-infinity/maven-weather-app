package com.mvnproj.weatherapp.service;
import org.springframework.stereotype.Service;

@Service
public interface SoapService {

	public String soapServiceCall(String url); 
}

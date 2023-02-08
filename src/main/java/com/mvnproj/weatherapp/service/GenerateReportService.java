package com.mvnproj.weatherapp.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mvnproj.weatherapp.response.CityDetails;

@Service
public interface GenerateReportService {

	public String generateReport(List<CityDetails> reportList);
}

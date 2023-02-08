package com.mvnproj.weatherapp.service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.mvnproj.weatherapp.response.CityDetails;

@Service
public class GenerateExcelReportServiceImpl implements GenerateReportService{

	public String generateReport(List<CityDetails> reportList) {

		String[] headerArray = null;

		headerArray = new String[] { "City", "Date", "Temp(c)", "Temp(f)" };

		String tempPath = "C:\\Users\\Wasim Akram\\eclipse-workspace\\mvn-weather-app\\src\\main\\resources";
		String filePath = tempPath + File.separator + "City-Report-"
				+ (LocalDateTime.now().toString().split(Pattern.quote("T"))[0]) + ".xls";

		if (reportList.isEmpty()) {
			throw new RuntimeException("Data not found. Error occurred!");
		} else {
			try {

				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet spreadsheet = workbook.createSheet("City Report");
				FileOutputStream out = new FileOutputStream(new File(filePath));

				int size = 1;
				HSSFCell cell;
				int index = 0;
				Row header = spreadsheet.createRow(0);

				for (String fieldHeader : headerArray) {
					header.createCell(index++).setCellValue(fieldHeader);
				}

				for (CityDetails report : reportList) {
					HSSFRow row = spreadsheet.createRow(spreadsheet.getLastRowNum() + 1);
					row.createCell(0).setCellValue(report.getName());
					row.createCell(1).setCellValue("" + report.getCreatedAt());
					row.createCell(2).setCellValue("" + report.getTemp_c());
					row.createCell(3).setCellValue("" + report.getTemp_f());
				}
				spreadsheet.autoSizeColumn(0);
				spreadsheet.autoSizeColumn(1);
				spreadsheet.autoSizeColumn(2);
				spreadsheet.autoSizeColumn(3);
				spreadsheet.autoSizeColumn(4);
				spreadsheet.autoSizeColumn(5);

				spreadsheet.autoSizeColumn(6);

				workbook.write(out);
				out.close();
				workbook.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return filePath;
	}

}

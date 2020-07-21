package com.abovesurveying;

import org.openqa.selenium.WebElement;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SolarFarm {
	
	private static final String SOLAR_FARM_URL_TEMPLATE = "https://client-test.abovesurveying.com/solarFarm.php?solarFarmId=%s";
	private String id;
	private String name;
	private String surveyDate;
	
	public static SolarFarm from(WebElement we) {
		return SolarFarm
				.builder()
				.id(we.getAttribute("solarfarmid"))
				.name(we.getAttribute("solarfarmname"))
				.surveyDate(we.getAttribute("surveydate"))
				.build();
	}
	
	public String getUrl() {
		return String.format(SOLAR_FARM_URL_TEMPLATE, id);
	}

}

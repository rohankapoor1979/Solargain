package com.abovesurveying;


import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * To build project at command line: mvn clean install -package
 * 
 * To run this program 
 * 
 *  mvn exec:java -Dexec.mainClass=com.abovesurveying.SolargainChrome
 *  java -jar target/solargain-1.0-SNAPSHOT-jar-with-dependencies.jar com.abovesurveying.SolargainChrome
 *
 */
public class SolargainChrome {
	
	final static Logger LOGGER = Logger.getLogger(SolargainChrome.class);
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Main User\\Downloads\\chromedriver_win32 (1)/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Apps\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com//");
		System.out.println(driver.getTitle());

		driver.get("https://client-test.abovesurveying.com/index.php?redirect=%2FclientPortal.php");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		/// System.out.println(driver.getPageSource());
		/// driver.findElement(By.id("username")).sendKeys("rohan");
		/// driver.findElement(By.name("password")).sendKeys("badminton");

		/// driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();

		driver.findElement(By.cssSelector("#username")).sendKeys("rohan");
		driver.findElement(By.cssSelector("#password")).sendKeys("badminton");
		driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();
		/// driver.findElement(By.linkText("Forgotten account?")).click();
		System.out.println(driver.findElement(By.cssSelector("#feedback")).getText());
		
		Thread.sleep(5000);

		List<WebElement> elements = driver.findElements(By.cssSelector("#solarPlantList > div"));

		LOGGER.info(String.format("Found %d solar farms", elements.size()));
		
		for (WebElement e : elements) {
			
			List<WebElement> childs = e.findElements(By.xpath("./child::*"));

			for (WebElement ce : childs) {
				LOGGER.info(String.format("Solar farm [%s] has last inspection date [%s] and inspection status [%s]", 
						ce.getAttribute("solarfarmname"), 
						ce.getAttribute("surveydate"),
						InspectionDateStatus.statusOf(ce.getAttribute("surveydate"))));
			}

		}

	}
	
	

}

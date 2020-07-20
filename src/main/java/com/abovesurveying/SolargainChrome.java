package com.abovesurveying;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SolargainChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Main User\\Downloads\\chromedriver_win32 (1)/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com//");
		System.out.println(driver.getTitle());
		
		driver.get("https://client-test.abovesurveying.com/index.php?redirect=%2FclientPortal.php");
		System.out.println(driver.getTitle());
		   System.out.println(driver.getCurrentUrl());
		///System.out.println(driver.getPageSource());
		   ///driver.findElement(By.id("username")).sendKeys("rohan");
		   ///driver.findElement(By.name("password")).sendKeys("badminton");
		   
		   ///driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();
		   
		   driver.findElement(By.cssSelector("#username")).sendKeys("rohan");
		   driver.findElement(By.cssSelector("#password")).sendKeys("badminton");
		   driver.findElement(By.xpath("/html/body/div/div/div/form/button")).click();
		   ///driver.findElement(By.linkText("Forgotten account?")).click();
		   System.out.println(driver.findElement(By.cssSelector("#feedback")).getText());

	}

}

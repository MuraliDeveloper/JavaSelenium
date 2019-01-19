package com.mythri;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.DriverUtils;

public class TestOpeartionsTour {

	
	static WebDriver driver ;
	@BeforeClass
	public static void setup(){
		 driver = DriverUtils.getDriver();
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get("http://www.newtours.demoaut.com/");
		
		Thread.sleep(3000);
		//REGISTER
		WebElement regLink = 
				driver.findElement(By.linkText("REGISTER"));
		
		regLink.click();
		
		WebElement fName = 
				driver.findElement(By.name("firstName"));
		Assert.assertTrue("fName is expected for display",fName.isDisplayed());
		Assert.assertTrue("fName to enable",fName.isEnabled());
		
 		
		fName.sendKeys("krishna"); // enter values to field
		
		
		driver.findElement(By.name("lastName")).sendKeys("singamreddy");
		driver.findElement(By.name("phone")).sendKeys("87878787");
		driver.findElement(By.name("userName")).sendKeys("xyz@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("sreeramnagar");
		
		
		driver.findElement(By.name("address2")).sendKeys("dorasanipalliroad");
		driver.findElement(By.name("city")).sendKeys("proddatur");
		
		driver.findElement(By.name("state")).sendKeys("andhrapradesh");
		
		driver.findElement(By.name("postalCode")).sendKeys("516360");
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public static void clean(){
		driver.close();
	}



}

package com.app.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Properties;


public class ProfilePage {
	WebDriver driver;
	
	
	
	public ProfilePage(WebDriver driver){
		this.driver=driver;
	}
	
	public void loginIntoProfile2() throws Exception
	{
		Properties propObj=new Properties();
		String rootFolder1=System.getProperty("user.dir");
		propObj.load(new FileInputStream(rootFolder1+"//src//test//resources//loginDeatils.properties"));
		driver.findElement(By.id("mobileNumberPass")).sendKeys(propObj.getProperty("EmailId"));
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(propObj.getProperty("Password"));
		driver.findElement(By.xpath("//button[@class=\"btn primary  lg block submitButton\"]")).click();
		Thread.sleep(31000);
		driver.findElement(By.xpath("//button[@class=\"btn primary  lg block submitButton\"]")).click();
		Thread.sleep(5000);
		driver.get("https://www.myntra.com/my/profile");
		WebElement nameElement=driver.findElement(By.xpath("//div[contains(text(),\"HARIHAR\")]"));
		String actualName=nameElement.getText();
		String expectedName="HARIHAR";
		Assert.assertEquals(actualName, expectedName,"User Name Doesn't Match");
		
		
	}

}

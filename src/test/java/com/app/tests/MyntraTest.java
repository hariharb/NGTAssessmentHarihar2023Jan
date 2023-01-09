package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.pages.CartPage;
import com.app.pages.ProfilePage;

public class MyntraTest {
	WebDriver driver;
	CartPage cart;
	ProfilePage profile;
	

	@BeforeMethod
	public void setup() throws Exception {

		driver = new ChromeDriver();
		cart = new CartPage(driver);
		profile = new ProfilePage(driver);
		

		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/login/password ");

	}

	@Test
	public void verifyCartBag() throws Exception {
				
		cart.loginIntoProfile();
		cart.verifyBag();
		cart.addtoBag();
		cart.verifyAfterAdd();
		driver.quit();

	}
	
	@Test
	public void verifyProfile() throws Exception {
		profile.loginIntoProfile2();
		
	}
	
	@AfterClass
	  public void afterClass() {
		  driver.close();
	  }
	
}

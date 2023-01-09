package com.app.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {
WebDriver driver;
String rootFolder1=System.getProperty("user.dir");


	
	public CartPage(WebDriver driver) throws Exception{
		this.driver=driver;
		
	}
	public void loginIntoProfile() throws Exception
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
		
		
	}
	public void verifyBag() throws Exception
	{
		driver.findElement(By.xpath("//span[contains(text(),\"Bag\")] ")).click();
		WebElement NoItemMsg=driver.findElement(By.xpath("//div[contains(text(),\"There is nothing in your bag. Let's add some items.\")]"));
		String ActualMsg=NoItemMsg.getText();
		String ExpectedMsg="There is nothing in your bag. Let's add some items.";
		Assert.assertEquals(ActualMsg, ExpectedMsg,"There is an Item in the Cart");
		Thread.sleep(3000);
		
		
		
	}
	public void addtoBag() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class=\"linkClean\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("Redmi",Keys.ENTER);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//img[@title=\"DressBerry Lavender Textured Structured Mobile Pouch\"]")).click();
	    Thread.sleep(5000);
	    
	    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      driver.findElement(By.xpath("//div[contains(text(),\"ADD TO BAG\")]")).click();
	      Thread.sleep(5000);
	     
	}
	
	public void verifyAfterAdd()
	{
		driver.findElement(By.xpath("//span[contains(text(),\"Bag\")] ")).click();
		WebElement AddtoCart=driver.findElement(By.xpath("//div[contains(text(),\"1/1 ITEMS SELECTED\")]"));
		String MsgActual=AddtoCart.getText();
		String MsgExpected="1/1 ITEMS SELECTED";
		Assert.assertEquals(MsgActual, MsgExpected,"The item is Not Added");
	}

}

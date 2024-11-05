package com.seleniumm;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByName {

	public static void main(String[]args) throws Exception {
		//Chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");

		//create an instance of driver
		WebDriver driver=new ChromeDriver();
		//load web page under test
	    driver.get("file:///C:\\Users\\Administrator\\eclipse-study\\com.seleniumproject1\\src\\main\\resources\\LocateByNameEg.html");
		//locate HTML element by name
	    WebElement username=driver.findElement(By.name("username"));
	    //set some text to above element 
	    username.sendKeys("newUser");
	    
	    
		Thread.sleep(5000);
		driver.quit();
}
}

package com.seleniumm;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByIdEg {
public static void main(String[]args) throws Exception {
		//Chrome driver path
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");

		//create an instance of driver
		WebDriver driver=new ChromeDriver();
		//load web page under test
		driver.get("file:///C:\\Users\\Administrator\\Desktop\\Spring_NewWorkPlace\\Selenium\\com.seleniumproject1\\src\\main\\resources\\LocateByIdEg.html");
		//locate HTML element whose id is username
	    WebElement usernameField=driver.findElement(By.id("username"));
	    //set the text
		usernameField.sendKeys("myusername");
		Thread.sleep(5000);
		driver.quit();
}
}
	


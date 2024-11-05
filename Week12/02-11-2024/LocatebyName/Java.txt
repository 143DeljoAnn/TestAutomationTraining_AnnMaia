 package com.seleniumm;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class LocateByNameEg2_Mine {
public static void main(String[] args) throws Exception{
	//chrome driver path
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");


	//Create an instance of driver
	WebDriver driver = new ChromeDriver();

	//Load web page under Test
	driver.get("file:///C:\\\\Users\\\\Administrator\\\\Desktop\\\\Spring_NewWorkPlace\\\\Selenium\\\\com.seleniumproject1\\\\src\\\\main\\\\resources\\\\LocateByNameEg2.html");
	
	//create WebDriverWait
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//locate username, only after it appears on webpage
	WebElement usernameField = wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.name("username")));
	
	//enter texxt in username field
	usernameField.sendKeys("someuser");
	
	//locate age
	WebElement ageField = driver.findElement(By.name("age"));
	
	//enter age
	ageField.sendKeys(String.valueOf(35));
	
	//set country
	WebElement countryDropdown = driver.findElement(By.name("country"));
	countryDropdown.sendKeys("Canada");
	
	//locate button
	WebElement submitButton = driver.findElement(By.id("submitButton"));
	
	//Type mail address
	WebElement Email = driver.findElement(By.id("email"));
	Email.sendKeys("maneesha@emailinator.com");
	//click button
	submitButton.click();
	
	//wait for message to be visible & get updated message text
	WebElement messageDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
	System.out.println("Message is:"+messageDiv.getText());
	
	Thread.sleep(10000);
	
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(screenshot, new File("./screenshot4.png"));

	Thread.sleep(3000);
	driver.quit();
	
}
}
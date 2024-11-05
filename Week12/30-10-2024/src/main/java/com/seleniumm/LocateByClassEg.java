package com.seleniumm;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class LocateByClassEg {
public static void main(String[] args) throws Exception{
	//chrome driver path
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");


	//Create an instance of driver
	WebDriver driver = new ChromeDriver();

	//Load web page under Test
	driver.get("file:///C:\\Users\\Administrator\\Desktop\\Spring_NewWorkPlace\\Selenium\\com.seleniumproject1\\src\\main\\resources\\LocateByClass.html");

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.className("button")));

	button.click();
	
	WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));

	System.out.println("Message: "+message.getText());
	
	Thread.sleep(10000);
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(screenshot, new File("./screenshot4.png"));

	Thread.sleep(30000);
	driver.quit();

}
}
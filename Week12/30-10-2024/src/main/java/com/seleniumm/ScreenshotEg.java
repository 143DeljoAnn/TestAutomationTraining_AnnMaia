package com.seleniumm;

import java.io.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotEg {
public static void main(String[] args) throws Exception {
	//chrome driver path
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");

	//Create an instance of driver
	WebDriver driver = new ChromeDriver();

	//Load web page under Test
	driver.get("file:///C:\\Users\\Administrator\\Desktop\\Spring_NewWorkPlace\\Selenium\\com.seleniumproject1\\src\\main\\resources\\ScreenshotEg.html");

	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(screenshot, new File("./screenshot1.png"));

	Thread.sleep(3000);
	driver.quit();
}
}
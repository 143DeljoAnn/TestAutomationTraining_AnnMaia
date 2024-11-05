package com.seleniumm;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class LocateByNameEg2 {
	
	public static void main(String args[]) throws Exception{
		//set driver properties
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");
		
		//create driver instance
		WebDriver driver=new ChromeDriver();
		
		//load webpage
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-study\\com.seleniumproject1\\src\\main\\resources\\LocateByNameEg2.html");
		
		//----wait until webpage loaded successfully
		Thread.sleep(4000);
		 
		//locate username
		WebElement userNameField=driver.findElement(By.name("username"));
		
		//enter text in username field 
		
		userNameField.sendKeys("Uname");
		
		//locate age
		WebElement ageField=driver.findElement(By.name("age"));
		//enter age
		
		ageField.sendKeys("24");
		//locte button
		
		WebElement buttonField=driver.findElement(By.id("submitButton"));
		//click button
		buttonField.click();
		
		//----wait for message to be visible
		Thread.sleep(3000);
		//get updated message text
		WebElement message= driver.findElement(By.id("message"));
		
		String MessageText=message.getText();
		
		System.out.println("Message Displayed  :"+MessageText);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}

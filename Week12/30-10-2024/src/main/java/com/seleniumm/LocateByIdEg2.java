package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByIdEg2 {
	
	public static void main(String[]args) throws Exception {
		//Chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");

		//create an instance of driver
		WebDriver driver=new ChromeDriver();
		//load web page under test
	    driver.get("file:///C:\\Users\\Administrator\\eclipse-study\\com.seleniumproject1\\src\\main\\resources\\LocateByIdEg2.html");
		//locate HTML element whose id is username
	    WebElement tbuttonField=driver.findElement(By.id("testButton"));
	    Thread.sleep(2000);
	    //Click the button element
	    tbuttonField.click();
	    Thread.sleep(2000);
	    //locate message element
	    WebElement messageField=driver.findElement(By.id("message"));
	    //get text in message 
	    String umessage=messageField.getText();
	    //display above text
	    System.out.print("Updated Message: "+umessage);
		Thread.sleep(10000);
		driver.quit();
}

}

package com.seleniumm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExample {

	
	public static void main(String[]args) throws Exception {
		//Chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");
		//create an instance of chrome driver
		WebDriver driver=new ChromeDriver();
		//send get request for sample web page
		driver.get("http://www.example.com");
		//perform some operation on above loaded web page
		String title=driver.getTitle(); 
		System.out.println("Page Title is: "+title);
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}

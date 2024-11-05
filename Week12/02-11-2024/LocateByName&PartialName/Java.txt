package com.seleniumm;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LocateByText {
    public static void main(String[] args) throws InterruptedException, IOException {

        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver.exe");

        // Create driver instance
        WebDriver driver = new ChromeDriver();

        // Load the webpage
        driver.get("file:///C:/Users/Administrator/Desktop/Spring_NewWorkPlace/Selenium/com.seleniumproject1/src/main/resources/LocateByLinkText.html");

        // Wait until the "Visit Google" link is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement googleLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Visit Google")));
        googleLink.click();

        // Wait for navigation to complete
        wait.until(ExpectedConditions.urlContains("google.com"));

        // Go back to the main page
        driver.navigate().back();
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Visit")));

        // Find and click a link with partial text "Visit"
        WebElement visitLink = driver.findElement(By.partialLinkText("Visit"));
        visitLink.click();

        // Take a screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("C:\\Users\\Administrator\\screenshot5.png"));
        System.out.println("Screenshot saved at: C:\\Users\\Administrator\\screenshot6.png");

        // Close the browser
        driver.quit();
    }
}

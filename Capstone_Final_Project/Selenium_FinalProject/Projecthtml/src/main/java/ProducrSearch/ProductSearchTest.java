package ProducrSearch;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSearchTest {

    private WebDriver driver;
    private static final String BASE_URL = "file:///C:/Users/Administrator/Desktop/Project/com.ecommerce/src/main/resources/HTML.html"; // Change this to your local HTML file path

    @BeforeEach
    public void setUp() {
        // Set up the WebDriver (Ensure chromedriver is in your PATH)
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Administrator\\\\Downloads\\\\chromedriver-win32\\\\chromedriver.exe"); // Update path to chromedriver
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchProductFound() throws InterruptedException {
        driver.get(BASE_URL);

        // Locate the search input field and search button
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));

        // Input search query
        searchInput.sendKeys("Apple iPhone 15");

        // Click on search button
        searchButton.click();

        // Wait for results to appear
        Thread.sleep(1000); // Use WebDriverWait for more robust synchronization

        // Locate the results container
        WebElement results = driver.findElement(By.id("results"));
        
        // Verify if the correct product is found
        assertTrue(results.getText().contains("Apple iPhone 15"));
        System.out.println("Test Passed: Product found in search results.");
    }

    @Test
    public void testSearchProductNotFound() throws InterruptedException {
        driver.get(BASE_URL);

        // Locate the search input field and search button
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));

        // Input search query for a non-existing product
        searchInput.sendKeys("Nonexistent Product");

        // Click on search button
        searchButton.click();

        // Wait for results to appear
        Thread.sleep(1000); // Use WebDriverWait for more robust synchronization

        // Locate the results container
        WebElement results = driver.findElement(By.id("results"));
        
        // Verify if no products are found
        assertTrue(results.getText().contains("No products found"));
        System.out.println("Test Passed: No product found for search query.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
/*
   @Test
    public void testSearchReport() throws IOException {
        // Initialize Excel Workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test Report");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Test Case");
        header.createCell(1).setCellValue("Result");

        // Run tests and write results into Excel
        Row row = sheet.createRow(1);
        row.createCell(0).setCellValue("Search for 'Apple iPhone 14'");
        row.createCell(1).setCellValue("Passed");

        // Save the report to an Excel file
        try (FileOutputStream fileOut = new FileOutputStream("search_test_report.xlsx")) {
            workbook.write(fileOut);
        }

        workbook.close();
    }*/
}

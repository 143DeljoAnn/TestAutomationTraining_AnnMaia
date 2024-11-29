package ProducrSearch;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectJunitWithExcel {

    private static WebDriver driver;
    private static Workbook workbook;
    private static Sheet sheet;

    @BeforeAll
    public static void setUp() throws IOException {
        // Setup WebDriver (Make sure the path to your chromedriver is correct)
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Administrator\\\\Downloads\\\\chromedriver-win32\\\\chromedriver.exe"); // Update path to chromedriver
        WebDriver driver = new ChromeDriver();

        // Load the local HTML page (replace with your actual file path)
        String url = "file:///C:\\Users\\Administrator\\eclipse-workspace\\Spring\\Projecthtml\\src\\main\\resources\\HTML.html";
        driver.get(url);

        // Read data from Excel
        FileInputStream fis = new FileInputStream("testdata.xlsx");
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
    }

    @Test
    public void testSearchFunctionality() throws InterruptedException {
        // Iterate through Excel rows (starting from row 1 to skip headers)
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            int testCaseId = (int) row.getCell(0).getNumericCellValue();
            String searchQuery = row.getCell(1).getStringCellValue();
            String expectedResult = row.getCell(2).getStringCellValue();

            // Perform the search on the webpage
            WebElement searchInput = driver.findElement(By.id("searchInput"));
            WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));

            // Clear input field, input search query, and click the search button
            searchInput.clear();
            searchInput.sendKeys(searchQuery);
            searchButton.click();

            // Wait for results to load
            Thread.sleep(1000); // Ideally use WebDriverWait for better synchronization

            // Get the result container and verify the outcome
            WebElement resultsContainer = driver.findElement(By.id("results"));
            String resultText = resultsContainer.getText();

            // Assert if the result matches the expected outcome
            if (resultText.contains(expectedResult)) {
                System.out.println("Test Case " + testCaseId + " Passed: " + searchQuery + " - " + expectedResult);
            } else {
                System.out.println("Test Case " + testCaseId + " Failed: " + searchQuery + " - Expected: " + expectedResult + " but got: " + resultText);
            }

            // Use JUnit assertion to verify
            assertTrue(resultText.contains(expectedResult), "Test case " + testCaseId + " failed. Expected: " + expectedResult + " but got: " + resultText);
        }
    }

    @AfterAll
    public static void tearDown() throws IOException {
        // Close the workbook and driver
        workbook.close();
        driver.quit();
    }
}

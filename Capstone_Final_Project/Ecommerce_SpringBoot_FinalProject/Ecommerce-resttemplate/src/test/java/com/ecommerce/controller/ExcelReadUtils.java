package com.ecommerce.controller;

import com.ecommerce.controller.CustomProperties;
import com.ecommerce.controller.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class ExcelReadUtils {
    private static Workbook wbook;
    private static Sheet sheet,sheet1;

    // Initialize the Excel file
    public static void init() {
        try {
            // Read paths from JSON settings
            ObjectMapper omapper = new ObjectMapper();
            FileInputStream sfis = new FileInputStream("./settings.json");
            CustomProperties obj = omapper.readValue(sfis, CustomProperties.class);

           
            // Read Excel workbook
            FileInputStream fis = new FileInputStream(obj.getIexcelpath());
            wbook = new XSSFWorkbook(fis);
            System.out.println("Input Path: " + obj.getIexcelpath());
            
           
            
            sheet = wbook.getSheetAt(0);
            sheet1 = wbook.getSheetAt(1);// Use the first sheet
            
            

        } catch (Exception e) {
            System.out.println("Exception during Excel initialization: " + e.getMessage());
        }
    }

 // Fetch test data for Search Products
    public static Stream<Arguments> SearchProducts() {
        List<Arguments> args = new ArrayList<>();
        try {
            // Determine the last row with data
            int lastRowNum = sheet.getLastRowNum(); // Gets the last physical row
            System.out.println("Last Row Num: " + lastRowNum);

            // Iterate through the rows and filter rows with content
            for (int i = 1; i <= lastRowNum; i++) { // Start from 1 to skip the header row
                Row row = sheet.getRow(i);
                

                // Fetch test case ID from column 0
                Cell testCaseIdCell = row.getCell(0);
                String testCaseId = testCaseIdCell != null ? testCaseIdCell.getStringCellValue().trim() : "";

                // Fetch product name from column 1
                Cell productNameCell = row.getCell(1);
                String productName = productNameCell != null ? productNameCell.getStringCellValue().trim() : "";

                // Add as Arguments
                args.add(Arguments.of(testCaseId, productName));
            }
        } catch (Exception e) {
            System.out.println("Error reading Excel data: " + e.getMessage());
        }
        return args.stream();
    }

public static Stream<Arguments> BuyProduct() {
		
	  List<Arguments> args = new ArrayList<>();
      try {
          // Determine the last row with data
          int lastRowNum = sheet1.getLastRowNum(); // Gets the last physical row
          System.out.println("Last Row Num: " + lastRowNum);

          // Iterate through the rows and filter rows with content
          for (int i = 1; i <= lastRowNum; i++) { // Start from 1 to skip the header row
              Row row = sheet1.getRow(i);
              

              // Fetch test case ID from column 0
              Cell testCaseIdCell = row.getCell(0);
              String testCaseId = testCaseIdCell != null ? testCaseIdCell.getStringCellValue().trim() : "";

              Cell cellpid = row.getCell(1);
              int productid = (cellpid != null) ? (int) cellpid.getNumericCellValue() : 0;

				
              Cell celljson = row.getCell(2);
				String productjson = celljson != null ?celljson.getStringCellValue().trim() : "";  
              
				Cell cellqty = row.getCell(3);
	              int quantity = (cellqty != null) ? (int) cellqty.getNumericCellValue() : 0;
              // Add as Arguments
              args.add(Arguments.of(testCaseId, productid,productjson,quantity));
          }
      } catch (Exception e) {
          System.out.println("Error reading Excel data: " + e.getMessage());
      }
      return args.stream();
	}
	


	
	

	


	Product fetchProduct(ResultActions resultActions) throws Exception {
		String jsonresponse = resultActions.andReturn().getResponse().getContentAsString();

		System.out.println("Json Responsee:" + jsonresponse);

		// Student student = new ObjectMapper() //.readValue(jsonString,
		// Student.class);

		// json string to java object
		ObjectMapper omapper = new ObjectMapper();

		Product product = omapper.readValue(jsonresponse, Product.class);
		return product;
	}

}
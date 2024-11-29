package com.ecommerce.controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.ecommerce.controller.CustomProperties;
import com.ecommerce.controller.ExcelReadUtils;
import com.ecommerce.controller.ExcelWriteUtils;
import com.ecommerce.controller.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductApiTest {
	@Autowired
	private MockMvc mockMvc;
	private static Workbook wbook;

	private static Sheet st;

	@Autowired
	ExcelReadUtils eRUtils;

	@Autowired
	ExcelWriteUtils eWUtils;

	@BeforeAll
	static void metb() {

		ExcelReadUtils.init();
		// open or create excel(Test Report)
		// create workbook
		wbook = new XSSFWorkbook();

		// create a new sheet
		st = wbook.createSheet("First Sheet");
	}

	@BeforeEach
	void met() {

	}

	static Stream<Arguments> wSearchProducts() {
		return ExcelReadUtils.SearchProducts();
	}
    
	@Order(1)
	@ParameterizedTest
	@MethodSource("wSearchProducts")
	void testSearchProducts(String tcaseid,String name) throws Exception {
		try {
			ResultActions resultActions = mockMvc.perform(get("/api/products/search?keyword="+name)) // Sending GET request with url
					.andExpect(status().isOk()) // checking response Http Status code
					// below, checking response Content Type
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$[0].name").value(name));
					
			// .andDo(print());
			Product product = eRUtils.fetchProduct(resultActions);
			System.out.println("Name:" + product.getName());
		} catch (AssertionError ae) {
			eWUtils.createTestResultRow(tcaseid+" : Failed", st);
			throw ae;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		// create row in excel
		// create row
		eWUtils.createTestResultRow(tcaseid+" : Passed", st);
		System.out.println("----------------------------------------");
	}
	
	static Stream<Arguments> wBuyProducts() {
		return ExcelReadUtils.BuyProduct();
	}
	
	@Order(2)
	@ParameterizedTest
	@MethodSource("wBuyProducts")
	void testBuyProducts(String tcaseid,int productid,String productjson,int quantity) throws Exception {
		 try {
			// Extract the 'quantity' field using JsonPath
		        int extractedQuantity = JsonPath.read(productjson, "$.quantity"); 
              
		        // You can now use the extracted value for your test or assertions
		        System.out.println("Extracted quantity from ticket JSON: " + extractedQuantity);
			 mockMvc.perform(post("/api/products/buy/"+productid).contentType(MediaType.APPLICATION_JSON)
						.content(productjson))
						.andExpect(jsonPath("$.quantity").value(quantity)); // this assertion is not checked
			} catch (AssertionError ae) {
				eWUtils.createTestResultRow(tcaseid+" : Failed", st);
				throw ae;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}

			// create row in excel
			// create row
			eWUtils.createTestResultRow(tcaseid+" : Passed", st);
			System.out.println("----------------------------------------");
	}

	
	@AfterAll
	static void meta() {
		try {
			
			ObjectMapper omapper = new ObjectMapper();
			FileInputStream sfis = new FileInputStream("./settings.json");
			CustomProperties obj = omapper.readValue(sfis, CustomProperties.class);
			// close excel
			FileOutputStream fos = new FileOutputStream(obj.getOexcelpath());

			// write above excel to a file
			wbook.write(fos);
			wbook.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("Exceptionaa:" + e.getMessage());
		}
	}
   

    
}

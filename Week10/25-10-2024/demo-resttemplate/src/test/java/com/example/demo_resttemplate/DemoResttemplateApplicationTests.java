package com.example.demo_resttemplate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.*;

//import static java.lang.System.*;
@SpringBootTest
@AutoConfigureMockMvc
class DemoResttemplateApplicationTests {
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

	static Stream<Arguments> wFetchTicketIds() {
		return ExcelReadUtils.fetchTicketIds();
	}

	@ParameterizedTest
	@MethodSource("wFetchTicketIds")
	void testGetTicket(int ticketid, String fromplace, String toplace, float price) throws Exception {
		try {
			ResultActions resultActions = mockMvc.perform(get("/redbus/" + ticketid)) // Sending GET request with url
					.andExpect(status().isOk()) // checking response Http Status code
					// below, checking response Content Type
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$.fromplace").value(fromplace)).andExpect(jsonPath("$.toplace").value(toplace))
					.andExpect(jsonPath("$.price").value(price));
			// .andDo(print());
			Ticket ticket = eRUtils.fetchTicket(resultActions);
			System.out.println("From Placeee:" + ticket.getFromplace());
		} catch (AssertionError ae) {
			eWUtils.createTestResultRow("TestCase: Failed", st);
			throw ae;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

		// create row in excel
		// create row
		eWUtils.createTestResultRow("TestCase: Passed", st);
		System.out.println("----------------------------------------");
	}

	@AfterAll
	static void meta() {
		try {
			// close excel
			FileOutputStream fos = new FileOutputStream("testreport.xlsx");

			// write above excel to a file
			wbook.write(fos);
			wbook.close();
			fos.close();
		} catch (Exception e) {
			System.out.println("Exceptionaa:" + e.getMessage());
		}
	}
	// id which doesnt exist
	// not int id

	static Stream<Arguments> excelReadTicketJson() {
		return ExcelReadUtils.readTicketJson();
	}

	@Disabled
	// @ParameterizedTest
	// @MethodSource("excelReadTicketJson")
	void testBookTicket(String ticketjson, String username) throws Exception {
		// call method which reads JSON from Excel
		try {
			mockMvc.perform(post("/redbus").contentType(MediaType.APPLICATION_JSON).content(ticketjson))
					.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
					// .andDo(print())
					.andExpect(jsonPath("$.username").value(username));
		} catch (AssertionError e) {
			System.out.println("Test Case: Failed\n" + e.getMessage());
			throw e;
		} catch (Exception e) {
			System.out.println("Exceptionn:" + e.getMessage());
		}

		System.out.println("Test Case: Pass");
	}

	// @Test
	@Disabled
	void testUpdateTicket() throws Exception {
		mockMvc.perform(put("/redbus/27").contentType(MediaType.APPLICATION_JSON).content(
				// "{\"username\":\"user456\","+
				"{\"fromplace\":\"jjjjjj\"," + "\"toplace\":\"kkkk\"," + "\"email\":\"987652@gmail.com\", "
						+ "\"price\":9876.5}"))
				.andExpect(status().isCreated());
	}

	// @Test
	@Disabled
	void cancelTicket() throws Exception {
		mockMvc.perform(delete("/redbus/27")).andExpect(status().isOk());

	}

}

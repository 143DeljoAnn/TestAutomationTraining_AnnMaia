package com.example.DemoRestAssuredAssignment;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Disabled;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DemoRestAssuredAssignmentApplicationTests {

	@Autowired
	private MockMvc mockmvc;
	
	
	public static Stream<Arguments>fetchTicketParametersExcel(){
		List<Arguments> args = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("D:\\Softwares\\Book2.xlsx");
			Workbook wbook = new XSSFWorkbook(fis);
			double value=0;
			int no_of_rows=0;
			Sheet st = null;
			st =wbook.getSheetAt(0);
			no_of_rows=st.getPhysicalNumberOfRows();
			for(int i=0;i<no_of_rows;i++) {
				Row row=st.getRow(i);
				int no_of_cols = row.getLastCellNum();
				
				Cell cell1= row.getCell(0);
				int ticketid=(int)cell1.getNumericCellValue();
				
				Cell cell2 = row.getCell(1);
				String fromplace = cell2.getStringCellValue();
				
				Cell cell3 = row.getCell(2);
				String toplace = cell3.getStringCellValue();
				
				Cell cell4= row.getCell(3);
				float price=(float)cell4.getNumericCellValue();

				
				args.add(Arguments.of(ticketid,fromplace,toplace,price));
			}
			wbook.close();
			fis.close();
					
		}catch(Exception e) {
			System.out.println("Exceptionnnn");
		}
		return args.stream();
	}
	
	@ParameterizedTest
	@MethodSource("fetchTicketParametersExcel")
	void testGetTicketMultipleParameterizedTestExcel(int ticketid,String fromplace,String toplace,float price) throws Exception {
		ResultActions resultActions = mockmvc.perform(get("/redbus/"+ticketid))
		.andExpect(status().isOk()) 
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.fromplace").value(fromplace))
		.andExpect(jsonPath("$.toplace").value(toplace))
		.andExpect(jsonPath("$.price").value(price))
		.andDo(print());
		String jsonresponse = resultActions.andReturn().getResponse().getContentAsString();
		System.out.println("Json Response :"+jsonresponse);

	}
	

}
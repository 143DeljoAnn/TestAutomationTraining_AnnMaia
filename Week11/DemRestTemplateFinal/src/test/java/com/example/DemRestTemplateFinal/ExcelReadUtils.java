package com.example.DemRestTemplateFinal;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExcelReadUtils {

	/*
	 * //Retrieving Hard coded Test Data private static Stream<Arguments>
	 * fetchTicketIds(){ return Stream.of(Arguments.of(8,"pqrs","mnop"),
	 * Arguments.of(9,"ggggg","hhhh"), Arguments.of(10,"ggggg","hhhh") ); }
	 */
	private static Workbook wbook;
	private static Sheet sheet;
	private static int current_row_num;
	
	public static void init() {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\Book5.xlsx");
			wbook = new XSSFWorkbook(fis);
			sheet=wbook.getSheetAt(0);
			current_row_num=0;
		}catch(Exception en) {
			System.out.println("Exception in init"+en.getMessage());
		}
	}

	// can be moved to different Java file
	public static Stream<Arguments> fetchTicketIds() {
		List<Arguments> args = new ArrayList<>();
		Row row =sheet.getRow(current_row_num++);
		Cell cell1 = row.getCell(0);
		int num_of_testcases=(int)cell1.getNumericCellValue();
		try {

			for (int i = current_row_num; i < (current_row_num+num_of_testcases); i++) {
				// fetch each row
				Row rowi = sheet.getRow(i);

				int no_of_cols = row.getLastCellNum();

				// read first column - ticket id
				Cell celltid = rowi.getCell(0);
				int ticketid = (int) celltid.getNumericCellValue();

				// read second col - fromplace
				Cell cellfp = rowi.getCell(1);
				String fromplace = cellfp.getStringCellValue();

				// read third col - toplace
				Cell celltp = rowi.getCell(2);
				String toplace = celltp.getStringCellValue();

				Cell cellprice = rowi.getCell(3);
				float price = (float) cellprice.getNumericCellValue();

				// add each Test data bundle to List
				args.add(Arguments.of(ticketid, fromplace, toplace, price));
			}

		} catch (Exception e) {
			System.out.println("Exceptionnnn:" + e.getMessage());
			e.printStackTrace();
		}

		// create and return Stream from List of JUnit Arguments
		return args.stream();
	}
	
	public static Stream<Arguments> readTicketJson() {
		List<Arguments> args = new ArrayList<>();
		try {
			// read Testdata from excel
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\Book4.xlsx");

			// read workbook
			Workbook wbook = new XSSFWorkbook(fis);

			double value = 0;

			int no_of_rows = 0;
			Sheet st = null;

			// read sheet
			st = wbook.getSheetAt(0);

			// fetch number of rows in excel
			no_of_rows = st.getPhysicalNumberOfRows();

			for (int i = 0; i < no_of_rows; i++) {
				// fetch each row
				Row row = st.getRow(i);

				int no_of_cols = row.getLastCellNum();

				// read first column - ticket id
				Cell cell1 = row.getCell(0);
				String ticketjson = cell1.getStringCellValue();
				
				Cell cell2 = row.getCell(1);
				String username = cell2.getStringCellValue();

				// add each Test data bundle to List
				args.add(Arguments.of(ticketjson,username));
			}

			wbook.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Exceptionnnn:" + e.getMessage());
			e.printStackTrace();
		}

		// create and return Stream from List of JUnit Arguments
		return args.stream();
	}


	Ticket fetchTicket(ResultActions resultActions) throws Exception {
		String jsonresponse = resultActions.andReturn().getResponse().getContentAsString();

		System.out.println("Json Responsee:" + jsonresponse);

		// Student student = new ObjectMapper() //.readValue(jsonString,
		// Student.class);

		// json string to java object
		ObjectMapper omapper = new ObjectMapper();

		Ticket ticket = omapper.readValue(jsonresponse, Ticket.class);
		return ticket;
	}

}
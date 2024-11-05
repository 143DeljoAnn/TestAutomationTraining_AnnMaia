package com.example.demo_resttemplate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

@Component
public class ExcelWriteUtils {
	private static int test_case_num = 0;
	public void createTestResultRow(String result, Sheet st) {
		// create row
		Row row = st.createRow(test_case_num++);

		// in above row, create cell, and set some value
		Cell cell = row.createCell(0, CellType.STRING);
		cell.setCellValue(result);

		// create row excel
		System.out.println(result);
		//System.out.println(ae.getMessage());
	}

}

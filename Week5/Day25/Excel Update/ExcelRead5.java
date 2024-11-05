package com.exceleg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead5 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// open file
		FileInputStream fis = new FileInputStream("./firstexcel5.xlsx");

		// read workbook
		Workbook wbook = new XSSFWorkbook(fis);

		System.out.println("No. of sheets: " + wbook.getNumberOfSheets());

		int no_of_sheets = wbook.getNumberOfSheets();

		double value = 0;

		int no_of_rows = 0;
		Sheet st = null;

		for (int k = 0; k < no_of_sheets; k++) {

			st = wbook.getSheetAt(k);

			no_of_rows = st.getPhysicalNumberOfRows();

			for (int i = 0; i < no_of_rows; i++) {

				Row row = st.getRow(i);

				int no_of_cols = row.getLastCellNum();

				for (int j = 0; j < no_of_cols; j++) {

					Cell cell = row.getCell(j);

					value = value + cell.getNumericCellValue();
				}
			}
		}
		System.out.println("sum is " + value);

		fis.close();

		FileOutputStream fos = new FileOutputStream("./firstexcel5.xlsx");

		Row row = st.createRow(no_of_rows);
		System.out.println("Created row... " + (no_of_rows));
		Cell cell = row.createCell(0);
		cell.setCellValue(value);

		Sheet newSheet = wbook.createSheet("Iteration Count");
		Row newRow = newSheet.createRow(0);
		Cell newCell = newRow.createCell(0);

		double values = newCell.getNumericCellValue() + 1;
		newCell.setCellValue(values);

		fis.close();
		wbook.write(fos);
		wbook.write(fos);
		fos.close();

	}
}

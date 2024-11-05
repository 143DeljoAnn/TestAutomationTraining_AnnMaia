package com.exceleg;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteEg {

	public static void main(String[] args) {
		try {
			Workbook wbook = new XSSFWorkbook();
			Sheet sheet = wbook.createSheet("FirstSheet");

			Row row = sheet.createRow(0);

			Cell cell = row.createCell(0);
			cell.setCellValue(112);

			FileOutputStream fos = new FileOutputStream("./firstexcel.xlsx");

			wbook.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

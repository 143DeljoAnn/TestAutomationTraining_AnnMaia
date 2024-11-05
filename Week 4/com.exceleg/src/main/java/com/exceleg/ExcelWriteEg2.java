package com.exceleg;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteEg2 {
	static String sarr[][] = { { "asdasd", "asdasdasd", "fsdfdfds" }, { "dsfsdf", "dsfsdfdf", "erewrsdf" },
			{ "gfhgf", "werwer", "fsdffgfdgdfds" }

	};

	public static void main(String[] args) {
		try {
			// create a workbook
			Workbook wbook = new XSSFWorkbook();

			// create a new sheet
			Sheet st = wbook.createSheet("First sheet");

			for (int i = 0; i < sarr[0].length; i++) {
				// create row
				Row row = st.createRow(i);
				for (int j = 0; j < sarr[0].length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(sarr[i][j]);

					// create cell, and set value to cell
					System.out.println("Writing the element " + sarr[i][j] + "to excel");

				}
				System.out.println();
			}
			FileOutputStream fos = new FileOutputStream("./firstexcel.xlsx");
			wbook.write(fos);
		} catch (Exception et) {
			et.printStackTrace();
		}

	}
}
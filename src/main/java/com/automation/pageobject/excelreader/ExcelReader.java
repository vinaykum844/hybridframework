package com.automation.pageobject.excelreader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getExcelData(String sheetName, String ExcelName) {
		try {

			String dataSets[][] = null;

			// FileInputStream file = new FileInputStream(new
			// File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			// XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			sheet = workbook.getSheet(sheetName);
			// count number of active tows
			int totalRow = sheet.getLastRowNum() + 1;
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow - 1][totalColumn];

			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);

				for (int j = 0; j < totalColumn; j++) {
					cell = row.getCell(j);

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(i + ",");
						System.out.print(j + ",");
						dataSets[i - 1][j] = cell.getStringCellValue();
						System.out.println(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(i + ",");
						System.out.print(j + ",");
						dataSets[i - 1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(i + ",");
						System.out.print(j + ",");
						dataSets[i - 1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						System.out.print(i + ",");
						System.out.print(j + ",");
						dataSets[i - 1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					}
				}
				System.out.println("");
			}

			return dataSets;
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

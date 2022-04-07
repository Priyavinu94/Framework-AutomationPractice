package com.automationPractice.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automationPractice.BasePackage.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream file;

	public static XSSFWorkbook wbook;
	// variable to identify workbook
	public static XSSFSheet wsheet;
	// variable to identify work sheet
	public static XSSFRow wrow;
	// variable to identify the row in which target element is present
	public static XSSFCell wcell;
	// variable to identify the exact cell in which target element is present

	public static int getRowCount(String filePath, String sheetName) throws IOException {
		int rowCount;
		file = new FileInputStream(filePath);

		wbook = new XSSFWorkbook(file);
		wsheet = wbook.getSheet(sheetName);
		rowCount = wsheet.getLastRowNum();
		wbook.close();
		return rowCount;
	}

	public static int getCellCount(String filePath, String sheetName, int rowNo) throws IOException {
		int columCount = 0;
		file = new FileInputStream(filePath);

		wbook = new XSSFWorkbook(file);
		wsheet = wbook.getSheet(sheetName);
		wrow = wsheet.getRow(rowNo);
		columCount = wrow.getLastCellNum();
		wbook.close();
		file.close();
		return columCount;
	}

	public static String getCellData(String filePath, String sheetName, int rowNo, int colNo) throws IOException {

		String data;
		file = new FileInputStream(filePath);

		wbook = new XSSFWorkbook(file);
		wsheet = wbook.getSheet(sheetName);
		wrow = wsheet.getRow(rowNo);
		wcell = wrow.getCell(colNo);
		data = wcell.getStringCellValue();

		return data;
	}

}

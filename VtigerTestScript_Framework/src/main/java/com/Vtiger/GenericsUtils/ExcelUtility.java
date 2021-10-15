package com.Vtiger.GenericsUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	/**
	 * @GAURAV
	 */
	/**
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String celldata = cell.getStringCellValue();
		return celldata;
		
	}
	/**
	 * @ GAURAV
	 * 
	 * @return
	 * @throws Throwable 
	 * @throws EncryptedDocumentException 
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable{
		FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	/*
	 * @ GAURAV
	 * this method  is used to write data inside the excel sheet
	 * @para sheetname
	 * @para rwnum
	 * @para column
	 * @para value 
	 * @throws Throwable
	 */
	public void writeExceldataString (String sheetname,int rownum,int column,String value) throws Throwable, Throwable {
		FileInputStream file = new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IPathConstant.EXCELPATH);
		workbook.write(fos);
	}

}

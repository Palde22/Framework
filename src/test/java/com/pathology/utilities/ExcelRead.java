package com.pathology.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	XSSFWorkbook wb;
	
	public ExcelRead(){
		
		File fPath= new File("./TestData/Test_Data.xlsx");
		
		try {
			FileInputStream fis= new FileInputStream(fPath);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Enable to read Excel file"+e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	

}

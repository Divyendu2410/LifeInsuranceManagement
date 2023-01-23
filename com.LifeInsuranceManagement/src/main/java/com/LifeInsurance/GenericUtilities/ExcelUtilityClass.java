package com.LifeInsurance.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilityClass {
	public String getExcelData(String sheetName,int rowNum, int colNum) throws Throwable {
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row rw = sh.getRow(rowNum);
	String data = rw.getCell(colNum).getStringCellValue();
	wb.close();
	return data;
}

public int getRowCount(String sheetName) throws Throwable {

	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	wb.close();
	return sh.getLastRowNum();
}

public void setExcelData(String sheetName, int rowNum, int colNum, String data) throws Throwable {
	
			FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row rw = sh.getRow(rowNum);
			Cell cel = rw.createCell(colNum);
			cel.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
			wb.write(fos);
			wb.close();
			
}

public HashMap<String, String> getList(String sheetName,int keyCol, int valueCol) throws Throwable {
	
	HashMap<String, String> hm = new HashMap<String, String>();
	for(int i=0;i<=getRowCount(sheetName);i++) {
		String key = getExcelData(sheetName, i, keyCol);
		String value = getExcelData(sheetName, i, valueCol);
		hm.put(key, value);
		
	}
	return hm;
}
	public Object[][] readMultipleSetOfData(String SheetName) throws Throwable
	{

	FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh=wb.getSheet(SheetName);
	int lastRow=sh.getLastRowNum()+1;
	int lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastRow][lastCell];
	for(int i=0;i<lastRow;i++) {
		for(int j=0;j<lastCell;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}




}


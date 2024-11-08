package com.java.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkingWithXLfile {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		DataIntoMap();
	}
	
	public static void DataIntoMap () throws InvalidFormatException, IOException {
		File f = new File("C:\\TestData\\CreatCompanyData.xlsx");
		FileInputStream file = new FileInputStream(f);
		System.out.println(f);
		
		XSSFWorkbook wk = new XSSFWorkbook(f);
		XSSFSheet st = wk.getSheetAt(1);
		XSSFRow row = st.getRow(0);
		XSSFCell cell = row.getCell(0);
		System.out.println(cell.toString());
		wk.close();
		
		
	}
	

}

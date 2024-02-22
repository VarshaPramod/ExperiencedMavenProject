package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleValueFromExcelSheet {

	public static void main(String[] args) throws IOException {
		
		singleRead();
		

	}			
		public static void singleRead() throws IOException
	{
		File file=new File("./TestData/TestData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("Login");
		int num_rows=sheet.getPhysicalNumberOfRows();
		int num_cell=sheet.getRow(0).getPhysicalNumberOfCells();
		Row row=sheet.getRow(0);
		Cell cell =row.getCell(0);
		System.out.println(cell.toString());
		System.out.println(num_cell);
		System.out.println(num_rows);

	}

}

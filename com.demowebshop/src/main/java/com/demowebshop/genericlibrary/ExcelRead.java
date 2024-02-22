package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead implements FrameworkConstants{
	
	public static String readStringvalue(String sheetName,int row,int cell) throws IOException
	{	
		File file=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
      return sheet.getRow(row).getCell(cell).toString();
	}
	public static double readNumericvalue(String sheetName,int row,int cell) throws IOException
	{	
		File file=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
      return sheet.getRow(row).getCell(cell).getNumericCellValue();
	}
	public static boolean readBooleanvalue(String sheetName,int row,int cell) throws IOException
	{	
		File file=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
      return sheet.getRow(row).getCell(cell).getBooleanCellValue();
	}
	public static Date readDatevalue(String sheetName,int row,int cell) throws IOException
	{	
		File file=new File(EXCEL_PATH);
		FileInputStream fis=new FileInputStream(file);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
      return sheet.getRow(row).getCell(cell).getDateCellValue();
	}
	
		public static String[][] multipleRead(String sheetName) throws IOException
	{
		File file=new File(EXCEL_PATH);
	    FileInputStream fis=new FileInputStream(file);//use to open the file
	    Workbook workbook = WorkbookFactory.create(fis);// make the file ready to read
	    Sheet sheet=workbook.getSheet(sheetName);  // we are into the sheet
	    int row_size=sheet.getPhysicalNumberOfRows();// returns the data occupied by all rows
	    int col_size=sheet.getRow(0).getPhysicalNumberOfCells();
	    
	
		String[][] data=new String[row_size-1][col_size];
		for(int i=0;i<row_size-1;i++)
		{
			for(int j=0;j<col_size;j++)
			{
				data[i][j]=sheet.getRow(i + 1).getCell(j).toString();
			
			}
		}
		
		return data;
	}

}

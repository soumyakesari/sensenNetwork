package commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility{
	
	/*public String getExcelData(String sheetName,int rowNum,int colNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(ApplicationConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		wb.close();
		return row.getCell(colNum).getStringCellValue();
	
	}*/
	
	public String getExcelData(String sheetName,int row, int col)
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(ApplicationConstants.excelFilePath));
			String data = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(col).toString();
			return data;
		}
		catch(Exception e)
		{
			return "";
		}
	}

}



 
 
 

 

	
	
	











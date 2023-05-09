package com.inetbanking.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CartDataProvider {
	
   public XSSFWorkbook wb;
	
	public  void createWorkBook() throws IOException
	{
	
     File excelFilePath=new File(".\\src\\test\\resources\\testData.xlsx");
		
		FileInputStream fis=new FileInputStream(excelFilePath);
		
	     wb=new XSSFWorkbook(fis);
	}
	

	@DataProvider(name="getProductDetails")
	public Object[][] getProductData() throws IOException {
		
		createWorkBook();
		XSSFSheet sheet=wb.getSheet("StorePage");
	//	XSSFSheet sheet=wb.getSheetAt(1);
		
	//	int rowCount=sheet.getPhysicalNumberOfRows();
		int rowCount= sheet.getLastRowNum();
		 rowCount= sheet.getPhysicalNumberOfRows();
		System.out.println("Rows:"+rowCount);
		
		int columnCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Columns:"+columnCount);
		
		Object[][] testData=new Object[rowCount-1][columnCount];
	   
		Map<Object,Object>dataMap=new HashMap<Object, Object>();
		for(int i=0;i<rowCount-1;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell cell=row.getCell(j);
				/*switch(cell.getCellType())
				{
				case 3:testData[i][j]=cell.getStringCellValue();
				break;
				case 2:testData[i][j]=cell.getNumericCellValue();
				break;
				}*/
			// int cellType= cell.getCellType();
			//	 dataMap.put(sheet.getRow(i).getCell(j).getStringCellValue(),cell.getStringCellValue());
			 if(cell.getCellType()==cell.CELL_TYPE_STRING)
			 {
				 testData[i][j]=cell.getStringCellValue(); 
				// dataMap.put(sheet.getRow(i).getCell(j).getStringCellValue(),cell.getStringCellValue());
			 }
			 else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			 {
				 testData[i][j]=cell.getNumericCellValue();
				// dataMap.put(sheet.getRow(i).getCell(j).getStringCellValue(),cell.getNumericCellValue());
			 }
			  //  testData[i][j]=dataMap;
				System.out.println("Values:"+testData[i][j]);
			//	testData[i][j]=row.getCell(j).getStringCellValue();
				
			}
			
			
		}
		return testData;
		
	}
}

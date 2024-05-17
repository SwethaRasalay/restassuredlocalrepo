package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
public FileInputStream fi;
public FileOutputStream fo;
public XSSFWorkbook workbook;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
public CellStyle style;
String path;
public XLUtility(String path) {
	this.path=path;
}


public int getRowCount(String sheetName) throws Exception {
	try {
	fi = new FileInputStream(path);
	workbook = new XSSFWorkbook(fi);
	sheet = workbook.getSheet(sheetName);
	int rowcount = sheet.getLastRowNum();
	workbook.close();
	fi.close();
	return rowcount;
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
		System.out.println("path not found");
	}
	return 0;
}
public int getCellCount(String sheetName,int rownum) throws Exception {
	fi = new FileInputStream(path);
	workbook= new XSSFWorkbook(fi);
	sheet = workbook.getSheet(sheetName);
	row = sheet.getRow(rownum);
	int cellcount = row.getLastCellNum();
	workbook.close();
	fi.close();
	
	return cellcount;
	
}public String getCellData(String sheetName,int rownum,int colnum)throws IOException{
	String data;
	fi = new FileInputStream(path);
	workbook = new XSSFWorkbook(fi);
	sheet = workbook.getSheet(sheetName);
	row = sheet.getRow(rownum);
	cell = row.getCell(colnum);
	DataFormatter formatter = new DataFormatter();
	try {
	data = formatter.formatCellValue(cell);	
	}catch(Exception e){
		data = "";
	}
	workbook.close();
	fi.close();
	return data;
	
}
}
//package api.utilities;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.poi.ss.formula.atp.Switch;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelReaddata {
//public static void main(String[] args) throws IOException {
//	File file = new File(".\\TestData\\TestDatasheet.xlsx");
//	FileInputStream fis = new FileInputStream(file);
//	XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	XSSFSheet sheet = workbook.getSheetAt(0);
//	int rowCount = sheet.getPhysicalNumberOfRows();
//	for(int i=0;i<rowCount;i++) {
//		XSSFRow row = sheet.getRow(i);
//		int cellCount = row.getPhysicalNumberOfCells();
//		for(int j=0;j<cellCount;j++) {
//			XSSFCell cell = row.getCell(j);
//			String cellvalue = getCellValue(cell);
//			System.out.print	("||" + cellvalue);
//		}
//		System.out.println();
//	}
//	workbook.close();
//	fis.close();
//}
//
//public static String getCellValue(XSSFCell cell) {
//	switch(cell.getCellType()){
//	case NUMERIC :
//		return String.valueOf(cell.getNumericCellValue());
//		
//	case STRING :
//		return cell.getStringCellValue();
//	case BOOLEAN :
//		return String.valueOf(cell.getBooleanCellValue());
//	default :
//		return cell.getStringCellValue();
//	}
//	
//}
//}

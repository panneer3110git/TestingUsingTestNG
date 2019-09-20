package dataprovider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	public static Object[][] data;

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook("./dataSheet/testdata.xlsx");
		XSSFSheet sheet = workbook.getSheet("testleaf");
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		XSSFRow row = sheet.getRow(lastRowNum);
		short lastCellNum = row.getLastCellNum();
		System.out.println(lastCellNum);
		
		data = new Object[lastRowNum][lastCellNum];
		for(int i=1;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
	}

}

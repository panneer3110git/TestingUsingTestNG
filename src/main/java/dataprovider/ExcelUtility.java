package dataprovider;

/*import java.io.File;*/
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	/*static File file = new File("");*/
	/*static String sheetName="";*/
	static Object[][] data;
	public static Object[][] readExcel() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook("./dataSheet/testdata.xlsx");
			XSSFSheet sheet = workbook.getSheet("testleaf");
			int lastRowNum = sheet.getLastRowNum();
			XSSFRow row = sheet.getRow(lastRowNum);
			short lastCellNum = row.getLastCellNum();
			data = new Object[lastRowNum][lastCellNum];
			for(int i=1;i<=lastRowNum;i++) {
				for(int j=0;j<lastCellNum;j++) {
					data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		workbook.close();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
}
}

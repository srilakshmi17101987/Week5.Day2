package Week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

	public static String[][] readdata(String filename) throws IOException {
		// Step 1: locate the workbbok or set up the path
		XSSFWorkbook wb = new XSSFWorkbook("./Data/Createlead.xlsx");
		// step 2: get in to the sheet1
		XSSFSheet ws = wb.getSheet(filename);
		// wb.getSheetAt(0);
        // step 3: get in to the rows
	//	XSSFRow row = ws.getRow(1);
		// step 4: get in to the cell
		//XSSFCell cell = row.getCell(0);
		// Step 5: To read the data
		//String text = cell.getStringCellValue();
	//	System.out.println(text);
	//	String phno=ws.getRow(1).getCell(3).getStringCellValue();
	//	 System.out.println(phno);
		int rowcount = ws.getLastRowNum(); // ws.getPhysicalNumberOfRows() this method includes header as well
	//	System.out.println(rowcount + " rows exist");
	//	System.out.println("******get all 1st row values****");
		// single forloop instad of above 3 lines of code
//		for (int i = 1; i <= rowcount; i++) {
//			String rowtext = ws.getRow(i).getCell(2).getStringCellValue();
//			System.out.println(rowtext);
//		}

	//	System.out.println("******go through the entire list**********");

		int cellcount = ws.getRow(0).getLastCellNum(); // index from 0,1,2,3
		System.out.println(cellcount);
		String[][] data = new String[rowcount][cellcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				String rowtext = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(rowtext);
				data[i-1][j] = rowtext;
			}
		}
		// last step to close wb dont forget ..this is important

		wb.close();
		return data;

	}

}

package cn.antigenmhc.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class RangeDataByPoi {

	public static Object[][] poiRangeData(String filePath, String sheetName) throws IOException {
		
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String extensionName = filePath.substring(filePath.indexOf("."));

		if (".xls".equals(extensionName)) {
			workbook= new HSSFWorkbook(inputStream);
		} else if (".xlsx".equals(extensionName)) {
		workbook= new XSSFWorkbook(inputStream);
		} else {
			System.out.println("文件格式不正确");
		}

		Assert.assertNotNull(workbook);
		Sheet sheet = workbook.getSheetAt(0);
		if (sheetName != null && !sheetName.isEmpty()) {
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				if (workbook.getSheetAt(i).getSheetName().equals(sheetName)) {
					sheet = workbook.getSheetAt(i);
					break;
				}
			}
		}

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		List<Object[]> records = new ArrayList<>();
		
    	for(int i=1;i<rowCount+1;i++){
    		Row row = sheet.getRow(i);
    		String[] fields = new String[row.getLastCellNum()];
    		for(int j = 0; j < row.getLastCellNum(); j++){
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				fields[j] = cell.getStringCellValue();
    		}
    		records.add(fields);
    		
    	}
    	
    	Object[][] results=new Object[records.size()][];
    	
    	for(int i = 0; i<records.size(); i++){
    		results[i] = records.get(i);
    	}
    	return results;
	}

	public static Object[][] poiRangeData(String filePath) throws IOException {
		return poiRangeData(filePath, null);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

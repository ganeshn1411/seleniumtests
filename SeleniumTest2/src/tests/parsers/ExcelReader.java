package tests.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

import tests.excels.*;

public class ExcelReader {
	public static Map<String, List<String>> readWorkBook(String book, String sheetName) throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File(book));
		Map<String, List<String>> dataMap = new HashMap<String, List<String>>();
		List<String> rowData;
		Sheet sheet = workbook.getSheet(sheetName);
		for(int j=0; j<sheet.getRows();j++) {
			rowData = new ArrayList<String>();
			Cell name = sheet.getCell(0,j);
			for (int i=1; i<sheet.getColumns();i++) {
				
				Cell value = sheet.getCell(i,j);
				System.out.println(value.getContents());
				rowData.add(value.getContents());
			}
			dataMap.put(name.getContents(), rowData);
		}
		System.out.println(dataMap);
		return dataMap;
	}
	
	public static String[] getSheets(String book) throws BiffException, IOException {
		System.out.println("Attempting to read from file in: "+new File(book).getCanonicalPath());
		Workbook workbook = Workbook.getWorkbook(new File(book));
		String[] sheetNames = workbook.getSheetNames();
		return sheetNames;
	}
}

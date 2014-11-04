package tests.parsers;

import java.util.HashMap;
import java.util.Map;

import jxl.*;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

import tests.excels.*;

public class ExcelReader {
	public static Map<String, String> readWorkBook(String book, String sheetName) throws BiffException, IOException {
		Workbook workbook = Workbook.getWorkbook(new File(book));
		Map<String, String> dataMap = new HashMap<String, String>();
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i=0; i<sheet.getRows();i++) {
			Cell name = sheet.getCell(0,i);
			Cell value = sheet.getCell(1,i);
			dataMap.put(name.getContents(), value.getContents());
		}
		return dataMap;
	}
	
	public static String[] getSheets(String book) throws BiffException, IOException {
		System.out.println("Attempting to read from file in: "+new File(book).getCanonicalPath());
		Workbook workbook = Workbook.getWorkbook(new File(book));
		String[] sheetNames = workbook.getSheetNames();
		return sheetNames;
	}
}

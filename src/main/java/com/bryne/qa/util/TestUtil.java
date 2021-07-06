package com.bryne.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.bryne.qa.base.BaseClass;

public class TestUtil extends BaseClass{
	public static long PAGE_LOAD_TIMEOUT = 20; 
	public static long IMPLICIT_LOAD_TIMEOUT = 10;
	
	public static String PERKS_SECTION_1_TITLE = "What is Power Perks?";
	public static int PERKS_SECTION_1_NO_OF_COL = 3;
	public static String BENEFITS_TITLE = "What are the Benefits?";
	public static String HOW_CAN_I_EARN_TITLE = "How Can I Earn?";
	public static String REWARDS_CATALOGUE = "Rewards Catalog";
	public static String FAQ = "FAQ";
	public static String SLAB_NAME = "Super Charged";
	public static String DASHBOARD_SCREEN_TITLE = "Transactions History";
	
	public static int NO_OF_ROWS_BEFORE_LOAD_MORE_CLICK = 3;
	public static int NO_OF_ROWS_AFTER_LOAD_MORE_CLICK = 12;
	
	public static int NO_OF_ROWS__IN_REWARDS_CATALOG = 8;
	
	public static String REWARDS_BUTTON_TEXT = "Redeem Points";
	public static String ORDER_PRODUCT_BUTTON_TEXT  = "Order Product";
	
	public static String FIRSTNAME = "Tomtesting";
	public static String LASTNAME = "Something";
	public static String EMAIL = "tom.testing@gmail.com"; 
	public static String MOBILE_PHONE = "919986576521";
	public static String BUSINESS_PHONE ="9901418152"; 
	public static String ADDRESS = "Sector 2 ,HSR Layout122131";
	public static String STATE = "Uttar Pradesh"; 
	public static String ZIP = "123456";
	public static String CITY = "Varanasi"; 
	public static String COUNTRY = "India";
	public static String TYPE_OF_THE_CUSTOMER = "";
	public static String JOINING_DATE = "March 23, 2021";
	public static String COMPANYS_CUSTOMER_NUMBER = "NAGU12345"; 
	public static String COMPANY_NAME = "CAP";
	
	public static int NO_OF_DISABLED_DETAILS = 5;
	public static String COUNTRY_AFTER_SELECT = "USA";
	public static String U_FIRSTNAME = "Oggy";
	public static String U_LASTNAME = "Testing";
	public static String U_BUSINESS_PHONE ="6388834374"; 
	public static String U_ADDRESS = "Sector 2 ,HSR Layout";
	public static String U_STATE = "Karnatka"; 
	public static String U_ZIP = "300001";
	public static String U_CITY = "Bangalore";
	
	public static String TESTDATA_SHEET_PATH = folderLocation + "/src/main/java/com/bryne/qa/testdata/BryneTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}

package com.ca.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ca.qa.base.TestBase;


public class TestUtil extends TestBase {
	public static long Page_load_Timeout=50;
	public static long Implicit_Wait=10;
	public static String TestData_Sheet_Path = "C:\\Users\\sarita.kumari\\eclipse-workspace\\MyFirtsProject\\src\\main\\java\\com\\ca\\qa\\testdata\\Testdatafile.xlsx";
	
	public void switchToFrame() {
		driver.switchTo().frame("");
	}
	
	public void clickOutsideToClosePopup() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 0)      // or some offset coordinates outside popup
		       .click()
		       .build()
		       .perform();

	}
	
	  public void waitForVisibility(WebElement element, int timeoutSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	         wait.until(ExpectedConditions.visibilityOf(element));
	    }
	 
	    public static Object[][] readExcelData(String sheetName) throws IOException {
	        try (FileInputStream fis = new FileInputStream(TestData_Sheet_Path);
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);
	            if (sheet == null) {
	                throw new IllegalArgumentException("Sheet \"" + sheetName + "\" not found");
	            }

	            int numRows = sheet.getLastRowNum();              // last row index (zero-based)
	            Row headerRow = sheet.getRow(0);
	            if (headerRow == null) {
	                throw new IllegalStateException("Header row (row 0) is missing");
	            }
	            int numCols = headerRow.getLastCellNum();        // number of columns

	            Object[][] data = new Object[numRows][numCols];

	            for (int i = 1; i <= numRows; i++) {             // start from 1 to skip header
	                Row row = sheet.getRow(i);
	                if (row == null) continue;
	                for (int j = 0; j < numCols; j++) {
	                    Cell cell = row.getCell(j);
	                    data[i - 1][j] = (cell == null) ? "" : cell.toString();
	                }
	            }
	            return data;
	        }
	    }


}
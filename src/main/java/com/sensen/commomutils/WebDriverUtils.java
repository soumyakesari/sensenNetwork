package com.sensen.commomutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains WebDriver specific libaraies , which used to handle Dropdowns ,Popups, Wait statements.
 * 
 *
 */

public class WebDriverUtils {

	/**
	 *  used to select the value from the dropDwon based on visible text
	 * @param element
	 * @param data
	 */
	public void select(WebElement element , String data) {
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}

	/**
	 *  used to select the value from the dropDwon based on index
	 * @param element
	 * @param data
	 */
	public void select(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public void waitForPageTitle(WebDriver driver , String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));

	}

	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForPageTitle(WebDriver driver , WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * 
	 * @param driver
	 */
	public void cancelAllert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * 
	 */
	public void captureScreenshot()
	{

		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./screenshots/");

		try {
			FileUtils.copyFile(srcFile, dstFile);
		} catch (IOException e) {

		}

	}

	//public String getExcelData(String sheetName , int rowNum , int colNum) throws Throwable {
		//FileInputStream fis = new FileInputStream(ApplicationConstants.excelFilePath);
		//Workbook wb = WorkbookFactory.create(fis);
		//Sheet sh = wb.getSheet(sheetName);
		//Row row = sh.getRow(rowNum);
		//wb.close();
		//return row.getCell(colNum).getStringCellValue();
	}



































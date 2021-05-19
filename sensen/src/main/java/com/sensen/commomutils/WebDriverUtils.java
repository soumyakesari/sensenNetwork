package com.sensen.commomutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains WebDriver specific libarraies , which used to handle Dropdowns ,Popups, Wait statements.
 * @author Soumya
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
	public void accpetAllert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAllert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	

}

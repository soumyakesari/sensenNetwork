package commonutils;

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
 * @author Soumya
 *
 */

public class WebDriverUtils {

	/**
	 *  used to select the value from the dropDwon based on visible text
	 * @param element
	 * @param data
	 */
	public void selectByText(WebElement element , String data) {
		Select sel = new Select(element);
		sel.selectByVisibleText(data);
	}

	/**
	 *  used to select the value from the dropDwon based on value
	 * @param element
	 * @param data
	 */
	public void selectByValue(WebElement element , String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 *  used to select the value from the dropDwon based on index
	 * @param element
	 * @param data
	 */
	public void selectByIndex(WebElement element , int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * Used to take screenshot
	 * @param driver
	 * @param methodName
	 * @throws IOException
	 */
	public String takeScreenShot(String methodName) throws IOException {
		EventFiringWebDriver event=new EventFiringWebDriver(BaseClass.driver);
		File src=event.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+methodName+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
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
}

	


























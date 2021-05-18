package sensen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sensen.commomutils.ApplicationConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TS_1 implements ApplicationConstants{

	@Test
	public void ValidationTest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ApplicationConstants.appUrl);
		driver.findElement(By.id("userName")).sendKeys(ApplicationConstants.userName);
		driver.findElement(By.id("passwordbox")).sendKeys(ApplicationConstants.password);
		driver.findElement(By.id("submitLogin")).click();

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Infringements']")));
		driver.findElement(By.xpath("//a[text()='Infringements']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Initial Review']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]/a[@class=\"text-bold\"]")).click();

		//Selecting location
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value=\"dropdownOffenceLocation\"]")).click();
		WebElement textLocation1 = driver.findElement(By.xpath("//select[@id=\"offenceLocationDrop\"]"));
		textLocation1.click();
		Select sel01 = new Select(textLocation1);
		sel01.selectByVisibleText("BALLIDU CLOSE,ELANORA");
		Thread.sleep(2000);

		//Selecting officer
		driver.findElement(By.xpath("//input[@value=\"offenceLocationDropDiv\"]")).click();
		WebElement textOfficer = driver.findElement(By.xpath("//select[@name=\"officerDropDownString\"]"));
		textOfficer.click();
		Select sel2 = new Select(textOfficer);
		sel2.selectByVisibleText("senbosadmin");
		Thread.sleep(2000);
		
		//Selecting plate read
		driver.findElement(By.xpath("//input[@id=\"maualEntryOcr\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"ocr\"]")).sendKeys("157XUW");
		Thread.sleep(2000);

		//Selecting Plate registration state
		driver.findElement(By.xpath("//input[@value=\"stateSelection\"]")).click();
		WebElement textState= driver.findElement(By.xpath("//select[@id=\"stateSelection\"]"));
		textState.click();
		Select sel4= new Select(textState);
		sel4.selectByVisibleText("QLD");
		Thread.sleep(2000);

		//Select Accept radio button
		driver.findElement(By.xpath("//input[@value='passRemarksId']")).click();
		driver.findElement(By.xpath("//input[@name=\"passedRemarksToSelect\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Acceptance Remarks\"]")).sendKeys("Alert Accepted");
		driver.findElement(By.id("save")).click();


		// Validation of success message
		String message = driver.findElement(By.xpath("//div[contains(text(), 'Operation Successful')]")).getText();
		String arr[] = message.split(":", 2);

		String updateMsg = arr[0];   
		
		Assert.assertEquals(updateMsg,"Operation Successful ","Initial Review not successful");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='logout.htm']//span")).click();
		Thread.sleep(3000);
		driver.close();




	}


}

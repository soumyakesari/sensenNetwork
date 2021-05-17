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

import io.github.bonigarcia.wdm.WebDriverManager;

public class TS_1 {

	@Test
	public void ValidationTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://snsqa01.snbos.com/webapp2/login.htm");
		driver.findElement(By.id("userName")).sendKeys("test-demo");
		driver.findElement(By.id("passwordbox")).sendKeys("testuser@123");
		driver.findElement(By.id("submitLogin")).click();

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Infringements']")));
		driver.findElement(By.xpath("//a[text()='Infringements']")).click();
		driver.findElement(By.xpath("//a[text()='Initial Review']")).click();
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/a[@class=\"text-bold\"]")).click();




		//Selecting location
		driver.findElement(By.xpath("//input[@value=\"dropdownOffenceLocation\"]")).click();
		WebElement textLocation1 = driver.findElement(By.xpath("//select[@id=\"offenceLocationDrop\"]"));
		textLocation1.click();
		Select sel01 = new Select(textLocation1);
		sel01.selectByVisibleText("BALLIDU CLOSE,ELANORA");

		//Selecting officer
		driver.findElement(By.xpath("//input[@value=\"offenceLocationDropDiv\"]")).click();
		WebElement textOfficer = driver.findElement(By.xpath("//select[@name=\"officerDropDownString\"]"));
		textOfficer.click();
		Select sel2 = new Select(textOfficer);
		sel2.selectByVisibleText("senbosadmin");

		//Selecting plate read
		driver.findElement(By.xpath("//input[@id=\"maualEntryOcr\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"ocr\"]")).sendKeys("KA01");

		//Selecting Plate registration state
		driver.findElement(By.xpath("//input[@value=\"stateSelection\"]")).click();
		WebElement textState= driver.findElement(By.xpath("//select[@id=\"stateSelection\"]"));
		textState.click();
		Select sel4= new Select(textState);
		sel4.selectByVisibleText("QLD");

		//Select Accept radio button
		driver.findElement(By.xpath("//input[@value='passRemarksId']")).click();
		driver.findElement(By.xpath("//input[@name=\"passedRemarksToSelect\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Acceptance Remarks\"]")).sendKeys("Alert Accepted");
		driver.findElement(By.xpath("//a[@id=\"save\"]")).click();



		//Validation

		//String actualTitle = "Alert Accepted and there are no more Alerts";
		//WebElement title = driver.findElement(By.xpath("//div[@id=\"opStatusMessage\"]"));
		//String tt = title.getText(); //infringements
		//Assert.assertEquals(actualTitle, tt);











	}


}

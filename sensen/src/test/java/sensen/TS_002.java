package sensen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TS_002 {
	
	@Test
	public void finalReviewValidation()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://snsqa01.snbos.com/webapp2/login.htm");
		driver.findElement(By.id("userName")).sendKeys("test-demo");
		driver.findElement(By.id("passwordbox")).sendKeys("testuser@123");
		driver.findElement(By.id("submitLogin")).click();

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Infringements']")));
		driver.findElement(By.xpath("//a[text()='Infringements']")).click();
		driver.findElement(By.xpath("//a[text()='Final Review']")).click();
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/a[@class=\"text-bold sn-ticket-id\"]")).click();
		
		//View Page
		
		 WebElement viewDropdown = driver.findElement(By.xpath("//select[@id=\"reasonCodesSelect\"]"));
		 viewDropdown.click();
		 Select sel = new Select(viewDropdown);
		 sel.selectByVisibleText("Confirmation of Offender / Contact details");
		 driver.findElement(By.xpath("//button[@id=\"snProceedWithReasonCode\"]")).click();
		 
		 //Infringment info page
		 driver.findElement(By.xpath("//input[@id=\"registerationNumber\"]")).sendKeys("100023");
		 driver.findElement(By.xpath("//input[@name='issueDateSplit']")).click();
		 
		 //OwnerInfo
		 driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("Jones");
		 driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("kones");
		 
		 //Owner Address Info
		 driver.findElement(By.xpath("//input[@name=\"streetName\"]")).sendKeys("Basavagudi");
		 driver.findElement(By.xpath("//input[@id=\"suburb\"]")).sendKeys("Bangalore");
		 driver.findElement(By.xpath("//input[@id=\"postcode\"]")).clear();
		 driver.findElement(By.xpath("//input[@id=\"postcode\"]")).sendKeys("1707");
		 driver.findElement(By.xpath("//input[@id=\"state\"]")).sendKeys("QLD");
		 driver.findElement(By.xpath("//input[@id=\"countryCode\"]")).sendKeys("AUS");
		
		 // click on pass button
		 driver.findElement(By.xpath("//input[@value=\"passRemarksId\"]")).click();
		 driver.findElement(By.xpath("//input[@value=\"passedRemarksManualEntry\"]")).click();
		 driver.findElement(By.xpath("//input[@id=\"tktPassRemarks\"]")).sendKeys("Accepted");
		 
		 //click on Accept button
		 driver.findElement(By.xpath("//button[@id=\"pass\"]")).click();
		 
		 
		 
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

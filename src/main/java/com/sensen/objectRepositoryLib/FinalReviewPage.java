package com.sensen.objectRepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sensen.commomutils.BaseClass;
import com.sensen.commomutils.WebDriverUtils;

public class FinalReviewPage extends BaseClass {

	
	WebDriverUtils wb =new WebDriverUtils();

	public FinalReviewPage(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//table/tbody/tr[1]/td[1]/a[@class=\"text-bold sn-ticket-id\"]")
	private WebElement AlertId;

	@FindBy(xpath="//select[@id=\"reasonCodesSelect\"]")
	private WebElement viewDropdown;

	@FindBy(xpath="//button[@id=\"snProceedWithReasonCode\"]")
	private WebElement proceedButton;

	@FindBy(xpath="//input[@id=\"registerationNumber\"]")
	private WebElement registraionNumber;

	@FindBy(xpath="//input[@name='issueDateSplit']")
	private WebElement dateCalender;

	@FindBy(xpath="//input[@id=\"firstName\"]")
	private WebElement firstName;

	@FindBy(xpath="//input[@id=\"lastName\"]")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name=\"streetName\"]")
	private WebElement streetNameTextField;
	
	@FindBy(xpath="//input[@id=\"suburb\"]")
	private WebElement suburbsnTextField;
	
	@FindBy(xpath="//input[@id=\"postcode\"]")
	private WebElement postcodeTextField;
	
	@FindBy(xpath="//input[@id=\"state\"]")
	private WebElement stateTextField;
	
	@FindBy(xpath="//input[@id=\"countryCode\"]")
	private WebElement countryTextField;
	
	@FindBy(xpath="//input[@value=\"rejectRemarksId\"]")
	private WebElement rejectRmarkTextField;
	
	@FindBy(xpath="//input[@id=\"manualEntryRejectionRemarks\"]")
	private WebElement manualEntryRejectionREmark;
	
	@FindBy(xpath="//input[@id=\"ticketRemarks\"]")
	private WebElement ticketREmarksTextField;
	
	@FindBy(xpath="//button[@id=\"reject\"]")
	private WebElement rejectButton;
	
	@FindBy(xpath="//div[@id='opStatusMessage']")
	private WebElement UpdateMsg;
	
	@FindBy(xpath="//span[@class='sn-alert-status']")
	private WebElement AlertStatus;
	
	@FindBy (xpath="//a[@href='logout.htm']//span")
	private WebElement LogoutButton;
	

	public void viewPage()
	{
		AlertId.click();
		viewDropdown.click();
		wb.select(viewDropdown, "Confirmation of Offender / Contact details");
		proceedButton.click();
	}

	public void infringementInfoPage()
	{
		registraionNumber.sendKeys("1003100");
		dateCalender.click();
	}

	public void OwnerInfo()
	{
		firstName.sendKeys("Ram");
		lastName.sendKeys("krishna");
	}

	public void AddressInfo()
	{
		streetNameTextField.sendKeys("Basavanagudi");
		suburbsnTextField.sendKeys("Bangalore");
		postcodeTextField.clear();
		postcodeTextField.sendKeys("584101");
		stateTextField.sendKeys("QLD");
		countryTextField.sendKeys("AUS");
		
	}
	
	public void clickOnRejectButton()
	{
		rejectRmarkTextField.click();
		manualEntryRejectionREmark.click();
		ticketREmarksTextField.sendKeys("Alert Rejected");
		rejectButton.click();
		driver.switchTo().alert().accept();
	}
	
	public void ValidateFinalMessage() throws InterruptedException
	{
		String updateMessage = UpdateMsg.getText();
		 Assert.assertEquals(updateMessage,"Operation Successful","Final Review Not successful");
		 
		 String alertStatus = AlertStatus.getText();
		 Assert.assertEquals(alertStatus,"Infringement Declined","Final Review Alert Status Update Not successful");
		 
		 Thread.sleep(3000);
		 LogoutButton.click();
		 Thread.sleep(3000);
	}

	
		 


	
	 








}

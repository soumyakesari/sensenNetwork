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

public class InitialReviewPage {

	WebDriver driver;
	WebDriverUtils wb =new WebDriverUtils();

	public InitialReviewPage(WebDriver driver){
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//table/tbody/tr[4]/td[1]/a[@class=\"text-bold\"]")
	private WebElement AlertId;

	@FindBy(xpath="//input[@value=\"dropdownOffenceLocation\"]")
	private WebElement LocationDropdownBtn;

	@FindBy(xpath="//select[@id=\"offenceLocationDrop\"]")
	private WebElement LocationSelectionTxtField;

	@FindBy(xpath="//input[@value=\"offenceLocationDropDiv\"]")
	private WebElement OfficerDropdownBtn;

	@FindBy(xpath="//select[@name=\"officerDropDownString\"]")
	private WebElement OfficerDropdownTxtField;

	@FindBy(xpath="//input[@id=\"maualEntryOcr\"]")
	private WebElement PlateReadDropdownBtn;

	@FindBy(xpath="//input[@name=\"ocr\"]")
	private WebElement PlateReadDropdownTxtField;

	@FindBy(xpath="//input[@value=\"stateSelection\"]")
	private WebElement PlateStateRegStatetDropdownBtn;

	@FindBy(xpath="//select[@id=\"stateSelection\"]")
	private WebElement PlateStateRegStatetDropdownTxtField;

	@FindBy(xpath="//input[@value='passRemarksId']")
	private WebElement PassRadioBtn;

	@FindBy(xpath="//input[@name=\"passedRemarksToSelect\"]")
	private WebElement PassRemarkTextField;

	@FindBy(xpath="//input[@placeholder=\"Acceptance Remarks\"]")
	private WebElement AcceptanceRemarkTextField;
	
	@FindBy(id="save")
	private WebElement AcceptButton;

	@FindBy(xpath="//div[@id=\"opStatusMessage\"]")
	private WebElement SuccessfulMessage;

	@FindBy(xpath="//a[@href='logout.htm']//span")
	private WebElement LogoutButton;


	public void clickOnAlertId()
	{
		AlertId.click();
	}
	public void selectLocation()
	{
		LocationDropdownBtn.click();
		LocationSelectionTxtField.click();
		wb.select(LocationSelectionTxtField, "BALLIDU CLOSE,ELANORA");
	}

	public void selectOfficer()
	{
		OfficerDropdownBtn.click();
		OfficerDropdownTxtField.click();
		wb.select(OfficerDropdownTxtField, "senbosadmin");
	}

	public void selectPlateRead()
	{
		PlateReadDropdownBtn.click();
		PlateReadDropdownTxtField.sendKeys("KA01");
	}

	public void selectPlateRegistrationState()
	{
		PlateStateRegStatetDropdownBtn.click();
		PlateStateRegStatetDropdownTxtField.click();
		wb.select(PlateStateRegStatetDropdownTxtField, "QLD");
	}

	public void clickOnAccept()
	{
		PassRadioBtn.click();
		PassRemarkTextField.click();
		AcceptanceRemarkTextField.sendKeys("Alert Accepted");
		AcceptButton.click();
	}

	public void validateSuccessfulMessage()
	{
		String message = SuccessfulMessage.getText();
		Assert.assertNotNull(message, "Initial Review not successful");
	}
	public void clickOnLogout() throws InterruptedException
	{
		Thread.sleep(3000);                                       // Added for the purpose of demo, to be removed later
		LogoutButton.click();
	}












}

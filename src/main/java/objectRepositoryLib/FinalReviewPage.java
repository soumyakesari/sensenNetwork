package objectRepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import commonutils.BaseClass;
import commonutils.ExcelUtility;
import commonutils.WebDriverUtils;

public class FinalReviewPage {

	WebDriver driver;
	WebDriverUtils wb =new WebDriverUtils();
	public ExcelUtility elib = new ExcelUtility();

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


	public void viewPage() throws Throwable
	{
		AlertId.click();
		viewDropdown.click();
		String view = elib.getExcelData("FinalReview", 2, 0);
		wb.selectByText(viewDropdown, view);
		proceedButton.click();
	}

	public void infringementInfoPage()
	{
		dateCalender.click();
	}

	public void ownerInfo() throws Throwable
	{
		String FN= elib.getExcelData("FinalReview", 2, 1);
		String LN= elib.getExcelData("FinalReview", 3, 1);
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
	}

	public void addressInfo() throws Throwable
	{
		String streetName = elib.getExcelData("FinalReview", 2, 2);
		String suburban = elib.getExcelData("FinalReview", 3, 2);
		String state = elib.getExcelData("FinalReview", 5, 2);
		String country = elib.getExcelData("FinalReview", 6, 2);

		streetNameTextField.sendKeys(streetName);
		suburbsnTextField.sendKeys(suburban);
		stateTextField.sendKeys(state);
		countryTextField.sendKeys(country);

	}

	public void clickOnRejectButton() throws Throwable
	{
		rejectRmarkTextField.click();
		manualEntryRejectionREmark.click();
		String alertRemark = elib.getExcelData("FinalReview", 2, 3);
		ticketREmarksTextField.sendKeys(alertRemark);
		rejectButton.click();
		driver.switchTo().alert().accept();
	}

	public void validateFinalMessage() throws InterruptedException
	{
		String updateMessage = UpdateMsg.getText();
		Assert.assertEquals(updateMessage,"Operation Successful","Final Review Not successful");

		String alertStatus = AlertStatus.getText();
		Assert.assertEquals(alertStatus,"Infringement Declined","Final Review Alert Status Update Not successful");

		Thread.sleep(3000);                        // Added for the purpose of demo, to be removed later
		LogoutButton.click();
		Thread.sleep(3000);                        // Added for the purpose of demo, to be removed later
	}















}

package com.sensen.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sensen.commomutils.BaseClass;

public class InfringementsPage extends BaseClass
{
	

	public InfringementsPage(WebDriver driver){ 
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Initial Review']")
	private WebElement InitialReviewMenu;
	
	@FindBy(xpath="//a[text()='Final Review']")
	private WebElement FinalReviewMenu;
	
	
	public void clickOnInitialReview()
	{
		InitialReviewMenu.click();
	}
	public void clickOnFinalReview()
	{
		FinalReviewMenu.click();
		
	}
}

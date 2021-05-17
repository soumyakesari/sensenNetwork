package com.sensen.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sensen.commomutils.BaseClass;

public class LoginPage extends BaseClass {


	public LoginPage(WebDriver driver){                                              
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userName")           
	private WebElement userNameTB;


	@FindBy(id="passwordbox")      
	private WebElement passwordTB;

	@FindBy(id="submitLogin")
	private WebElement loginButton;

	public WebElement getUserNameEdt() {   
		return userNameTB;
	}

	public WebElement getPasswordEdt() {
		return passwordTB;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}


	public void loginToApp(String username , String password) { 
		userNameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginButton.click();
	}

}

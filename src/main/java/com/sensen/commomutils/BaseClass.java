package com.sensen.commomutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public WebDriver driver =  new ChromeDriver();

	@BeforeClass
	public void Open()
	{
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ApplicationConstants.appUrl);
	}

	@AfterClass
	public void Close(){
		driver.close();
	}

}

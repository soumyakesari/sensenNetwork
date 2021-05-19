package com.sensen.commomutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriverUtils wb =new WebDriverUtils();
	public WebDriver driver = new ChromeDriver();
	
	@BeforeClass
	public void Open()
	{
		WebDriverManager.chromedriver().setup();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://snsqa01.snbos.com/webapp2/login.htm");
	}
	
	@AfterClass
	public void Close(){
		driver.close();
	}

}

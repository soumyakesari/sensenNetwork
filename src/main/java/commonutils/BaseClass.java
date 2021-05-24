package commonutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public static WebDriver driver;
	
	
	@BeforeClass
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(ApplicationConstants.appUrl);
	}

	@AfterClass
	public void close(){

		driver.close();
	}

}

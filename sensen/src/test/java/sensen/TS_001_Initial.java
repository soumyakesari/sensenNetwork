package sensen;

import org.openqa.selenium.WebDriver;

import com.sensen.commomutils.BaseClass;
import com.sensen.commomutils.WebDriverUtils;
import com.sensen.objectRepositoryLib.InfringementsPage;
import com.sensen.objectRepositoryLib.InitialReviewPage;
import com.sensen.objectRepositoryLib.LoginPage;

public class TS_001_Initial extends BaseClass{
	
	WebDriver driver;

	InitialReviewPage ir = new InitialReviewPage(driver);
	LoginPage lp= new LoginPage(driver);
	InfringementsPage ip= new InfringementsPage(driver);
	
	//Navigate to application
	
	//lp.loginToApp(test-demo,testuser@123)
	
	
	
	//click on infringement tab
	
	//ip.clickOnInfringements;
	
	
	
	//click on Initial Review submenu
	
	//ip.clickOnInitialReview;
	//wb.waitForPageTitle()
	
	
	

}

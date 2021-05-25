package sensen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import commonutils.ApplicationConstants;
import commonutils.BaseClass;
import commonutils.ExcelUtility;
import commonutils.WebDriverUtils;
import objectRepositoryLib.InfringementsPage;
import objectRepositoryLib.InitialReviewPage;
import objectRepositoryLib.LandingPage;
import objectRepositoryLib.LoginPage;

public class TS_Initial extends BaseClass implements ApplicationConstants{
	
	@Test
	public void initialReviewSuccessTest() throws Throwable {
		
		

		InitialReviewPage initReview = new InitialReviewPage(driver);
		LoginPage login= new LoginPage(driver);
		InfringementsPage infringe= new InfringementsPage(driver);
		LandingPage lp= new LandingPage(driver);
		

		
		//Navigate to application
		login.loginToApp(ApplicationConstants.userName,ApplicationConstants.password);

		//click on infringement tab
		lp.clickOnInfringements();

		//click on Initial Review submenu
		infringe.clickOnInitialReview();

		Thread.sleep(3000);                            // Added for the purpose of demo, to be removed later
		//click on AlertId
		initReview.clickOnAlertId();
	
		//Select Location
		initReview.selectLocation();
		
		//Select officer
		initReview.selectOfficer();
		
		//Select plate read
		initReview.selectPlateRead();
		
		//Select plate registration state
		initReview.selectPlateRegistrationState();
		
		//Select Accept Radio button
		initReview.clickOnAccept();
		
		Thread.sleep(3000);                          // Added for the purpose of demo, to be removed later
		//Validating successful message
		initReview.validateSuccessfulMessage();
		
		Thread.sleep(3000);                           // Added for the purpose of demo, to be removed later
		//Logout from the Application
		initReview.clickOnLogout();
		
		
		
		
		
	}


}

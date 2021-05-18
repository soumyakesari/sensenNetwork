package sensen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sensen.commomutils.ApplicationConstants;
import com.sensen.commomutils.BaseClass;
import com.sensen.commomutils.WebDriverUtils;
import com.sensen.objectRepositoryLib.InfringementsPage;
import com.sensen.objectRepositoryLib.InitialReviewPage;
import com.sensen.objectRepositoryLib.LandingPage;
import com.sensen.objectRepositoryLib.LoginPage;

public class TS_001_Initial extends BaseClass implements ApplicationConstants{

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
		
		//Validating successful message
		initReview.ValidateScccessfulMessage();
		
		//Logout from the Application
		initReview.clickOnLogout();
		
		
		
		
		
	}


}

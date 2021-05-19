package sensen;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sensen.commomutils.ApplicationConstants;
import com.sensen.commomutils.BaseClass;
import com.sensen.objectRepositoryLib.FinalReviewPage;
import com.sensen.objectRepositoryLib.InfringementsPage;
import com.sensen.objectRepositoryLib.InitialReviewPage;
import com.sensen.objectRepositoryLib.LandingPage;
import com.sensen.objectRepositoryLib.LoginPage;

public class TS_Final extends BaseClass implements ApplicationConstants{
	

	@Test
	public void FinalReviewSuccessTest() throws Throwable {

		LoginPage login= new LoginPage(driver);
		InfringementsPage infringe= new InfringementsPage(driver);
		LandingPage landing = new LandingPage(driver);
		FinalReviewPage finalPg = new FinalReviewPage(driver);

		//Navigate to application
		login.loginToApp(ApplicationConstants.userName,ApplicationConstants.password);

		//Click on Infringements tab
		landing.clickOnInfringements();

		//Click on Final review submenu
		infringe.clickOnFinalReview();

		//Click on Alert Id
		finalPg.viewPage();

		//Click on Infringement info page
		finalPg.infringementInfoPage();

		//Enter OwnerInfo
		finalPg.ownerInfo();

		//Enter Address info
		finalPg.addressInfo();

		//Click on Reject button
		finalPg.clickOnRejectButton();

		//Validation
		finalPg.validateFinalMessage();

		//Click on logout
		close();


	}
}
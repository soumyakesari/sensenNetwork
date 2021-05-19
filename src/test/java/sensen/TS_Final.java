package sensen;

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
		FinalReviewPage Final = new FinalReviewPage(driver);

		//Navigate to application
		login.loginToApp(ApplicationConstants.userName,ApplicationConstants.password);

		//Click on Infringements tab
		landing.clickOnInfringements();

		//Click on Final review submenu
		infringe.clickOnFinalReview();

		//Click on Alert Id
		Final.viewPage();

		//Click on Infringement info page
		Final.infringementInfoPage();

		//Enter OwnerInfo
		Final.OwnerInfo();

		//Enter Address info
		Final.AddressInfo();

		//Click on Reject button
		Final.clickOnRejectButton();

		//Validation
		Final.ValidateFinalMessage();

		//Click on logout
		Final.Close();


	}
}
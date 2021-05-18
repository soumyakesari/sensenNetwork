package sensen;

import org.testng.annotations.Test;

import com.sensen.commomutils.ApplicationConstants;
import com.sensen.commomutils.BaseClass;
import com.sensen.objectRepositoryLib.FinalReviewPage;
import com.sensen.objectRepositoryLib.InfringementsPage;
import com.sensen.objectRepositoryLib.InitialReviewPage;
import com.sensen.objectRepositoryLib.LandingPage;
import com.sensen.objectRepositoryLib.LoginPage;

public class TS_002_Final extends BaseClass implements ApplicationConstants{

	@Test
	public void FinalReviewSuccessTest() throws Throwable {

		LoginPage login= new LoginPage(driver);
		InfringementsPage infringe= new InfringementsPage(driver);
		LandingPage lp= new LandingPage(driver);
		FinalReviewPage Fp= new FinalReviewPage(driver);

		//Navigate to application
		login.loginToApp(ApplicationConstants.userName,ApplicationConstants.password);

		//Click on Infringements tab
		lp.clickOnInfringements();

		//Click on Final review submenu
		infringe.clickOnFinalReview();
		
		//Click on Alert Id
		Fp.viewPage();
		
		//Click on Infringement info page
		Fp.infringementInfoPage();
		
		//Enter OwnerInfo
		Fp.OwnerInfo();
		
		//Enter Address info
		Fp.AddressInfo();
		
		//Click on Reject button
		Fp.clickOnRejectButton();
		
		//Validation
		Fp.ValidateFinalMessage();
		
		//Click on logout
		Fp.Close();


	}
}
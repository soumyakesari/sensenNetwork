package commonutils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass {
	
	public ExtentReports report;
	public ExtentTest test;
	public void onFinish(ITestContext arg0) {					
		// TODO Auto-generated method stub				
		report.flush();	
	}		


	public void onStart(ITestContext arg0) {					
		// TODO Auto-generated method stub


	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
		// TODO Auto-generated method stub				

	}		


	public void onTestFailure(ITestResult result) {					
		// TODO Auto-generated method stub	
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		WebDriverUtils wUtiles=new WebDriverUtils();
		try {
			String	path=wUtiles.takeScreenShot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}		


	public void onTestSkipped(ITestResult result) {					
		// TODO Auto-generated method stub				
	}	
}


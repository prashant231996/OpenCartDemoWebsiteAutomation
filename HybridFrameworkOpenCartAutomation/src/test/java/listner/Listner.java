package listner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.inetbanking.testcases.TestBase;
import com.inetbanking.utilities.ExtentReporter;
import com.inetbanking.utilities.ScreenShot;

public class Listner extends TestBase implements ITestListener{
  //  WebDriver driver;
//	ExtentReports extentReport=ExtentReporter.getExtentReports();
//	ExtentTest extentTest;
//	ThreadLocal<ExtentTest>extentTestThread=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		System.out.println(">>>In Listner");
		extentTest=extentReport.createTest(result.getName());
		//extentTestThread.set(extentTest);
		setExtentTest(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		getExtentTest().log(Status.PASS, result.getName()+"Passed successfully..");
	}

	public void onTestFailure(ITestResult testResult) {
		getExtentTest().fail(testResult.getThrowable());
		getExtentTest().log(Status.FAIL, testResult.getName()+"Test Case got failed");
	//	     driver=null;
			String testName=testResult.getName();
			//driver=getDriver();
			try {
	//			driver = (WebDriver)testResult.getTestClass().getRealClass().getDeclaredField("driver").get(testResult.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 String screenShotFilePath=ScreenShot.getScreenShot(driver,testName);
			 try {
				 getExtentTest().addScreenCaptureFromPath(screenShotFilePath, testName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		getExtentTest().log(Status.SKIP, "Test Cases Skipeed succesffully..");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		//driver.quit();
		extentReport.flush();
	}

}

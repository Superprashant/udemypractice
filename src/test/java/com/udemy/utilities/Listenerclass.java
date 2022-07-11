package com.udemy.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.udemy.test.Basetest;

public class Listenerclass extends Basetest implements ITestListener {


	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String testcasename=result.getMethod().getMethodName();

				try {
					driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

		screen(testcasename, driver);
	
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
	

}

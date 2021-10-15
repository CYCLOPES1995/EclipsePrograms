package com.Vtiger.GenericsUtils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class TestListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		//EventFiringWebDriver takeScreenShot = new EventFiringWebDriver(BaseClassUtility.staticDriver);
		TakesScreenshot t =(TakesScreenShot())driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+result.getMethod().getMethodName()+JavaUtility.getCurrentDate()+".PNG");
		try {
			Files.copy(source, dest);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		EventFiringWebDriver takeScreenShot = new EventFiringWebDriver(BaseClassUtility.staticDriver);
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./SkippedTestCase/"+result.getMethod().getMethodName()+JavaUtility.getCurrentDate()+".PNG");
		try {
			Files.copy(source, dest);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
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

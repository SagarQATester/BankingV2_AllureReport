 package com.qa.test.allureReports;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;




public class AllureListener implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment
	public byte[] saveScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}



	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in on Start method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BaseClass.getDriver());
		try {
			FileUtils.deleteDirectory(new File("target/allure-results"));
			FileUtils.deleteDirectory(new File("allure-report"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}


	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in on Finish method and Closed Browser" + iTestContext.getName());		

	    executeShellCmd(System.getProperty("user.dir") +"\\AllureReport_History.bat");

		File source = new File(System.getProperty("user.dir") +"\\allure-report");
		File dest = new File(System.getProperty("user.dir") +"\\target\\allure-results");
		try {
		    FileUtils.copyDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		//executeShellCmd(System.getProperty("user.dir") +"\\AllureReport.bat");

	}

	
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in on Test Start method " + getTestMethodName(iTestResult) + " start");
	}

	
	public void onTestSuccess(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver driver = BaseClass.getDriver();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case: Passed" );//+ getTestMethodName(iTestResult)
			saveScreenShot(driver);
		}
		saveTextLog(" Test case passed -screenshot taken!");//getTestMethodName(iTestResult) + 
		System.out.println(" Test case passed -screenshot taken!");//+ getTestMethodName(iTestResult) +
		driver.close();

	}

	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		Object testClass = iTestResult.getInstance();
		WebDriver driver = BaseClass.getDriver();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveFailureScreenShot(driver);
		}
		saveTextLog(" Test case failed and screenshot taken!");	//getTestMethodName(iTestResult) + 
		driver.close();
	}



	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
	
	public static void generateAllureReport() {

	}

	public static void executeShellCmd(String shellCmd) {
	    try {
	        Process process = Runtime.getRuntime().exec(shellCmd);
	        process.waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error in Executing the command " + shellCmd);
	    }
	}

	
	

}

package com.qa.test.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.test.allureReports.AllureListener;
import com.qa.test.allureReports.BaseClass;
import com.qa.test.reusableComponents.CommonMethods;

import io.qameta.allure.Step;




public class LoginPage {

	WebDriver driver;
	
	public LoginPage() 
	{
		this.driver=BaseClass.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (name="uid")
	WebElement uId;
	
	@FindBy (name="password")
	WebElement pass;
	
	@FindBy (name="btnLogin")
	WebElement loginButton;
	
	@FindBy (name="btnReset")
	WebElement resetButton;
	
	@Step("Enter User ID")
	public void enterUserID(String id)
	{
		try 
		{
			CommonMethods.waitForElement(driver, "User ID", uId);
			CommonMethods.sendKeys_custom(uId, "User ID", id);
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			AllureListener.saveTextLog("Not able to enter text in User Id field ");
			Assert.fail("Not able to enter text in User Id field ");
		}
	}
	@Step("Enter User Password")
	public void enterUserPassword(String passWord)
	{
		try 
		{
			CommonMethods.waitForElement(driver, "Password", pass);
			CommonMethods.sendKeys_custom(pass, "Password", passWord);
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			AllureListener.saveTextLog("Not able to enter password ");
			Assert.fail("Not able to enter password ");
		}
	}
	
	@Step("Click on Login button")
	public void clickOnLoginButoon()
	{
		try 
		{
			CommonMethods.waitForElement(driver, "Submit", loginButton);
			CommonMethods.click_custom(loginButton, "Submit");
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			AllureListener.saveTextLog("Not able to click on submit button ");
			Assert.fail("Not able to click on submit button ");
		}
	}
	
	@Step("verify whether the user able to navigate on Home Page")
	public void verifyUserNavigateOnHomePage() 
	{
		try
		{
		String pageTitle=driver.getTitle();
		String actualtitle="Guru99 Bank Manager HomePage";
		if(pageTitle.equals(actualtitle))
		{
			Assert.assertTrue(true);
			AllureListener.saveTextLog("User successfully navigate on Home Page ");
			
		}
		else
		{
			AllureListener.saveTextLog("User not able to navigate on HomePage ");
			Assert.fail("User not able to navigate on HomePage ");
			Assert.assertTrue(false);
		
		}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
	}
	
	public void loginIntoApplication(String cid,String cpass)
	{
		enterUserID(cid);
		enterUserPassword(cpass);
		clickOnLoginButoon();
	}
	
	@Step("Test case Passed")
	public void testCasePassed()
	{
		Assert.assertTrue(true);
	}
	
	
	
}

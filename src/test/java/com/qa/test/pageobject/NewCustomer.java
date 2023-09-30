package com.qa.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.test.allureReports.AllureListener;
import com.qa.test.allureReports.BaseClass;
import com.qa.test.reusableComponents.CommonMethods;


public class NewCustomer 
{

	WebDriver driver;
	
	@FindBy (xpath="//a[text()='New Customer']")
	WebElement newCustomer;	
	@FindBy (name="name")
	WebElement customerName;
	@FindBy (xpath="//input[@value='m']")
	WebElement male;
	@FindBy (xpath="//input[@value='f']")
	WebElement female;
	@FindBy (name="dob")
	WebElement birthDate;
	@FindBy (name="addr")
	WebElement address;
	@FindBy (name="city")
	WebElement city;
	@FindBy (name="state")
	WebElement state;	
	@FindBy (name="pinno")
	WebElement pinNo;
	@FindBy (name="telephoneno")
	WebElement mobileNo;	
	@FindBy (name="emailid")
	WebElement email;
	@FindBy (name="password")
	WebElement pass;
	@FindBy (name="sub")
	WebElement submit;
	@FindBy (name="res")
	WebElement reset;
	
	public NewCustomer() 
	{
		// TODO Auto-generated constructor stub
		this.driver=BaseClass.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	public void clickToNewCutomerTab()
	{
		try 
		{
			CommonMethods.click_custom(newCustomer, "New Customer");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			AllureListener.saveTextLog("Not able to click on New Customer Button ");
			Assert.fail("Not able to click on New Customer Button ");
		}
		
	}
	
	public void enterCutomerName(String custName)
	{
		try 
		{
			CommonMethods.sendKeys_custom(customerName, "Cutomer Name", custName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void selectGender(String gender)
	{
		try 
		{
			if(gender.equalsIgnoreCase("male")) 
			{
			CommonMethods.click_custom(male, "Gender");;
			}
			else
			{
				CommonMethods.click_custom(female, "Gender");;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void enterDateOfBirth(String dob)
	{
		try 
		{
			CommonMethods.sendKeys_custom(birthDate, "DOB", dob);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void enterCutomerAddress(String custAddress)
	{
		try 
		{
			CommonMethods.sendKeys_custom(address, "Address", custAddress);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void enterCutomerCity(String custCity)
	{
		try 
		{
			CommonMethods.sendKeys_custom(city, "City", custCity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void enterCutomerState(String custState)
	{
		try 
		{
			CommonMethods.sendKeys_custom(state, "State", custState);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
	public void enterCutomerPIN(String pin)
	{
		try 
		{
			CommonMethods.sendKeys_custom(pinNo, "PinCode", pin);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void enterCutomerMobileNumber(String mobNo)
	{
		try 
		{
			CommonMethods.sendKeys_custom(mobileNo, "MobileNo", mobNo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void enterCutomerEmailID(String eid)
	{
		try 
		{
			CommonMethods.sendKeys_custom(email, "Email ID", eid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void enterEmailPassword(String epass)
	{
		try 
		{
			CommonMethods.sendKeys_custom(pass, "Email ID", epass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void clickToSubmit()
	{
		try 
		{
			CommonMethods.click_custom(submit, "Submit");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void clickToResetButton()
	{
		try 
		{
			CommonMethods.click_custom(reset, "Reset");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

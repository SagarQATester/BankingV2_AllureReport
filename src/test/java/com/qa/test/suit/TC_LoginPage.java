package com.qa.test.suit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.test.allureReports.AllureListener;
import com.qa.test.allureReports.BaseClass;
import com.qa.test.pageobject.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListener.class})

public class TC_LoginPage extends BaseClass{

	@Severity(SeverityLevel.NORMAL)
	@Description("To verify the user is able to Login and navigate on hom page")
	@Test(enabled=true,priority=1)
	public void validateWhetherUserAbleToLogin()
	{
		BaseClass baseclass = new BaseClass();
		baseclass.initialize_driver();
		LoginPage loginPage= new LoginPage();
		loginPage.enterUserID("mngr530396");
		loginPage.enterUserPassword("petAjyh");
		loginPage.clickOnLoginButoon();
		loginPage.verifyUserNavigateOnHomePage();
	}
}

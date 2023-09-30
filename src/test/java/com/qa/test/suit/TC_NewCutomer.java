package com.qa.test.suit;

import org.testng.annotations.Test;

import com.qa.test.allureReports.BaseClass;
import com.qa.test.pageobject.LoginPage;
import com.qa.test.pageobject.NewCustomer;

public class TC_NewCutomer extends BaseClass {
	@Test
	public void verifyWhetherTheMangerAbleToAddNewCustomer() throws InterruptedException

	{
		BaseClass baseclass = new BaseClass();
		baseclass.initialize_driver();
		LoginPage loginPage = new LoginPage();
		NewCustomer newCust = new NewCustomer();

		loginPage.enterUserID("mngr530396");
		loginPage.enterUserPassword("petAjyh");
		loginPage.clickOnLoginButoon();
		newCust.clickToNewCutomerTab();
		Thread.sleep(5000);
		newCust.enterCutomerName("Sagar");
		newCust.selectGender("male");
		newCust.enterDateOfBirth("02121995");
		newCust.enterCutomerAddress("Navi mumbai");
		newCust.enterCutomerCity("Navi Mumbai");
		newCust.enterCutomerState("Maharastra");
		newCust.enterCutomerPIN("414141");
		newCust.enterCutomerMobileNumber("9898989898");
		newCust.enterCutomerEmailID("sssk@gmail.com");
		newCust.enterEmailPassword("scnxvdsgcv");
	//	newCust.clickToSubmit();
		

	}
}

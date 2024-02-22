package com.demowebshop.testscripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.genericlibrary.Base_Test;
import com.demowebshop.genericlibrary.ExcelRead;
import com.demowebshop.pomRepo.HomePage;
import com.demowebshop.pomRepo.RegisterPage;
import com.demowebshop.pomRepo.WelcomePage;

public class RegisterTest extends Base_Test {
	
	@Test(dataProvider="registerData")
	public void TC_Register_001(String gender,String firstname,String lastname,String email,String password,String confirmpassword)
	{
		WelcomePage welcomePage=new WelcomePage(driver);
		welcomePage.clickRegisterLink();
		RegisterPage registerPage=new RegisterPage(driver);
		if(gender.equalsIgnoreCase("M"))
		{
			registerPage.clickMaleGenderRadioButton();
		}
		else if (gender.equalsIgnoreCase("F"))
		{
			registerPage.clickFemaleGenderRadioButton();
		}
		else
		{
			Reporter.log("Gender is not valid",true);
		}
		registerPage.enterFirstName(firstname);
		registerPage.enterLastName(lastname);
		registerPage.enterEmail(email);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(confirmpassword);
		registerPage.clickRegisterButton();

		HomePage homePage=new HomePage(driver);
		try {
		softAssert.assertTrue(homePage.getLogoutLink().isDisplayed());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		 Reporter.log("User not registered");
		}
	}
		
		@DataProvider(name="registerData")
		public String[][] registerDataProvider() throws IOException
		{
			return ExcelRead.multipleRead("Register");
		}
		
	}


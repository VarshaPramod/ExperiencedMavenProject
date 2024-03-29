package com.demowebshop.testscripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.genericlibrary.Base_Test;
import com.demowebshop.genericlibrary.ExcelRead;
import com.demowebshop.pomRepo.BooksPage;
import com.demowebshop.pomRepo.HomePage;
import com.demowebshop.pomRepo.LoginPage;
import com.demowebshop.pomRepo.RegisterPage;
import com.demowebshop.pomRepo.ShoppingCartPage;
import com.demowebshop.pomRepo.WelcomePage;




public class LoginTest  extends Base_Test{
	@Test(dataProvider="loginData")
	public void TC_Login_001(String email,String password) throws InterruptedException
	{
		WelcomePage welcomePage =new WelcomePage(driver);
		welcomePage.clickLogin();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();

		HomePage homePage=new HomePage(driver);
		try {
			softAssert.assertTrue(homePage.getLogoutLink().isDisplayed());
	    }catch(Exception e) {
		e.printStackTrace();
		Reporter.log("User not logged in");
	   }
	}
	
	@DataProvider(name="loginData")
	public String[][] addTocartDataProvider() throws IOException
	{
		return ExcelRead.multipleRead("Login");
	}
	
}

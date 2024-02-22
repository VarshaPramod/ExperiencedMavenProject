package com.demowebshop.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demowebshop.genericlibrary.Base_Test;
import com.demowebshop.genericlibrary.ExcelRead;
import com.demowebshop.pomRepo.BooksPage;
import com.demowebshop.pomRepo.HomePage;
import com.demowebshop.pomRepo.LoginPage;
import com.demowebshop.pomRepo.ShoppingCartPage;
import com.demowebshop.pomRepo.WelcomePage;

public class AddToCartTest extends Base_Test{
	@Test(dataProvider="addToCart")
	
	public void TC_ShoppingCart_001(String email,String password)
	{
		
		WelcomePage welcomePage =new WelcomePage(driver);
		welcomePage.clickLogin();
		
		test.log(Status.INFO, "Loin page is Displayed");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		HomePage homePage=new HomePage(driver);
		try {
			softAssert.assertTrue(homePage.getLogoutLink().isDisplayed());
		if(homePage.getLogoutLink().isDisplayed()) {
			
			test.log(Status.PASS, "User is successfully logged in");
			welcomePage.clickHeaderBooksLink();
			BooksPage booksPage=new BooksPage(driver);
			booksPage.clickcomputingAndInternetAddtoCartButton();
			Thread.sleep(TIMEOUT);
			booksPage.clickBannerShoppingCartLink();
			
			ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
			//shoppingCartPage.getShoppingCartFirstRowProductName();
			softAssert.assertTrue(shoppingCartPage.getShoppingCartFirstRowProductName().getText().contains("Computing and Internet"));	
			test.log(Status.PASS, "Product is Added to cart");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "User is not logged in and product is not added to cart");//test.fail(MediaEntityBuilder.createScreenCaptureFromPath(takesSreenshotOfPage(driver)));
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(takeSreenshotOfPage(driver)).build());
			Reporter.log("User not logged in");
		}
		
		
		
	}
	

@DataProvider(name="addToCart")
public String[][] addTocartDataProvider() throws IOException
{
	return ExcelRead.multipleRead("AddToCart");
}
}

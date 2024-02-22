package com.demowebshop.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends Base_Page {

	public BooksPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[text()='Computing and Internet']/parent::h2/..//input")
	private WebElement computingAndInternetAddtoCartButton;
	
	public void clickcomputingAndInternetAddtoCartButton()
	{
		computingAndInternetAddtoCartButton.click();
		
	}
	
	@FindBy(xpath = "//a[text()='Shopping cart']")
	private WebElement shoppingCartLinkAfterAddingProductToCart;
	
	public void clickBannerShoppingCartLink()
	{
		shoppingCartLinkAfterAddingProductToCart.click();
		
	}
	
	
	/*
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginLink;
	
	public void clickLoginLink() {
		loginLink.click();
	}
	@FindBy(id="Email")
	WebElement emailTextField;
	
	public void enterEmail(String email)
	{
		emailTextField.sendKeys(email);
	}
	
	@FindBy(id="Password")
	WebElement passwordTextField;
	
	public void enterPassword(String password)
	{
		passwordTextField.sendKeys(password);
	}

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	@FindBy(linkText = "BOOKS")
	WebElement booksLink;
	
	public void clickBooksLink()
	{
		booksLink.click();
	}
	
	@FindBy(xpath = "(//a[text()='Computing and Internet'])[2]")
	WebElement productLink;
	
	public void clickProductLink()
	{
		productLink.click();
		
	}
	
	@FindBy(xpath = "//input[@id='add-to-cart-button-13']")
	WebElement addToCartButton;
	
	public void clickAddToCartButton()
	{
		addToCartButton.click();
		
	}
	*/
	
	

}

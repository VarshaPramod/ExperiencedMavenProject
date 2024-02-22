package com.demowebshop.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base_Page{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	/*@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutButton;
	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}*/
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
	private WebElement loggedInEmailIDLink1;
	
	public void clickEmailIDAccount1()
	{
		loggedInEmailIDLink1.click();
	}

	public WebElement getLoggedInEmailIDLink() {
		return loggedInEmailIDLink1;
	}

	public void setLoggedInEmailIDLink(WebElement loggedInEmailIDLink) {
		this.loggedInEmailIDLink1 = loggedInEmailIDLink;
	}
	
	@FindBy(partialLinkText ="Log out")
	private WebElement logoutLink;
	
	public void clickLogoutLink()
	{
		logoutLink.click();
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public void setLogoutLink(WebElement logoutLink) {
		this.logoutLink = logoutLink;//here setters is added by default no need here,setters are generated with getters method
	}
}

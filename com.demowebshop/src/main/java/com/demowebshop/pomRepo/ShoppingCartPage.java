package com.demowebshop.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Base_Page {
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//table[@class='cart']/tbody/tr[1]/td[3]/a")
	private WebElement  shoppingCartFirstRowProductName;

	public WebElement getShoppingCartFirstRowProductName() {
		return shoppingCartFirstRowProductName;
	}

	public void setShoppingCartFirstRowProductName(WebElement shoppingCartFirstRowProductName) {
		this.shoppingCartFirstRowProductName = shoppingCartFirstRowProductName;
	}
//here changes the address of the product
	/*
	@FindBy(xpath="(//a[@href='/cart'])[1]")
	WebElement shoppingCartLink;
	
	public void clickShoppingCartLink()
	{
		shoppingCartLink.click();
	}*/
	
	/*@FindBy(xpath = "//table/tbody/tr[2]/td[3]/a")
	private WebElement  secondRowProductName;

	public WebElement getSecondRowProductName() {
		return secondRowProductName;
	}

	public void setSecondRowProductName(WebElement secondRowProductName) {
		this.secondRowProductName = secondRowProductName;
	}
	@FindBy(xpath = "//table/tbody/tr[3]/td[3]/a")
	private WebElement  thirdRowProductName;

	public WebElement getThirdRowProductName() {
		return thirdRowProductName;
	}

	public void setThirdRowProductName(WebElement thirdRowProductName) {
		this.thirdRowProductName = thirdRowProductName;
	}
	*/
	
	
	
}

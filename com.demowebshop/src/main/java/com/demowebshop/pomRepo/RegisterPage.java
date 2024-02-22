package com.demowebshop.pomRepo;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Base_Page {
	
	public  RegisterPage (WebDriver driver)
	{
		super(driver);
	}
	

	

@FindBy(id ="gender-male")
private WebElement maleGenderRadioButton;

public void clickMaleGenderRadioButton()
{
	maleGenderRadioButton.click();
}

@FindBy(id ="gender-female")
private WebElement femaleGenderRadioButton;

public void clickFemaleGenderRadioButton()
{
	femaleGenderRadioButton.click();
}


@FindBy(id ="FirstName")
private WebElement firstNameTextField;

public void enterFirstName(String firstname)
{
	firstNameTextField.sendKeys(firstname);
}


@FindBy(id ="LastName")
private WebElement LastNameTextField;

public void enterLastName(String LastName)
{
	LastNameTextField.sendKeys(LastName);
}
@FindBy(id ="Email")
private WebElement EmailTextField;

public void enterEmail(String Email)
{
	EmailTextField.sendKeys(Email);
}

@FindBy(id ="Password")
private WebElement PasswordTextField;

public void enterPassword(String Password)
{
	PasswordTextField.sendKeys(Password);
}

@FindBy(id ="ConfirmPassword")
private WebElement ConfirmPasswordTextField;

public void enterConfirmPassword(String ConfirmPassword)
{
	ConfirmPasswordTextField.sendKeys(ConfirmPassword);
}

@FindBy(id ="register-button")
private WebElement registerButton;

public void clickRegisterButton()
{
	registerButton.click();
}

}

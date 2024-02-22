package com.demowebshop.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FrameworkLibrary implements  FrameworkConstants{
	
 public Actions action;
 public WebDriverWait wait;
 public SoftAssert softAssert;
 public ExtentSparkReporter sparkReporter;
 public ExtentReports reports;
 public ExtentTest test;
 public String testMethodName;



	public void selectClass(WebElement dropdown,String option)
	{
		Select select=new Select(dropdown);
		int counter=0;
		try {
			int indexvalue=Integer.parseInt(option);
			select.selectByIndex(indexvalue);
			counter++;
		}
		catch(Exception e)
		{
			System.out.println("Not and Index value");	
		}
		if (counter==0)
		{
			try {
				select.selectByValue(option);
			}
			catch(Exception e){
				select.selectByVisibleText(option);
			}
			
	
			
		}
		
		
		
	}
	public String takeSreenshotOfPage(WebDriver driver) 
   {
		TakesScreenshot ts =(TakesScreenshot)driver;
		String filePath=SCREENSHOT_PATH+name()+".png";
		File des=new File(filePath);
		File temp=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(temp,des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return "."+filePath;
	}

	
	public void takeScreenshotOfElement(WebElement element)
	{
		File temp=element.getScreenshotAs(OutputType.FILE);
		File des=new File(SCREENSHOT_PATH+name()+".png");
		try {
			FileHandler.copy(temp,des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String name()
	{
		LocalDateTime datTime=LocalDateTime.now();
		String fileName=datTime.toString().replaceAll(":","-");
		return fileName;
	}
	
	
	
	public String getPropertyValue(String key) throws IOException {
		File file =new File(PROPERTIES_PATH);
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
	    prop.load(fis);
		return  prop.getProperty(key);	
	}
	
	public void initObjects(WebDriver driver)
	{
		action=new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
		softAssert=new SoftAssert();
	}
}
package com.cucumber.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static WebDriver driver;
	public static WebDriver getDriver(String browserName) throws Exception {
		try 
		{
		if(browserName=="chrome")
		{
			System.setProperty("webdriver.chrome.driver","F:\\New folder\\Workspace\\maven\\driver\\chromedriver.exe" );
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
		return driver;
	}
	public void getUrl(String url) {
		driver.get(url);
	}
	public void mouseOver(WebElement element) {
		Actions ac=new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public void Scroll(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);

	}
	public void setText(WebElement element, String value) throws Exception {
				element.sendKeys(value);
			}
		
	public void explicitWait(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public boolean elementIsEnabled(WebElement element) {
		boolean Enabled = elementIsEnabled(element);
		return Enabled;
	}
	public boolean elementIsDisplayed(WebElement element) {
		boolean Displayed = elementIsDisplayed(element);
		return Displayed;
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void select(WebElement element, String i) {
		Select s=new Select(element);
		
			s.selectByValue(i);
		
	}
	public void click(WebElement element) {
		element.click();
	}

}

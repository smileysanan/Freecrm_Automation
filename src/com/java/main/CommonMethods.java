package com.java.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	static WebDriver driver;

	public void openBrowser_TetCase1(String browserName, String url) throws Exception {
		switch (browserName.trim().toLowerCase().toString()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("launch with chrome");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("launch with firefox");
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("launch with ede");
		default:
			System.out.println("launch with invalid driver");
			break;
		}
		driver.get(url);
		String ActualTittle = driver.getTitle();
		if (ActualTittle.equals("Cogmento CRM")) {
			System.out.println("getting current page:"+ActualTittle);
		} else {
			System.out.println("invalid page");
		}
		Thread.sleep(4000);
		driver.manage().window().maximize();

	}

	public void ValidateValidCredential(String LocatorType, String LocatorValue) {
		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));

		if (username.isDisplayed() && username.isEnabled()) {
			System.out.println("update the field name:" + LocatorType);
			username.clear();
			username.click();
			username.sendKeys(LocatorType);

		} else {
			System.out.println(LocatorType + ":its not update");
		}

		WebElement paswrd = driver.findElement(By.xpath("//input[@name='password']"));
		if (paswrd.isDisplayed() && paswrd.isEnabled()) {
			System.out.println(LocatorValue + ":its update the value");
			paswrd.clear();
			paswrd.click();
			paswrd.sendKeys(LocatorValue);

		} else {
			System.out.println(LocatorValue + ":its not update the value");
		}

	}

	public void ClickLgnBtn() {
		WebElement lgnButton = driver.findElement(By.xpath("//div[text()='Login']"));
		lgnButton.click();
		System.out.println("Login Succes:" + lgnButton);

	}
}

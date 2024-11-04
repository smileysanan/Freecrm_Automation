package com.java.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver_Commands {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		LaunchApp("Chrome", "https://freecrm.com/");
		SubmitLoginCredintial("smileysanan8688@gmail.com", "sanan888@K");
		Thread.sleep(4000);
		NavigateThePage("Companies");
		Thread.sleep(4000);
		HomePAGE("Create", "Create new Company");
	}

	public static void LaunchApp(String browser, String url) throws Exception {

		switch (browser.trim().toLowerCase().toString()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("executed with chromedriver");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("executed with firefoxdriver");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("executed with edgedriver");
		default:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			System.out.println("executed with defaultdriver");
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.getCurrentUrl();
		System.out.println("Tittle of the pagge:" + driver.getTitle());

	}

	public static void SubmitLoginCredintial(String Username, String Password) {

		driver.findElement(By.xpath("//span[text()='Start Here']")).click();

		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));

		if (username.isDisplayed() && username.isEnabled()) {
			username.sendKeys(Username);

		}

		WebElement paswrd = driver.findElement(By.xpath("//input[@name='password']"));
		if (paswrd.isDisplayed() && paswrd.isEnabled()) {
			paswrd.sendKeys(Password);

		}
		WebElement lgnButton = driver.findElement(By.xpath("//div[text()='Login']"));
		lgnButton.click();
		System.out.println("Login Succes:" + lgnButton);

	}

	public static void NavigateThePage(String HomeIcon) {
		driver.findElement(By.xpath("//span[text()='" + HomeIcon + "']")).click();
		driver.getTitle();

	}

	public static void HomePAGE(String NewCreat, String HomeICon) {
		driver.findElement(By.xpath("//button[text()='" + NewCreat + "']")).click();
		List<WebElement> headerEle = driver.findElements(By.xpath("//span[text()='" + HomeICon + "']"));
		if (headerEle.size() == 0) {
			System.out.println("applicatio is not navigate" + HomeICon + "after the page");
			System.exit(0);
		} else {
			System.out.println("application is navigate" + HomeICon + "after the page");
		}
		driver.getTitle();

	}

}

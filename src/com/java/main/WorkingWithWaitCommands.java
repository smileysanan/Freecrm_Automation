package com.java.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWaitCommands {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ExecutedWithImplicityWait(" https://ui.cogmento.com/companies");
		Thread.sleep(4000);
		ExecutedWithExplicitiWait("smileysanan8688@gmail.com", "sanan888@K");

	}

	public static void ExecutedWithImplicityWait(String URL) {

		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		String ActualTittle = driver.getTitle();
		if (ActualTittle.equals("Cogmento CRM")) {
			System.out.println("expected tittle:" + ActualTittle);

		} else {
			System.out.println("its not match:" + ActualTittle);
		}
		

	}

	public static void ExecutedWithExplicitiWait(String username, String passwoerd) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement userTxt = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'email']")));
		if (userTxt.isDisplayed() && userTxt.isEnabled()) {
			userTxt.sendKeys(username);
			System.out.println("provide to valid credintial:" + userTxt);

		} else {
			System.out.println("invalid credincial:" + userTxt);
		}
		WebElement pwr = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'password']")));
		if (pwr.isDisplayed() && pwr.isEnabled()) {
			pwr.sendKeys(passwoerd);
			System.out.println("provide to valid credintial" + passwoerd);
		} else {
			System.out.println("invalid credincial:" + passwoerd);
		}

		WebElement lgn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() = 'Login']")));
		
		System.out.println("succesfully login applicataion");
		driver.close();
	}

}

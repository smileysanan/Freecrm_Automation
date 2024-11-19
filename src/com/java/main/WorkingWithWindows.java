package com.java.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWindows {
 static WebDriver driver;
	public static void main(String[] args) {
		LAunch("smileysanan8688@gmail.com", "sanan888@K");
	}

	public static void LAunch(String username, String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/register/");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.manage().window().maximize();
		System.out.println(driver.getWindowHandle());
		//SwitchTOWindow("https://ui.cogmento.com/deals");
		Set<String>CurrentIds = driver.getWindowHandles();

		System.out.println(CurrentIds);
		

	}
	
	public static void SwitchTOWindow (String TabNAME) {
		
		Set<String>CurrentIds = driver.getWindowHandles();
		List<String>AllTabs= new ArrayList<>(CurrentIds);
		for (String SwitchTO : AllTabs) {
			String Tittle = driver.switchTo().window(SwitchTO).getCurrentUrl();
			if (Tittle.equals(TabNAME)) {
				
				
			}
			
		}
		
		
		
		
	}

}

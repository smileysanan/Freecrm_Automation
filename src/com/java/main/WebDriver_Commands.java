package com.java.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver_Commands {
	
	public static void main(String[] args) {
		LaunchApp();
		
	}
		public static void LaunchApp (){
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://freecrm.com/");
	    System.out.println("tittle:"+ driver.getCurrentUrl());
	}

}

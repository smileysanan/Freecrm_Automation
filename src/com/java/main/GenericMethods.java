package com.java.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods extends CommonMethods {

	public static void main(String[] args) throws Exception {
		FirstTEstcase("qa");

		GenericMethods GR = new GenericMethods();
		Thread.sleep(4000);
		GR.openBrowser_TetCase1(GlobalVariables.configdata.get("browser"), GlobalVariables.configdata.get("url"));
		Thread.sleep(4000);
		GR.ValidateValidCredential(GlobalVariables.configdata.get("username"),
				GlobalVariables.configdata.get("password"));
		GR.ClickLgnBtn();
		Thread.sleep(4000);
		HeaderIconName("Companies");
		Thread.sleep(4000);
		Navigatpage("Create", "Create new Company");
		Thread.sleep(4000);
		SelectValueFromDropDownBOX("Priority", "Medium");
		SelectValueFromDropDownBOX("Source", "Event");
		SelectValueFromDropDownBOX("Status", "Active");
		SelectValueFromDropDownBOX("Category", "Prospect");

	}

	public static void FirstTEstcase(String Environment) throws Exception {

		File filePath = null;
		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		File file = new File(projectpath + "/congfiguration");

		File[] allfiles = file.listFiles();

		for (File f : allfiles) {
			if (f.getName().toString().toLowerCase().trim().contains(Environment.trim().toLowerCase())) {

				System.out.println(" Properties file path " + f.getAbsolutePath());
				filePath = f.getAbsoluteFile();
				break;
			}
		}

		FileInputStream fis = new FileInputStream(filePath);

		Properties pr = new Properties();

		try {
			HashMap<String, String> DataFromPropertyfile = new HashMap<>();
			pr.load(fis);
			for (String key : pr.stringPropertyNames()) {
				String value = pr.getProperty(key);
				DataFromPropertyfile.put(key, value);

			}
			GlobalVariables.configdata = DataFromPropertyfile;
			System.out.println("map data:" + DataFromPropertyfile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void HeaderIconName(String IConElement) {
		driver.findElement(By.xpath("//span[text()='" + IConElement + "']")).click();

		String Actual_Tittle = driver.getTitle();
		if (Actual_Tittle.equals("Cogmento CRM"))
			;

		System.out.println("Current Tittle:" + Actual_Tittle);

	}

	public static void Navigatpage(String NewIconElement, String GettingNewICon) {
		driver.findElement(By.xpath("//button[text()='" + NewIconElement + "']")).click();

		List<WebElement> headertag = driver.findElements(By.xpath("//span[text()='" + GettingNewICon + "']"));
		if (headertag.size() == 0) {

			System.out.println("after not navigate to: " + GettingNewICon + ":expected page");
			System.exit(0);
		} else {
			System.out.println("its  navigate to:" + GettingNewICon + ":expected page");
		}
	}

	public static void SelectValueFromDropDownBOX(String FieldName, String FieldValue) {

		String xpath = "//label[text()='" + FieldName + "']/following-sibling::div";

		WebElement element = driver.findElement(By.xpath(xpath));

		element.click();
		List<WebElement> Allelements = element.findElements(By.tagName("span"));

		for (WebElement lst : Allelements) {
			boolean Value = false;
			String itemtext = lst.getText();
			if (itemtext.trim().toString().contains(FieldValue)) {
				lst.click();
				Value = true;
				break;
			}
		}
		System.out.println("click value:" + FieldName + "from" + FieldValue);

	}

	

}

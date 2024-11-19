package automation_scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.java.main.GlobalVariables;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CommonMethods {
	static WebDriver driver;

	public void LaunchAplication(String BrowserName, String URl) {

		switch (BrowserName.trim().toLowerCase().toString()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("executed with chrome");
			break;

		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new ChromeDriver();
			System.out.println("executed with safari");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			System.out.println("executed with firefox");
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			System.out.println("executed with edge");
			break;

		default:
			System.out.println("invalid bowser ");
			break;
		}
		driver.get(URl);
		driver.manage().window().maximize();

	}

	public static WebElement SelectLocator(String LocatorType, String LocatorValue) {
		WebElement elment = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		switch (LocatorType.trim().toLowerCase().toString()) {
		case "id":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
			elment = driver.findElement(By.id(LocatorValue));
			break;

		case "class":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(LocatorValue)));
			elment = driver.findElement(By.className(LocatorValue));
			break;

		case "name":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
			elment = driver.findElement(By.name(LocatorValue));
			break;
		case "linktext":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LocatorValue)));
			elment = driver.findElement(By.linkText(LocatorValue));
			break;

		case "partialtext":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(LocatorValue)));
			elment = driver.findElement(By.partialLinkText(LocatorValue));
			break;

		case "xpath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
			wait.withTimeout(Duration.ofSeconds(4));
			wait.pollingEvery(Duration.ofMillis(250));
			elment = driver.findElement(By.xpath(LocatorValue));
			break;
		case "tagname":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(LocatorValue)));
			elment = driver.findElement(By.tagName(LocatorValue));
			break;

		case "css":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LocatorValue)));
			elment = driver.findElement(By.cssSelector(LocatorValue));
			break;

		default:
			break;
		}
		return elment;

	}

	public static WebElement ConditionMethod(String LocatorType, String LocatorValue) {

		WebElement element = null;

		element = SelectLocator(LocatorType, LocatorValue);

		if (element != null) {
			System.out.println("succesfully elements are created:" + LocatorType + "with:" + LocatorValue);
		} else {
			System.out.println("both elements are not created");

		}

		if (element.isDisplayed() && element.isEnabled()) {
			System.out
					.println("element will be display and enabled then provide:" + LocatorType + "and:" + LocatorValue);

		} else {
			System.out.println("element not display and enbled with:" + LocatorType + "and:" + LocatorValue);
		}
		return element;

	}

	public static boolean SubmitCredentials(String LocatorType, String LocatorValue, String Input) {

		boolean StatusOfValue = false;
		try {
			WebElement element = ConditionMethod(LocatorType, LocatorValue);
			element.clear();
			element.click();
			element.sendKeys(Input);
			System.out.println("enter the value from:" + Input);
			StatusOfValue = true;

		} catch (Exception e) {

			
			e.printStackTrace();
		}
		return StatusOfValue;

	}

	public static boolean ClickOnElm(String LocatorType, String LocatorValue) {
		boolean clicktheValue = false;

		WebElement element = SelectLocator(LocatorType, LocatorValue);
		element.click();
		System.out.println("succesfully login Frecrm application");
		clicktheValue = true;

		return clicktheValue;

	}

	public static boolean MouseHover(String LocatorType, String LocatorValue) {
		boolean clickOnValue = false;
		try {

			 WebElement element = ConditionMethod(LocatorType, LocatorValue);
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
			System.out.println("mouse over click on webelement");
			clickOnValue = true;

		} catch (Exception e) {

		}

		return clickOnValue;

	}
	
	public static boolean ExistTittle (String LocatorType,String LocatorValue) {
		boolean GettingCurrentTittle = false;
		 
		  WebElement element = SelectLocator(LocatorType, LocatorValue);
		  if (element.equals(LocatorValue)) {
			  System.out.println("ExpectedValue ");
		  }else {
			  System.out.println("its not match for Expected");
		  }
		  GettingCurrentTittle = true;
		  return GettingCurrentTittle;
		  
		
	
		
	
		
		
		
	}

	public static HashMap<String, String> PropertyDatagettingIntoMapData(String env) throws FileNotFoundException {
		HashMap<String, String> StoreTheMapData = null;
		File filePath = null;
		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		File file = new File(projectpath + "/congfiguration");

		File[] allfiles = file.listFiles();

		for (File f : allfiles) {
			if (f.getName().toString().toLowerCase().trim().contains(env.trim().toLowerCase())) {

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
			StoreTheMapData = DataFromPropertyfile;
			System.out.println("map data:" + StoreTheMapData);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StoreTheMapData;

	}

}

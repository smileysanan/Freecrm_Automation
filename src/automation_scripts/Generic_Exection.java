package automation_scripts;

import java.io.FileNotFoundException;
import java.util.HashMap;

import com.java.main.GlobalVariables;

public class Generic_Exection extends CommonMethods {
	
	
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Generic_Exection execution = new Generic_Exection();
		HashMap<String, String>Appdataa = execution.PropertyDatagettingIntoMapData("qa");
		execution.LaunchAplication(Appdataa.get("browser"), Appdataa.get("url"));
		execution.SubmitCredentials("xpath", "//input[@name='email']", Appdataa.get("username"));
		execution.SubmitCredentials("xpath", "//input[@name='password']", Appdataa.get("password"));
		execution.ClickOnElm("xpath", "(//div[text()='Login'])[1]");
		Thread.sleep(4000);
		execution.ClickOnElm("xpath", "//span[text()= 'Deals']");
	    execution.ClickOnElm("xpath", "(//span [text()='Deals' ]//following::button[1])[1]");
	    execution.SubmitCredentials("xpath", "//input[@name='title']", Appdataa.get("Title"));
	    execution.SubmitCredentials("xpath", "//div[@name='products']//input[1]", Appdataa.get("Products"));
	    execution.SubmitCredentials("xpath", "//div[@name= 'contacts' ]//input", Appdataa.get("Contacts"));
	    execution.SubmitCredentials("xpath", "//div[@name= 'company' ]//input", Appdataa.get("Company"));
	    execution.SubmitCredentials("xpath", "//label[text()='Tags']//following-sibling::div",Appdataa.get("Tags"));
		
		
	
		
	}
	
	public  static void CreaNewPage () {
		
		
	}
	
	
	
	
	
}

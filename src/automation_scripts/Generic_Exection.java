package automation_scripts;

import java.io.FileNotFoundException;
import java.util.HashMap;

import com.java.main.GlobalVariables;

public class Generic_Exection extends CommonMethods {
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Generic_Exection execution = new Generic_Exection();
		HashMap<String, String>Appdataa = execution.PropertyDatagettingIntoMapData("qa");
		execution.LaunchAplication(Appdataa.get("browser"), Appdataa.get("url"));
		execution.SubmitCredentials("xpath", "//input[@name='email']", Appdataa.get("username"));
		execution.SubmitCredentials("xpath", "//input[@name='password']", Appdataa.get("password"));
		execution.ClickOnLgnBtn("xpath", "(//div[text()='Login'])[1]");
		
	}
	
	
	
	
	
}

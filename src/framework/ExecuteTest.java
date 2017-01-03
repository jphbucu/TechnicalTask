package framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", args[0] + "\\Task_2\\drivers\\chromedriver.exe");
		ExecuteTest ex = new ExecuteTest();
		ReadExcel re = new ReadExcel();
		String action = null;
		String parameter = null;
		String input = null;
		List<String[]> list = re.getExcelData(args[0] + "\\Task_2\\tests\\" + args[1]);
		System.out.println("Start automated run for " + args[1]);
		WebDriver driver = new ChromeDriver();
		for (String[] strArr : list) {
			action = strArr[0];
			parameter = strArr[1];
			input = strArr[2];
            ex.ExecuteAction(driver, action, parameter, input);
        }
		System.out.println("End automated run for " + args[1]);
	}
	
	public void ExecuteAction(WebDriver driver, String action, String parameter, String input){
		WebActions wa = new WebActions();
		switch (action.toUpperCase()){
			case "LAUNCH":
				wa.Launch(driver, input);
				break;
			
			case "CLICK":
				wa.Click(driver, parameter);
				break;
				
			case "TYPE":
				wa.Type(driver, parameter, input);
				break;
				
			case "WAIT":
				wa.WaitForObject(driver, parameter);
				break;
				
			case "CLICKPOPUP":
				wa.ClickPopUp(driver, parameter);
				break;
			
			case "CLOSE":
				wa.Close(driver);
				break;
				
			default:
				System.out.println(action + ": does not match any current action");
				break;
		}
	}
}

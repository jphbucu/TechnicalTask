package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PC-Zero\\Desktop\\Task_2\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		WebActions wa = new WebActions();
		
        //Launch the Online Store Website
		wa.Launch(driver, "https://www.amaysim.com.au/");
		System.out.println("launch amaysim done");
		
		//click Login link
		wa.Click(driver, "xpath|//*[@id=\"block-useraccountmenu\"]/ul/li[2]/a/span");
        System.out.println("click login done");
		
        //enter amaysim number
        wa.Type(driver, "id|my_amaysim2_user_session_login", "0468827174");
        System.out.println("enter amaysim number done");
		
        //enter password
        wa.Type(driver, "id|password", "theHoff34");
        System.out.println("enter password done");
		
        //click login button
        wa.Click(driver, "id|login_button");
        System.out.println("click login button done");
		
		//my settings
        wa.Click(driver, "xpath|/html/body/div[1]/div[1]/nav/ul/li[9]/a/span[1]");
        System.out.println("my settings done");
        
        //call forwarding
        wa.Click(driver, "xpath|//*[@id=\"edit_settings_call_forwarding\"]");
		System.out.println("call forwarding done");
		
		//wait for pop up
		wa.WaitForObject(driver, "xpath|//*[@id=\"body-content\"]/div[15]/div/div/div/div[1]/a");
		System.out.println("wait for pop up done");
		
		//pop up confirmation
		wa.ClickPopUp(driver, "//*[@id=\"body-content\"]/div[15]/div/div/div/div[1]/a");
		System.out.println("confirm pop up done");
		
		//no
		wa.Click(driver, "xpath|//*[@id=\"update_call_forwarding_form\"]/div[2]/div/label[2]/span");
		System.out.println("select No done");

		//yes
		wa.Click(driver, "xpath|//*[@id=\"update_call_forwarding_form\"]/div[2]/div/label[1]/span");
		System.out.println("select Yes done");
		
		//call forward textbox
		wa.Type(driver, "id|my_amaysim2_setting_call_divert_number", "0287654321");
		System.out.println("call forward textbox done");
		
		//save call forwarding
		wa.Click(driver, "xpath|//*[@id=\"update_call_forwarding_form\"]/div[4]/div/input");
		System.out.println("save done");
		
		//wait for pop up
		wa.WaitForObject(driver, "xpath|//*[@id=\"body-content\"]/div[15]/a");
		System.out.println("wait for pop up done");
		
		//Close success pop up
		wa.ClickPopUp(driver, "//*[@id=\"body-content\"]/div[15]/a");
		System.out.println("close confirmation done");
		//Thread.sleep(4000);
		//logout
		wa.Click(driver, "xpath|//*[@id=\"top_header\"]/div[2]/div/a");
        System.out.println("logout done");
		
        //wait for login page
        wa.WaitForObject(driver, "id|login_button");
        System.out.println("wait for login page done");
        
		// Close the driver
        wa.Close(driver);
        System.out.println("close browser done");
    }

}

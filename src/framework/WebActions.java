package framework;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void Launch(WebDriver driver, String url){
		try {
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("LAUNCH " + url + " Passed!");
		} catch (TimeoutException e) {
			System.out.println("LAUNCH " + url + " Failed... " + this.getBaseError(e.toString()));
		}
	}
	
	public void Click(WebDriver driver, String parameter){
		try {
			String params[] = parameter.split("\\|");
			WebElement element = null;
			switch (params[0]){
				case ("id"):
					element = driver.findElement(By.id(params[1]));
					break;
				case ("xpath"):
					element = driver.findElement(By.xpath(params[1]));
					break;
			}
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); 
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).click().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("CLICK " + parameter + " Passed!");
		} catch (TimeoutException e) {
			System.out.println("CLICK " + parameter + " Failed... " + this.getBaseError(e.toString()));
		} catch (NoSuchElementException e) {
			System.out.println("CLICK " + parameter + " Failed... " + this.getBaseError(e.toString()));
			
		}
	}
	
	public void Type(WebDriver driver, String parameter, String input){
		try {
			WebElement e = null;
			String params[] = parameter.split("\\|");
			switch (params[0]){
				case ("id"):
					e = driver.findElement(By.id(params[1]));
					break;
				case ("xpath"):
					e = driver.findElement(By.xpath(params[1]));
					break;
			}
			e.sendKeys(Keys.chord(Keys.CONTROL, "a"), input);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("TYPE " + parameter + " with " + input + " Passed!");
		} catch (TimeoutException e) {
			System.out.println("TYPE: " + parameter + " with " + input + " Failed... " + this.getBaseError(e.toString()));
		} catch (NoSuchElementException e) {
			System.out.println("TYPE " + parameter + " with " + input + " Failed... " + this.getBaseError(e.toString()));
		}
	}
	
	public void ClickPopUp(WebDriver driver, String parameter) {
		try {
			String parentWindowHandler = driver.getWindowHandle();
			String subWindowHandler = null;
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler);  
			driver.findElement(By.xpath(parameter)).click();
			driver.switchTo().window(parentWindowHandler);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(4000);
			System.out.println("CLICKPOPUP: " + parameter + " Passed!");
		} catch (TimeoutException e) {
			System.out.println("CLICKPOPUP: " + parameter + " Failed... " + this.getBaseError(e.toString()));
		} catch (InterruptedException e) {
			System.out.println("CLICKPOPUP: " + parameter + " Failed... " + this.getBaseError(e.toString()));
		} catch (NoSuchElementException e) {
			System.out.println("CLICKPOPUP: " + parameter + " Failed... " + this.getBaseError(e.toString()));
		}
	}
	
	public void WaitForObject(WebDriver driver, String parameter){
		try {
			String params[] = parameter.split("\\|");
			WebDriverWait wait = new WebDriverWait(driver, 15);
			switch (params[0]){
			case ("id"):
				wait.until(ExpectedConditions.elementToBeClickable(By.id(params[1])));
				break;
			case ("xpath"):
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(params[1])));
				break;
			}
			System.out.println("WAIT for object " + parameter + " Passed!");
		} catch (TimeoutException e) {
			System.out.println("WAIT for object " + parameter + " Failed... " + this.getBaseError(e.toString()));
		}
	}
	
	public void Close(WebDriver driver){
		driver.quit();
		System.out.println("CLOSE browser driver Passed!");
	}
	
	public String getBaseError(String e){
		String a[] = e.split("\n");
		return a[0];
	}
}

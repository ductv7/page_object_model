package common.pageTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.baseTest.BaseTest;

public class LoginPage extends BaseTest {
	
	WebDriver driver;

	/**
	 * 
	 * This class will store all the locator and method of login page
	 */
	
	
	 //Login form	
	 By username = By.xpath("//input[@name='uid']");
	 By password = By.xpath("//input[@name='password']");
	 By loginbtn = By.xpath("//input[@value='LOGIN']");	
	 
	 public LoginPage(WebDriver driver){
		 
		 this.driver=driver;
	 }
	 
	 public void loginGuruPage(String user, String pwd){
		 
		 driver.findElement(username).sendKeys(user);
		 
		 driver.findElement(password).sendKeys(pwd);
		 
		 driver.findElement(loginbtn).click();
		 
	 }
	 
	 public boolean  loginSuccess(String user){
		 
		 try {
			 
			WebElement ele = driver.findElement(By.xpath("//td[contains(text(),'Manger Id : "+user+"')]"));
			
			ele.isDisplayed();
			 
		 }catch(Exception e){
			 
			 e.getMessage();
		 }
		 	 
		 return true;
	 }
}

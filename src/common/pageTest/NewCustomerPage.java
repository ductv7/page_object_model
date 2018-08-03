package common.pageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPage {
	
	WebDriver driver;

	/**
	 * 
	 * This class will store all the locator and method of New Customer page
	 */
	
	 //New Customer form
	 By new_customer_link= By.xpath("//a[contains(text(),'New Customer')]");
	 By customer_name = By.xpath("//*[contains(text(),\"Customer Name\")]/../td/input");
	 By gender = By.xpath("//input[@value='m']");
	 By dob = By.xpath("//input[@id='dob']");
	 By address = By.xpath("//textarea[@name='addr']");
	 By city = By.xpath("//input[@name='city']");
	 By state = By.xpath("//input[@name='state']");
	 By pin = By.xpath("//input[@name='pinno']");
	 By mobile = By.xpath("//input[@name='telephoneno']");
	 By email = By.xpath("//input[@name='emailid']");
	 By password = By.xpath("//input[@name='password']");
	 By submit_btn = By.xpath("//input[@value='Submit']");
	 By message_success = By.xpath("//*[contains(text(),'Customer Registered Successfully')]");
	 By customerId = By.xpath("//*[contains(text(),'Customer ID')]/following::td[1]");
	 
	 public NewCustomerPage(WebDriver driver){
		 
		 this.driver=driver;
	 }
	 
	 public void clickNewCustomerLink(){
		 
		 driver.findElement(new_customer_link).click();
	 }
	 
	 public void typeName(String name){
		 
		 driver.findElement(customer_name).sendKeys(name);
		 
	 }
	 
	 public void selectGender(String gvalue){
		 //Only 2 value "m" for male and "f" for female
			 
			driver.findElement(By.xpath("//input[@value='"+gvalue+"']")).click();
		 
	 }
	 
	 public void selectDOB (String date){
		 
		 //format mm/dd/yyyy
		 driver.findElement(dob).sendKeys(date);
	 }
	 
	 public void typeAddress (String add){
	
		 driver.findElement(address).sendKeys(add);
		 
	 }
	 
	 public void typeCity(String ct){
		 
		 driver.findElement(city).sendKeys(ct);
	 }
	 
	 public void typeState(String svalue){
		 
		 driver.findElement(state).sendKeys(svalue);
	 }
	 
	 public void typePIN(String pvalue){
		 
		 driver.findElement(pin).sendKeys(pvalue);
	 }

	 public void typeMobile(String mob){
		 
		 driver.findElement(mobile).sendKeys(mob);
	 }
	 
	 public void typeEmail(String mail){
		 
		 driver.findElement(email).sendKeys(mail);
	 }
	 
	 public void typePassword(String pwd){
		 
		 driver.findElement(password).sendKeys(pwd);
	 }
	 
	 public void clickSubmit(){
		 
		 driver.findElement(submit_btn).click();
	 }
	 
	 public boolean verifyNewCustomerSuccess(){
		 
		 try {
			 
			 WebElement ele = driver.findElement(message_success);
			 
			 ele.isDisplayed();
			 
			 return true;
			 
		 }catch(Exception e){
			
			 e.getMessage();
			 
		 }
		 
		 return false;
	 }
	 
	 public String getCustomerID(){
		 
		 String cusId = driver.findElement(customerId).getText();
		 
		 System.out.println("Customer ID: "+cusId);
		 
		 return cusId;
	 }
}

package common.pageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
	WebDriver driver;

	/**
	 * 
	 * This class will store all the locator and method of account page
	 */
	
	 //New Account form
	 By new_account_link= By.xpath("//a[contains(text(),'New Account')]");
	 By customer_id = By.xpath("//input[@name='cusid']");
	 By account_type_dd = By.xpath("//select[@name='selaccount']");
	 By init_deposit = By.xpath("//input[@name='inideposit']");
	 By submit_btn = By.xpath("//input[@value='submit']");
	 By message_success = By.xpath("//*[contains(text(),'Account Generated Successfully')]");
	 By account_id = By.xpath("//*[contains(text(),'Account ID')]/following::td[1]");
	 
	 public NewAccountPage(WebDriver driver){
		 
		 this.driver=driver;
	 }
	 
	 public void clickNewAccount(){
		 
		 driver.findElement(new_account_link).click();
	 }
	 
	 
	 public void typeCustomerId(String cusid){
		 
		 driver.findElement(customer_id).sendKeys(cusid);
		 
	 }
	 
	 public void SelectAccountType(String value){
		 //2 values: Savings, Current
		 
		 try {
			 
			 WebElement ele = driver.findElement(account_type_dd);
			 
			 Select select = new Select(ele);
			 
			 select.selectByValue(value);
			 
		 }catch(Exception e){
			 
			 e.printStackTrace();
		 }
		 
	 }
	 
	 public void typeInitDeposit(String value){
		 
		 driver.findElement(init_deposit).sendKeys(value);
		 
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
	 
	 public String getAccountID(){
		 
		 String accId = driver.findElement(account_id).getText();
		 
		 System.out.println("Account ID: "+accId);
		 
		 return accId;
	 }
}

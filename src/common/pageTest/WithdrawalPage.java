package common.pageTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.baseTest.BaseTest;

public class WithdrawalPage extends BaseTest {
	
	WebDriver driver;

	/**
	 * 
	 * This class will store all the locator and method of Withdrawal page
	 */
	
	
	 //Withdrawal form
	 By withdrawal_link = By.xpath("//a[contains(text(),'Withdrawal')]");
	 By account_number = By.xpath("//input[@name='accountno']");
	 By amount = By.xpath("//input[@name='ammount']");
	 By description = By.xpath("//input[@name='desc']");
	 By submit_btn = By.xpath("//input[@value='Submit']");
	 
	 public WithdrawalPage(WebDriver driver){
		 
		 this.driver=driver;
	 }
	 
	 public void clickWithdrawalLink(){
		 
		 driver.findElement(withdrawal_link).click();
	 }
	 
	 public void typeAccountId(String id){
		 
		 driver.findElement(account_number).sendKeys(id);
		 
	 }
	 
	 public void typeAmount(String value){
		 
		 driver.findElement(amount).sendKeys(value);
	 }
	 
	 public void typeDescription(String des){
		 
		 driver.findElement(description).sendKeys(des);
	 }
	 
	 public void clickSubmit(){
		 
		 driver.findElement(submit_btn).click();
	 }
	 
	 public void VerifyFailedPopUp(){
		 
		 String fail_str =  "Transaction Failed. Account Balance Low";
		 
			 
		 String text = driver.switchTo().alert().getText();
				
			
		 assertTrue(text.contains(fail_str));
		 	 
	 }
	 
	 public void closePopUp(){
		 
		 driver.switchTo().alert().accept();
	 }
}

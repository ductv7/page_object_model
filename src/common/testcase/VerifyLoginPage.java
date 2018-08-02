package common.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import common.baseTest.BaseTest;
import common.pageTest.LoginPage;
import common.pageTest.NewAccountPage;
import common.pageTest.NewCustomerPage;

public class VerifyLoginPage extends BaseTest {
	
	/**
	 * @author Tran Viet Duc
	 * @version 0.1
	 */
	@Test(priority=1)
	public void VerifyLogin(){
		
		login.loginGuruPage("mngr146227", "Esunyhy");
		login.loginSuccess("mngr146227");
	}
	
	@Test(priority=2,dependsOnMethods="VerifyLogin")
	public void VerifyCustomerPage(){
		
		ncustomer.clickNewCustomerLink();
		ncustomer.typeName("ductv");
		ncustomer.selectGender("f");
		ncustomer.selectDOB("01/31/1988");
		ncustomer.typeAddress("Chung Cu ABC");
		ncustomer.typeCity("Ho Chi Minh");
		ncustomer.typeState("Ho Chi Minh");
		ncustomer.typePIN("700000");
		ncustomer.typeMobile("25425456");
		ncustomer.typeEmail("mngr146227_1@gmail.com");
		ncustomer.typePassword("123456");
		ncustomer.clickSubmit();
		ncustomer.verifyNewCustomerSuccess();
	}
	
	@Test(priority=3, dependsOnMethods="VerifyCustomerPage")
	public void VerifyAccountPage(){
		
		naccount.typeCustomerId(ncustomer.getCustomerID());
		naccount.SelectAccountType("Savings");
		naccount.typeInitDeposit("1000");
		naccount.clickSubmit();
		naccount.verifyNewCustomerSuccess();
	}
	
	@Test(priority=4, dependsOnMethods="VerifyAccountPage")
	public void VerifyWithdrawalPage(){
		
		withdrawal.typeAccountId(naccount.getAccountID());
		withdrawal.typeAmount("1000");
		withdrawal.typeDescription("Personal");
		withdrawal.VerifyFailedPopUp();
	}
}

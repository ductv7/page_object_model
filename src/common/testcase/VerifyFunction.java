package common.testcase;

import org.testng.annotations.Test;

import common.baseTest.BaseTest;

public class VerifyFunction extends BaseTest {
	
	public String cusId = null;
	
	public String accId = null;
	
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
		ncustomer.typeEmail("mngr146227_3@gmail.com");
		ncustomer.typePassword("123456");
		ncustomer.clickSubmit();
		ncustomer.verifyNewCustomerSuccess();
		//Get Customer ID for next step
		cusId = ncustomer.getCustomerID();
	}
	
	@Test(priority=3, dependsOnMethods="VerifyCustomerPage")
	public void VerifyAccountPage(){
		
		naccount.clickNewAccount();
		naccount.typeCustomerId(cusId);
		naccount.SelectAccountType("Savings");
		naccount.typeInitDeposit("1000");
		naccount.clickSubmit();
		naccount.verifyNewCustomerSuccess();
		//Get Account ID for next step
		accId = naccount.getAccountID();
	}
	
	@Test(priority=4, dependsOnMethods="VerifyAccountPage")
	public void VerifyWithdrawalPage(){
		
		withdrawal.clickWithdrawalLink();
		withdrawal.typeAccountId(accId);
		withdrawal.typeAmount("2000");
		withdrawal.typeDescription("Personal");
		withdrawal.clickSubmit();
		withdrawal.VerifyFailedPopUp();
		withdrawal.closePopUp();
	}
}

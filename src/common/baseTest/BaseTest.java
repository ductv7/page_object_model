package common.baseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import common.pageTest.LoginPage;
import common.pageTest.NewAccountPage;
import common.pageTest.NewCustomerPage;
import common.pageTest.WithdrawalPage;

public class BaseTest {
		
		protected WebDriver driver;
		protected LoginPage login;
		protected NewCustomerPage ncustomer;
		protected NewAccountPage naccount;
		protected WithdrawalPage withdrawal;
		private String url = GlobalConfig.URL;
		private String browser = GlobalConfig.BROWSER;	
				
		@BeforeClass 
		public void SetUp(){
			getWebDriver();
			navigatetoPage();
			applyTimeOuts();
			createPageObjects();
		}
			
		/*@AfterClass
		public void tearDown(){
			try{
				driver.quit();
			}catch(Exception ex){
				System.out.println("Exception: " + ex);
			}		
		}*/
		
		private void createPageObjects() {
			login = new LoginPage(driver);	
			ncustomer = new NewCustomerPage(driver);
			naccount = new NewAccountPage(driver);
			withdrawal = new WithdrawalPage(driver);
		}

		private void applyTimeOuts() {
			driver.manage().timeouts().pageLoadTimeout(GlobalConfig.PAGELOAD_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(GlobalConfig.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		}

		private void navigatetoPage() {
			driver.navigate().to(url);
			driver.manage().window().maximize();		
		}

		private void getWebDriver() {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}		
		}

}

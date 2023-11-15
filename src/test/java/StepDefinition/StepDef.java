package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//=================================================================================================================================================	
	//***************HOOKS****************************
//@Before   //hooks are the block of code that runs before and after each scenario.@before & @After are called scenario hooks that runs before 
	//and after each scenario.
	//step hooks are used before & after each step of the scenario.
	//Conditionals hooks :-we can associate hooks with tags for conditional execution.
//@BeforeStep  //this will execute before each step
//@AfterStep   //this will execute after each step
//	@Before ("@regression")  //conditional hooks


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import POMPackage.AddNewCustomer;
import POMPackage.LoginPOM;
import POMPackage.SearchCustomerByMail;
import POMPackage.SearchCustomerByName;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class StepDef extends BaseClass {   // step definition class child class hai because isne inhert kari hai parent class(BaseClass) ki properties

@Before	
public void BeforeScenariohooks() {
	
	reporter=new ExtentHtmlReporter("J:\\eclipse_Jdrive\\Cucumberframework\\Extentreport\\myextent.html");//hum yaha extent use kar rahe hai ek dashboard view wale report ko banane k liye
	reports=new ExtentReports();
	reports.attachReporter(reporter);
	reporter.config().setDocumentTitle("Extent report");
	reporter.config().setReportName("Extent report for scenariohoks");//we have named the report by this
	reporter.config().setTheme(Theme.STANDARD);
	reporter.config().setTimeStampFormat("dd/mm/yyyy, hh:mm:ss");
	
	log=Logger.getLogger("BaseClass");
	PropertyConfigurator.configure("J:\\eclipse_Jdrive\\Cucumberframework\\Logger_Folder\\log.properties");
	System.out.println("Before scenario Hook executed");
	System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Chrome\\Chrome119\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	log.info("Chrome Launched");
	
}
	
@BeforeStep
public void BeforeStepmethod() {
	
	System.out.println("BeforestepMethod Hook executed");
}


	@Given("User launch chrome broswer")
	public void user_launch_chrome_broswer() throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "J:\\eclipse_Jdrive\\Chrome\\Chrome2\\chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
		test=reports.createTest("Launching broswer");//we have given the name  of the method in extent report
		page=new LoginPOM(driver);
		addnewcustpage=new AddNewCustomer(driver);  //for add new customer pom
		Searchcstbymail=new SearchCustomerByMail(driver);   // for search customer by mail pom
		searchbyname=new SearchCustomerByName(driver);   //  for search customer by name
		Thread.sleep(3000);
		test.log(Status.PASS, "Browser launches successfully");
		test.log(Status.PASS, MarkupHelper.createLabel("Browser launches successfully", ExtentColor.GREEN));
	}

	@When("User open URL as {string}")
	public void user_open_url_as(String url2) throws InterruptedException {
test=reports.createTest("Opening URL");//we have given the name  of the method in extent report
		driver.get(url2);
		log.info("website URL Launched");

		Thread.sleep(3000);
		test.log(Status.PASS, "URL Launched");
		test.log(Status.PASS, MarkupHelper.createLabel("URLmLaunched", ExtentColor.GREY));
	}

	@And("User enter Email id as {string} and Password as {string}")
	public void user_enter_email_id_as_and_password_as(String emailID, String passwd) throws InterruptedException {
		test=reports.createTest("Entering login credentials");//we have given the name  of the method in extent report
		page.entermailID(emailID);
		page.enterpwd(passwd);
		
		log.info("User id & Password provided");

		test.log(Status.PASS, "Entered email id and password");
		test.log(Status.PASS, MarkupHelper.createLabel("Entered email id and password", ExtentColor.GREY));

	}

	@And("user clicked on Login buttton")
	public void user_clicked_on_login_buttton() throws InterruptedException {

		page.clicklogin();
		log.info("Clicked on login button");
		Thread.sleep(3000);
		test.log(Status.PASS, "Clicked on login button");
		test.log(Status.PASS, MarkupHelper.createLabel("Clicked on login button", ExtentColor.GREEN));
	}
	////////////////////////////////Login Feature/////////////////////////////////////////////////////////

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		String actualtitle = driver.getTitle();	 
		if(expectedtitle.equals(actualtitle)) {

			Assert.assertTrue(true);
			
			log.info("Page title verified");
		}
		else {
			Assert.assertTrue(false);
		}	    

	}

	@When("user click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {

		page.clickonlogout();
		log.fatal("Clicked on logout button");
		Thread.sleep(3000);
	}

//	@Then("user close the browser")
//	public void user_close_the_browser() {
//log.error("Browser closed");
//		driver.close();
//	}

	////////////////////////Add New Customer/////////////////////////////////////////////////////////

	@When("User clicked on Customers Menu")
	public void user_clicked_on_customers_menu() throws InterruptedException {
		addnewcustpage.ClickonCustomerMenu();
		Thread.sleep(3000);
	}

	@When("Clicked on Customers Menu Item")
	public void clicked_on_customers_menu_item() throws InterruptedException {
		addnewcustpage.ClickonCustomermenuitem();
		Thread.sleep(3000);

	}

	@When("Clicked on Add new button")
	public void clicked_on_add_new_button() throws InterruptedException {
		addnewcustpage.ClickonAddnewBTN();
		Thread.sleep(3000);

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String expectedtitle="Add a new customer / nopCommerce administration";
		String actualtitle=driver.getTitle();

		if(expectedtitle.equals(actualtitle)) {

			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}

	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addnewcustpage.entermailid("test12through@gmail.com");
		addnewcustpage.entermailid(Getrandommailid() + "@gmail.com");//isme Getrandommailid method ko call kiya gaya taaki mail id add cusomer karte time alag alag rahe har bar.Method islye call ho gaya kyu ki stepdefinition ne parent class ko inhert kiya hua hai jiski wajah se uski properties stepdef k paas aa gayi.
		addnewcustpage.enterPassword("Password@123");
		addnewcustpage.enterFirstname("Jatin");
		addnewcustpage.enterLastname("Rout");
		addnewcustpage.selectGender();
		addnewcustpage.selectDOB("03/21/1992");
		addnewcustpage.enterCompanyname("Jatin & Company");
		//addnewcustpage.enterjenis("test2");
		addnewcustpage.selectisTaxexempt();
		addnewcustpage.selectManagerofVendor("Vendor 1");
		addnewcustpage.checkactive();
		addnewcustpage.admincomment("This is Jatin, admin of this POM page");



	}

	@When("Clicked on save button")
	public void clicked_on_save_button() throws InterruptedException {
		addnewcustpage.Savebtn();
		Thread.sleep(3000);

	}

	@Then("user can view message {string}")
	public void user_can_view_message(String expectedmessage) {

		String Bodytagtext=driver.findElement(By.tagName("Body")).getText();
		if(Bodytagtext.contains(expectedmessage)) {

			Assert.assertTrue(true);

		}

		else {

			Assert.assertTrue(false);
		}
	}

	///////////////////////////Search customer by mail/////////////////////////////////////////////////////

	@When("User enter email id")
	public void user_enter_email_id() throws InterruptedException {
		Searchcstbymail.enterEmailadd("victoria_victoria@nopCommerce.com");

		Thread.sleep(3000);

	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		Searchcstbymail.searchbtn();
		Thread.sleep(3000);

	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {

		String expectedmailid = "victoria_victoria@nopCommerce.com";

		if(Searchcstbymail.searchcustomerbyemail(expectedmailid)==true) {

			Assert.assertTrue(true);
		}

		else {

			Assert.assertTrue(false);
		}
	}

	//////////////////Search customer by name//////////////////////////////////////////////////

	@When("User enter First name")
	public void user_enter_first_name() throws InterruptedException {
		searchbyname.Enterfirstname("Virat");
		Thread.sleep(3000);


	}

	@When("User enter Last name")
	public void user_enter_last_name() throws InterruptedException {

		searchbyname.Enterlastname("Kohli");
		Thread.sleep(3000);

	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {

		String Expectedname = "Virat Kohli";

		if(searchbyname.searchcustbyname(Expectedname)==true) {

			Assert.assertTrue(true);
		}
		else {

		Assert.assertTrue(true);
		}

	}

	@AfterStep
	public void AfterStepMethod() {
		System.out.println("AfterStepMethod Hook executed");
	}
	
@After   
	public void AfterscenarioHook() {
		
		System.out.println("After scenario Hook executed");
		reports.flush();
		driver.quit();
		
	}
	

//@After    //@after method is also used as Listeners and used to take the screenshot.
//public void AfterscenarioHook(Scenario sc) throws IOException {
//	
//	if(sc.isFailed()==true) {
//	TakesScreenshot srcshot=((TakesScreenshot)driver);
//	File srcFile = srcshot.getScreenshotAs(OutputType.FILE);
//	File dest=new File("J:\\eclipse_Jdrive\\Cucumberframework\\Screenshot\\failedscreensot.png");
//	FileUtils.copyFile(srcFile, dest);
//	

//		//driver.quit();
	//}
	
	
}





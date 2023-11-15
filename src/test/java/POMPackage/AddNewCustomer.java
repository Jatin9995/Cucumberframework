package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer {
	
	WebDriver driver;
	
	public AddNewCustomer(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement Customer_menu;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customer_Menu;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnAddNeWebElement;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtemaiidElement;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtpasswordElement;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstnameElement;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastnamElement;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement maleGenderElement;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement selectDOBElement;
	
	@FindBy(xpath = "//input[@name='Company']")
	WebElement txtCompanynameElement;
	
//	@FindBy(xpath = "//input[@class='form-control']")
//	WebElement jenisElement;
	
	@FindBy(xpath = "//input[@id='IsTaxExempt']")
	WebElement isTaxexemptElement;
	
	
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement selectvendoridElement;
	
	@FindBy(xpath = "//input[@id='Active']")
	WebElement checkActiveboxElement;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement adcomment;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	
	
////////////////////////////////Methods for Add New Customer web elements  /////////////////////////////////////////////////

	
	public void ClickonCustomerMenu() {
		Customer_menu.click();
		
	}
	
	
	public void ClickonCustomermenuitem() {
		
		customer_Menu.click();
	}
	
	public void ClickonAddnewBTN() {
		btnAddNeWebElement.click();
		
	}
	
	
	public void entermailid(String email) {
		txtemaiidElement.sendKeys(email);
		
	}
	
	public void enterPassword(String pwd) {
		txtpasswordElement.sendKeys(pwd);
	}
	
	
	public void enterFirstname(String firstname) {
		txtFirstnameElement.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		txtLastnamElement.sendKeys(lastname);
	}
	
	
	public void selectGender() {
		maleGenderElement.click();
	}
	
	public void selectDOB(String DOB) {
		
		selectDOBElement.sendKeys(DOB);
	}
	
	public void enterCompanyname(String company) {
		
		txtCompanynameElement.sendKeys(company);
		
	}
	
//	public void enterjenis(String text) {
//		jenisElement.sendKeys(text);
//	}
	
	
	public void selectisTaxexempt() {
		isTaxexemptElement.click();
	}
	
	
	
	
	public void selectManagerofVendor(String value2) {
		
		Select dropdown=new Select(selectvendoridElement);
		dropdown.selectByVisibleText(value2);
	}
	
	public void checkactive() {
		checkActiveboxElement.click();
	}
	
	public void admincomment(String comment) {
		adcomment.sendKeys(comment);
		
	}
	
	public void Savebtn() {
		savebtn.click();
	}
	
	
	
}

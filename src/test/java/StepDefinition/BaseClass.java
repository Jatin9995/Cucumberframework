package StepDefinition;


import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POMPackage.AddNewCustomer;
import POMPackage.LoginPOM;
import POMPackage.SearchCustomerByMail;
import POMPackage.SearchCustomerByName;

public class BaseClass {
	
	//Base class as a parent class use hota hai step definition class k liye. Base class parent class hota hai and step definition child class hota hai
	//jo ki base class ki properties ko inhert karta hai. 
	//Base class me hum saare common commenly used variables and methods ko maintain karte hai.
	//real time me bohot sare step definition classes hote hai to usme same variables or methods use hote hai to uske liye hum base class banate hai.
	//step definition class base class ko inhert karte hai jiske liye hum extent key use karte hai. Inhert karne se saare variables and methods accessable ho jaate hai stepdefinition class me.
	//commenly used variables and methods ko child class (Stepdefinition) me ab banae ki jarurat nahi hai because ko easily access kar sakte hai stepdefinition file me kyu ki inhert kiya hai base class ko extend keyword k through.
	
	public String Getrandommailid() {  //String hamesha alphabetic returb karta hai
		return(RandomStringUtils.randomAlphabetic(5)); //from this RandomStringUtils class, it will generate unique mail id. Is use humne islye kiya hai taaki add new customer karte time hamesha new mail id system le add karne k liye.
		
		
		
	}
	
	
	
	public static WebDriver driver;
	public	LoginPOM page;
	public AddNewCustomer addnewcustpage;
	public	SearchCustomerByMail Searchcstbymail;
	public	SearchCustomerByName searchbyname;
	public Logger log;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;

}

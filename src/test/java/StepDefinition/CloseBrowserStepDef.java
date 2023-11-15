package StepDefinition;

import io.cucumber.java.en.Then;


//CloseBrowserStepDef ab ek child class hai and Baseclass parent class hai.
public class CloseBrowserStepDef extends BaseClass {
	
	
	//ye ek new stepdefinition file hai jisko banaya gaya hai taaki multiple stepdef file ek sath run kar sake real time pe
	//kyu ki jitne snenario badhenge feature file me us according hume multiple stef file banane pad sakte hai.
//isme hum extend kar denge parenet class ko jo ki BaseClass hai taaki uski property closeBrowser step def class me aa jaye. is se stepsef file apas me link ho jayenge.
//Browser close karne wale step hum isme likhenge taaki chahea jo bhi feature file run ho, close wala step is stepdefinition class se ho.
	
	
	@Then("user close the browser")
	public void user_close_the_browser() {

		driver.close();
	}
	

}

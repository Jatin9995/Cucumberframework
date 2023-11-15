package StepRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	//	features = "J:\\eclipse_Jdrive\\Cucumberframework\\src\\test\\java\\FeatureFile\\Customer.feature",
		//agar bohot saare feature file hai or humne kuch specific feature file he execute karna hai to:- features={"first feature file location", "Second feature file location"} is tarah karenge
//tags= tage islye use hote hai taaki hum features file k specific scenarios ko execute kar paye.Jaise agar kisi me sanity testing karni hai to @Sanity feature file me lagane se or runner file me tags="@Sanity" lagane se sirf features files  k @sanity wale feature he run honge. Bakkki scenarios execute nahi honge
//Agar kisi test scenario me sanity or regression dono he test karne hai to feature file me @Sanity @regression tag lagayenge. Is se jab sanity execute hoga tab bhi ye scenario execute hoga or jab regression test execute hoga tab bhi ye scenario execute hoga. runner file me ap dono me se chahea oi bhi tag execute karo, hone dono he execute.
//////////////Operators in tag/////////////////////////////////////// we will use the below tags in test runner class only
//tags="@Sanity or @regression" will run scenarious tagged with sanity or regression//sabhi scemarios execute ho jayenge because saare scenarios  pe tag laga hai feaure file me
		//tags= "@Sanity and @regression" will run scenarios tagged with sanity as well as regression.//wo scenarios execute honge jinpe dono tags lage hone sath me
		//tags="@sanity and not regression" will run scenarios tagged with sanity but not regression
		
		features = {"J:\\eclipse_Jdrive\\Cucumberframework\\src\\test\\java\\FeatureFile", "J:\\eclipse_Jdrive\\Cucumberframework\\src\\test\\java\\FeatureFile\\Customer.feature"}, // agar sabhi feature files ko sath me execute karna hai to feature file k folder ka location dete hai.
		glue = {"StepDefinition"},
		dryRun = false,
		monochrome = true,
		tags="@Sanity",
		plugin = {"pretty","html:J:\\eclipse_Jdrive\\Cucumberframework\\target\\Report\\AddnewCustReporthtml.html",
				"json:J:\\eclipse_Jdrive\\Cucumberframework\\target\\Report\\AddnewCustReportjson.json",
				"junit:J:\\eclipse_Jdrive\\Cucumberframework\\target\\Report\\AddnewCustReportxml.xml"}
		
		
		
		)


public class TestRunner {

}

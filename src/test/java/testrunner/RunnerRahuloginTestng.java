package testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src//test//java//features//e2e.feature",
		glue="stepdefinations",
		monochrome=true,
		dryRun=false
		)

public class RunnerRahuloginTestng extends AbstractTestNGCucumberTests{

}
 
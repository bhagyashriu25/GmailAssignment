package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\InCubyte\\InCubyte\\src\\test\\java\\features\\gmail.feature", //the path of the feature files
		glue={"stepDefinations"}, //the path of the step definition files
		monochrome=true,
		plugin= {"pretty","html:target/cucumber-reports","junit:junit_xml/cucumber.xml","json:target/cucumber.json"}	,
		dryRun=false
		)
 

public class TestRunner {

}

package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/Resources/Goibibo.feature",
				  glue={"StepDefinition"},
                  tags = { "@Goibibo"},
				  plugin = {"html:target/html-cucumber-report",
		  "json:target/cucumber-reports/Cucumber.json", 
		  "junit:target/cucumber-reports/Cucumber.xml" } )
public class TestRunner {

}

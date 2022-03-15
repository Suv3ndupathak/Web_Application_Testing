package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "./src/test/resources/Resources/GilletteForgotPasswd.feature",
				  glue={"ForgotPasswdStepD"},
                  tags = { "@ForgotPassword"},
				  plugin = {"html:target/html-cucumber-report",
						  "json:target/cucumber-reports/Cucumber.json", 
						  "junit:target/cucumber-reports/Cucumber.xml" } )
public class ForgotPasswdTestRunner 
{

}

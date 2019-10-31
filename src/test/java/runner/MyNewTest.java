package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features/bestbuyapi/APIHealthCheck.feature",
		glue="product/bestbuyapi/stepdefs",
				plugin =
			{
					"pretty" , 
					"html:target/CucumberResults1"
			}
		)
public class MyNewTest {


}

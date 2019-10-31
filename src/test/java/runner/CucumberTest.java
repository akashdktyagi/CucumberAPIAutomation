package runner;

/*
* 8. Tags: for grouping of the tests
* Not: tag{"~@reg"} 
* And: tag{"@reg","@smoke"}
* or:  tag{"@reg,@smoke"}
* */

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features = {"classpath:features/bestbuyapi/GetScenario.feature",
				"classpath:features/bestbuyapi/"},
		glue = "product.bestbuyapi",
		tags = {"@testthis"},
		plugin =
			{
					"pretty" , 
					"html:target/CucumberResults12"
			},
		dryRun=true
		
		)
public class CucumberTest {




}

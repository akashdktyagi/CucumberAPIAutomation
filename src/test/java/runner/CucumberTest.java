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
	
		features = {"classpath:features/bestbuyapi"},
		glue = "product.bestbuyapi",
		plugin =
			{
					"pretty" , 
					"json:target/cucumber.json",
					"html:target/cucumber",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
		dryRun=false
		
		)
public class CucumberTest {




}

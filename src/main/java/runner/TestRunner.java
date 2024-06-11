package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\main\\java\\features", glue="stepdefinitions", monochrome=false ,plugin= {"pretty", "html:target/cucumber-reports.html"})
public class TestRunner {
	
}

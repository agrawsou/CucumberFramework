package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@target/failedrerun.text" }, glue = { "com.stepDefinition",
		"appHooks" }, plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedrun.text"}

)
public class FailedRunner {

}

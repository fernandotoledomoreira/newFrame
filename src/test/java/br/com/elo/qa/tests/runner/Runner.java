package br.com.elo.qa.tests.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = { "br.com.elo.qa.test.automation.tests.steps", 
				"br.com.elo.qa.test.automation.tests.hooks"},
		tags = { "@LoginCashBack"},
		plugin = {"pretty", "html:target/report-html", 
				"json:target/report.json",
				"br.com.elo.qa.test.automation.core.cucumber.reports.CustomFormatter:custom-formatter-output.txt"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = true,
		strict = true
		)	
public class Runner {
	
}


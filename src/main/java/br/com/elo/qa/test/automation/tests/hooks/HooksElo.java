package br.com.elo.qa.test.automation.tests.hooks;

import br.com.elo.qa.test.automation.tests.beans.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksElo {
	@Before
	public void beforeScenario(Scenario scenario) {
		//TODO: Colocar esta implementacao na classe CustomFormatter
//		Evidencia.setId(scenario.getId());
	}

	@After
	public void afterScenario(Scenario scenario) {
		DriverFactory.closeWebDriver();
	}
}

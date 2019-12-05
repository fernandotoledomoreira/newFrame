package br.com.elo.qa.test.automation.tests.steps;

import br.com.elo.qa.test.automation.tests.pages.HomePage;
import br.com.elo.qa.test.automation.tests.steps.base.BaseStep;
import cucumber.api.java.pt.Entao;

public class HomeSteps extends BaseStep {
	private HomePage home = new HomePage();

	@Entao("^seleciono a promocao vem vidao$")
	public void selecionoAPromocaoVemVidao() throws Throwable {
		home.particiarDaPromocao();
	}

}

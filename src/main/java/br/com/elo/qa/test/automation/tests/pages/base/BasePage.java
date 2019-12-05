package br.com.elo.qa.test.automation.tests.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import br.com.elo.qa.test.automation.core.selenium.screenshot.Screenshot;
import br.com.elo.qa.test.automation.tests.beans.DriverFactory;
import br.com.elo.qa.test.automation.tests.hooks.Evidencia;

public class BasePage {
	protected WebDriver driver;

	public BasePage() {
		String parBrowser = "chrome";
		String device = "iPhone X";

		switch (parBrowser) {
		case "chrome":
			driver = DriverFactory.getWebDriver();
			PageFactory.initElements(driver, this);
			break;
		case "chromeMobile":
			driver = DriverFactory.getWebDriver2(device);
			PageFactory.initElements(driver, this);
		default:
			break;
		}

	}

	protected void addReportScreenshot() {
		Evidencia.addConteudo(Screenshot.take(driver));
	}

	protected void addReportScreenshot(WebElement... elements) {
		Evidencia.addConteudo(Screenshot.take(driver, elements));
	}

	protected void addReportText(String description) {
		Evidencia.addConteudo(description);
	}

	/**
	 * Metoso para acessar o ambiente de QA da Cash Back
	 */

	public void acessarSiteEloCaixaHabitacional() {
		addReportText("Acessar o site Elo Cash Back Pernambucanas");
		driver.get("https://caixahabitacional.elo.com.br");
		addReportScreenshot();
	}

	/**
	 * Metoso para acessar o ambiente de QA da Cash Back
	 */

	public void acessarSiteEloCashBack() {
		addReportText("Acessar o site Elo Cash Back Pernambucanas");
		driver.get("https://cashback.valide.vc");
		addReportScreenshot();
	}

	/**
	 * Metoso para acessar o ambiente de QA da campanha Vem Vidao
	 */

	public void acessarSiteEloCampanhaVemVidao() {
		addReportText("Acessar o site Elo Campanha Vem Vidão");
		driver.get("https://desenv.elo.com.br/promocao-caixa-vem-vidao/home");
		addReportScreenshot();
	}

	/**
	 * Metodos base para acessar os ambientes e cadastro
	 */

	public void acessarSiteEloDesenv() {
		addReportText("Acessar o site ELO Desenv");
		driver.get("https://desenv.elo.com.br/");
		addReportScreenshot();
	}

	public void acessarSiteEloVirginia() {
		addReportText("Acessar o site ELO virginia");
		driver.get("https://www2.elo.com.br/");
		addReportScreenshot();
	}

	public void siteEloCadastroA() {
		addReportText("Cadastro A");
		driver.get(
				"https://elo.com.br/perfil/cadastrob?utm_expid=.Efkcot8rT7eMAT1_mvG3lg.1&utm_referrer=https%3A%2F%2Fdesenv.elo.com.br%2F");
		addReportScreenshot();
	}

	public void siteEloCadastroB() {
		addReportText("Cadastro B");
		driver.get(
				"https://elo.com.br/perfil/cadastrob?utm_expid=.Efkcot8rT7eMAT1_mvG3lg.1&utm_referrer=https%3A%2F%2Fdesenv.elo.com.br%2F");
		addReportScreenshot();
	}

	public void siteEloDesenvCadastroA() {
		addReportText("Cadastro A");
		driver.get(
				"https://desenv.elo.com.br/perfil/cadastro?utm_expid=.Efkcot8rT7eMAT1_mvG3lg.1&utm_referrer=https%3A%2F%2Fdesenv.elo.com.br%2F");
		addReportScreenshot();
	}

	public void siteEloDesenvCadastroB() {
		addReportText("Cadastro B");
		driver.get(
				"https://desenv.elo.com.br/perfil/cadastrob?utm_expid=.Efkcot8rT7eMAT1_mvG3lg.1&utm_referrer=https%3A%2F%2Fdesenv.elo.com.br%2F");
		addReportScreenshot();
	}

	public void siteEloVirginiaCadastroA() {
		addReportText("Cadastro A");
		driver.get(
				"https://www2.elo.com.br/perfil/cadastro?utm_expid=.Efkcot8rT7eMAT1_mvG3lg.1&utm_referrer=https%3A%2F%2Fwww2.elo.com.br%2F");
		addReportScreenshot();
	}

	public void siteEloVirginiaCadastroB() {
		addReportText("Cadastro B");
		driver.get(
				"https://www2.elo.com.br/perfil/cadastrob?utm_expid=.Efkcot8rT7eMAT1_mvG3lg.1&utm_referrer=https%3A%2F%2Fwww2.elo.com.br%2F");
		addReportScreenshot();
	}
}

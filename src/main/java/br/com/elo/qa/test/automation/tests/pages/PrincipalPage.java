package br.com.elo.qa.test.automation.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.elo.qa.test.automation.tests.pages.base.BasePage;

public class PrincipalPage extends BasePage {
	
	/**
	 * Mapeamento
	 */
	
	@FindBy(id = "header-cadastro")
	private WebElement linkCadastreSe;
	
	@FindBy(id = "header-acesso")
	private WebElement linkEntre;

	@FindBy (xpath = "//a[contains(text(),'Cadastrar meu cartão')]")
	private WebElement cadastrarMeuCartao;

	/**
	 * Metodos
	 */
	
	public void clicarCadastrarMeuCartao() {
		addReportText("Clicar no botão Cadastrar meu Cartão");
		cadastrarMeuCartao.click();
	}

	public void clicarCadastreSe() {
		addReportText("Clicar no botão Cadastre-se");
		linkCadastreSe.click();
	}

	public void clicarEntre() {
		addReportText("Clicar no botão Entre");
		linkEntre.click();
	}

}

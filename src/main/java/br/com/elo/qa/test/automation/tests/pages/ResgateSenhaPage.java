package br.com.elo.qa.test.automation.tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.elo.qa.test.automation.tests.pages.base.BasePage;

public class ResgateSenhaPage extends BasePage {

	/**
	 * Mapeamento
	 */

	@FindBy(id = "resgate-cpf")
	private WebElement campoCpf;
	
	@FindBy(id = "botaoResgateSenha")
	private WebElement botaoResgateSenha;
	
	@FindBy(id = "escolha-redefinicao-email")
	private WebElement opcaoViaEmail;
	
	@FindBy(id = "escolha-redefinicao-fone")
	private WebElement opcaoViaSms;
	
	@FindBy(id = "botaoEscolher")
	private WebElement botaoEscolher;
	
	@FindBy(xpath = "//div[@class = 'modal-content']//h5[@id = 'sucessoModalLabel']")
	private WebElement mensagemSucesso;

	/**
	 * Metodos
	 * @param valor
	 */
	
	public void preencherCampoCpf(String valor) {
		addReportText("Preencher campo CPF");
		campoCpf.sendKeys(valor);
	}
	
	public void clicarBotaoContinuar() {
		addReportText("Clicar no botão Continuar");
		botaoResgateSenha.click();
	}
	
	public void selecionarOpcaoViaEmail() {
		addReportText("Selecionar opção Email");
		opcaoViaEmail.click();
	}
	
	public void selecionarOpcaoViaSms() {
		addReportText("Selecionar opção Sms");
		opcaoViaSms.click();
	}
	
	public void clicarBotaoConfirmar() {
		addReportText("Clicar no botão Confirmar");
		botaoEscolher.click();
	}
	
	public String recuperarMensagemSucesso() {
		addReportText("Validar mensagem de Sucesso");
		String mensagem = mensagemSucesso.getAttribute("innerText");
		return mensagem;
	}

	public void acessarSiteElo() {
		LoginPage login = new LoginPage();
		login.clicarBotaoEntre();
		addReportScreenshot();
        login.clicarLinkEsqueciMinhaSenha();
	}

	public void processoRecuperarSenhaEmail (String valor) {
		preencherCampoCpf(valor);
		addReportScreenshot();
        clicarBotaoContinuar();
		selecionarOpcaoViaEmail();
		addReportScreenshot();
        clicarBotaoConfirmar();
	}
	
	public void processoRecuperarSenhaSms (String valor) {
		preencherCampoCpf(valor);
		addReportScreenshot();
        clicarBotaoContinuar();
		selecionarOpcaoViaSms();
		addReportScreenshot();
        clicarBotaoConfirmar();
    }
}

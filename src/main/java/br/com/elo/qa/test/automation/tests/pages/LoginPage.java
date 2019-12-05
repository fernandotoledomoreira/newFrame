package br.com.elo.qa.test.automation.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.elo.qa.test.automation.core.selenium.webdriver.Command;
import br.com.elo.qa.test.automation.tests.pages.base.BasePage;

public class LoginPage extends BasePage {

	/**
	 * Mapeamento
	 */

	@FindBy(xpath = "//*[contains(text(),'Entre')]")
	private WebElement botaoEntre;

	@FindBy(xpath = "//div[@class='menu']//a[contains(text(),'Entre')]")
	private WebElement botaoEntreCashBack;

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement botaoLogin;

	@FindBy(xpath = "//a[contains(text(),'Esqueci minha senha')]")
	private WebElement linkEsqueciMinhaSenha;

	@FindBy(xpath = "//form[@id='form-login']//input[@id='cpf']")
	private WebElement campoCpfCaixa;

	@FindBy(id = "cpf")
	private WebElement campoCpf;

	@FindBy(id = "password")
	private WebElement campoSenha;

	@FindBy(id = "btn-login")
	private WebElement campoEntrar;

	@FindBy(xpath = "//nav[@id='block-perfildesktop']//a[@href='/perfil/home']")
	private WebElement telaCarregada;

	@FindBy(xpath = "//div[@id='modalErroLogin']//div[@class = 'modal-dialog']//h5[@id = 'erroModalLabel']")
	private WebElement cpfInvalido;

	@FindBy(xpath = "")
	private WebElement dadosIncorretos;

	@FindBy(xpath = "")
	private WebElement senhaInvalida;

	@FindBy(xpath = "")
	private WebElement campoSenhaSemPreenchimento;

	/**
	 * Metodos
	 */

	public void preencherCampoCpfCaixa(String cpf) {
		addReportText("Preencher campo cpf");
		campoCpfCaixa.sendKeys(cpf);
	} 

	public void clicarBotaoLogin() {
		addReportText("Clique no botão Login");
		botaoLogin.click();
	} 

		public void botaoEntreCashBack() {
		addReportText("Clique no botão Entre");
		botaoEntreCashBack.click();
	} 

	public void clicarLinkEsqueciMinhaSenha() {
		addReportText("Clique no botão esqueci minha senha");
		linkEsqueciMinhaSenha.click();
	}

	public void preencherCampoCpf(String cpf) {
		addReportText("Preenche o campo CPF");
		campoCpf.sendKeys(cpf);
	}

	public void preencherCampoSenha(String senha) {
		addReportText("Preenche o campo Senha");
		campoSenha.sendKeys(senha);
	}

	public void clicarCampoEntrar() {
		addReportText("Clique no botão Entrar");
		campoEntrar.click();
	}

	public void clicarBotaoEntre() {
		addReportText("Clique no botão Entre");
		botaoEntre.click();
	}

	public void validarTelaCarregada() throws Exception {
		addReportText("Valida se a pagina foi carrega com sucesso");
		
		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(), 'Olá, Yaman!')]"), 10)) {
			throw new Exception("Tela não carregada.");
		}
		addReportScreenshot();
	}

	public void validarTelaCarregadaVemVidao() throws Exception {
		addReportText("Valida se a pagina foi carrega com sucesso");
		
		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(),'Sair')]"), 10)) {
			throw new Exception("Tela não carregada.");
		}
		addReportScreenshot();
	}


	public void validarMensagemDeErro(String msgErro) throws Exception {
		addReportText("Valida se a pagina foi carrega com erro");

		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(),'"+ msgErro +"')]"), 10)) {
			throw new Exception("Mensagem :" + msgErro + "não encontrada.");
		}
		addReportScreenshot();
	}

	public void realizarLoginVemVidao(String cpf, String Senha) {
		acessarSiteEloCampanhaVemVidao();
		clicarBotaoLogin();
		preencherCampoCpf(cpf);
		preencherCampoSenha(Senha);
		addReportScreenshot(campoCpf, campoSenha);
		clicarCampoEntrar();
	}

	public void realizarLogin(String cpf, String Senha) {
		acessarSiteEloDesenv();
		clicarBotaoEntre();
		preencherCampoCpf(cpf);
		preencherCampoSenha(Senha);
		addReportScreenshot(campoCpf, campoSenha);
		clicarCampoEntrar();
	}

	public void realizarLoginCashback(String cpf, String Senha) {
		acessarSiteEloCashBack();
		botaoEntreCashBack();
		preencherCampoCpf(cpf);
		preencherCampoSenha(Senha);
		addReportScreenshot(campoCpf, campoSenha);
		clicarCampoEntrar();
	}

	public void realizarLoginCaixaHabitacional(String cpf, String Senha) {
		acessarSiteEloCaixaHabitacional();
		clicarBotaoLogin();
		preencherCampoCpfCaixa(cpf);
		preencherCampoSenha(Senha);
		addReportScreenshot(campoCpfCaixa, campoSenha);
		clicarCampoEntrar();
	}

}

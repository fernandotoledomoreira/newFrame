package br.com.elo.qa.test.automation.tests.pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.elo.qa.test.automation.core.selenium.webdriver.Command;
import br.com.elo.qa.test.automation.tests.pages.base.BasePage;
import cucumber.api.DataTable;

public class CadastroPage extends BasePage {

	/**
	 * Mapeamento
	 */
	
	@FindBy(xpath = "//*[contains(text(), 'Cadastrar meu cartão')]")
	private WebElement botaoCadastreMeuCartao;
	@FindBy(id = "btn-register")
	private WebElement botaoCadastrarCashBack;

	@FindBy(id = "password_register_confirmation")
	private WebElement campoConfirmarSenhaCashBack; 

	@FindBy(id = "password_register")
	private WebElement campoSenhaCashBack;

	@FindBy(id = "email")
	private WebElement campoEmailCashBack;

	@FindBy(id = "phone")
	private WebElement campoCalularCashBack;

	@FindBy(id = "addCreditCardYear")
	private WebElement campoAnoCashBack;

	@FindBy(id = "addCreditCardMonth")
	private WebElement campoMesCashBack;
	 
	@FindBy(id = "cpf_register")
	private WebElement campoCpfCashBack;

	@FindBy(id = "first_name")
	private WebElement campoNomeCashBack;

	@FindBy(id = "last_name")
	private WebElement campoSobrenomeCashBack;

	@FindBy(id = "number_card")
	private WebElement campoCartaoCashBack;

	@FindBy(xpath = "//div[@class='menu']//a[contains(text(), 'Cadastre-se')]")
	private WebElement botaoCadastreSe;

	@FindBy(id = "botaoCadastroUsuario")
	private WebElement botaoCadastroUsuario;

	@FindBy(id = "botaoCadastroCartao")
	private WebElement botaoCadastroCartao;

	@FindBy(id = "cadastro-cpf")
	private WebElement campoCpf;

	@FindBy(id = "nomeP")
	private WebElement campoNomeCompleto;

	@FindBy(id = "cadastro-email")
	private WebElement campoEmail;

	@FindBy(xpath = "//div[@class='item-formulario']//input[@placeholder='* Confirmação de e-mail']")
	private WebElement campoConfirmacaoEmail;

	@FindBy(id = "nova-senha")
	private WebElement campoSenha;

	@FindBy(id = "repetir-senha")
	private WebElement campoRepetirSenha;

	@FindBy(id = "numero-cartao")
	private WebElement campoNumeroCartao;

	@FindBy(xpath = "//a[@id='selected-item']//span[contains(text(),'Mês')]")
	private WebElement campoMes;

	@FindBy(xpath = "//a[@id='selected-item']//span[contains(text(),'Ano')]")
	private WebElement campoAno;

	@FindBy(id = "telefone")
	private WebElement campoCelular;

	@FindBy(xpath = "//div[@id='modalErroCadastroUsuario']//div[@class = 'modal-content']//h5[@id = 'erroModalLabel']")
	private WebElement erroModalLabel;

	@FindBy(xpath = "//div[@id='modalErroCadastroCartao']//div[@class = 'modal-content']//h5[@id = 'erroModalLabel']")
	private WebElement erroModalLabelCartao;

	@FindBy(xpath = "//div[@class = 'modal-content']//h5[@id = 'sucessoModalLabel']/p")
	private WebElement sucessoModalLabel;

	@FindBy(xpath = "//div[@class = 'modal-header']//h5[@id = 'sucessoModalLabel']")
	private WebElement sucessoModalLabelVemVidao;

	@FindBy(xpath = "//div[@id='modalErroCadastroUsuario']//div[@class = 'modal-content']//a[@class = 'close']")
	private WebElement linkTentarNovamenteErro;

	/**
	 * Metodos
	 */

	public void clicarBotaoCadastreMeuCartao() {
		addReportText("Clicar no Botão cadastre meu cartaão");
		botaoCadastreMeuCartao.click();
	} 

	public void clicarBotaoCadastreSe() {
		addReportText("Clique no botão Cadastre-se");
		botaoCadastreSe.click();
	}

	public void clicarBotaoCadastrar() {
		addReportText("Clique no botão Cadastrar");
		botaoCadastroUsuario.click();
	}

	public void clicarBotaoFinalizar() {
		addReportText("Cliquei no botão Finalizar");
		botaoCadastroCartao.click();
	}

	public void preencherCampoCpf(String valor) {
		addReportText("Preencher o campo CPF");
		campoCpf.sendKeys(valor);
	}

	public void preencherCampoNomeCompleto(String valor) {
		addReportText("Preencher o campo Nome Completo");
		campoNomeCompleto.sendKeys(valor);
	}

	public void preencherCampoEmail(String valor) {
		addReportText("Preencher o campo E-mail");
		campoEmail.sendKeys(valor);
	}

	public void preencherCampoConfirmacaoEmail(String valor) {
		addReportText("Preencher o campo Confirmar E-mail");
		campoConfirmacaoEmail.sendKeys(valor);
	}

	public void preencherCampoSenha(String valor) {
		addReportText("Preencher campo Senha");
		campoSenha.sendKeys(valor);
	}

	public void preencherCampoRepetirSenha(String valor) {
		addReportText("Preencher campo Repitir Senha");
		campoRepetirSenha.sendKeys(valor);
	}

	public void preencherCampoNumeroCartao(String valor) {
		addReportText("Preencher campo Numero Cartao");
		campoNumeroCartao.sendKeys(valor);
	}

	public void selecionarMesVencimento(String valor) {
		addReportText("Seleciona Mes do Vencimento");
		campoMes.click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//span[contains(text(),'" + valor + "')]/..")).click();
	}

	public void selecionarAnoVencimento(String valor) {
		addReportText("Seleciona Ano do Vencimento");
		campoAno.click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//span[contains(text(),'" + valor + "')]/..")).click();
	}

	public void preencherCampoCelular(String valor) {
		addReportText("Preencher campo Celular");
		campoCelular.sendKeys(valor);
	}

	public String recuperarMensagemSucesso() {
		addReportText("Mensagem de Sucesso");
		String mensagem = sucessoModalLabel.getAttribute("innerText");
		addReportScreenshot();
		return mensagem.trim();
		
	}

	public String recuperarMensagemSucessoVemVidao() {
		addReportText("Mensagem de Sucesso");
		String mensagem = sucessoModalLabelVemVidao.getAttribute("innerText");
		addReportScreenshot();
		return mensagem.trim();
		
	}

	public String recuperarMensagemErroUser() {
		addReportText("Mensagem de erro Usuário");
		String mensagem = erroModalLabel.getAttribute("innerText");
		addReportScreenshot();
		return mensagem.trim();
	}

	public String recuperarMensagemErroCartao() {
		addReportText("Mensagem de erro Cartão");
		String mensagem = erroModalLabelCartao.getAttribute("innerText");
		return mensagem.trim();
	}

	public String verificarMensagemErroCampo(String valor) {
		addReportText("Verificar mensagem de erro");
		String xPath = "//*[*[@id='" + valor + "']]/label[contains(@style, 'color: rgb(255, 0, 0)')]";
		String mensagem = null;
		boolean enabled = false;

		if (valor.equals("* Confirmação de e-mail"))
			xPath = "//*[*[@placeholder='* Confirmação de e-mail']]/label[contains(@style, 'color: rgb(255, 0, 0)')]";
		if (valor.equals("selected-item"))
			xPath = "//*[*[@id='selected-item']]/../label[contains(@style, 'color: rgb(255, 0, 0)')]";

		if (((Command) driver).existsElement(By.xpath(xPath), 10)) {
			enabled = driver.findElement(By.xpath(xPath)).isEnabled();
			if (enabled == true) {
				mensagem = driver.findElement(By.xpath(xPath)).getAttribute("innerText");
			}
		}
		addReportScreenshot();

		return mensagem;
	}

	public void clicarLinkTentarNovamenteErro() {
		addReportText("Clicar no botão Tentar Novamente");
		linkTentarNovamenteErro.click();
	}

	public void acessarSiteElo() {
		acessarSiteEloVirginia();
	}

	public void preencherDadosUsuario(DataTable table) {
		addReportText("Preencher dados do Usuário");
		List<List<String>> data = table.raw();
		String campo = null;
		String valor = null;

		for (int i = 0; i < data.size(); i++) {
			campo = data.get(i).get(0).toString();
			valor = data.get(i).get(1).toString();

			switch (campo) {
			case "CPF":
				preencherCampoCpf(valor);
				break;
			case "Nome Completo":
				preencherCampoNomeCompleto(valor);
				break;
			case "E-mail":
				preencherCampoEmail(valor);
				break;
			case "Confirmação de e-mail":
				preencherCampoConfirmacaoEmail(valor);
				break;
			case "Criar Senha":
				preencherCampoSenha(valor);
				addReportScreenshot();
				break;
			case "Repetir senha":
				preencherCampoRepetirSenha(valor);
				break;
			default:
				System.out.println("O campo não é válido!");
			}
		}

		
		clicarBotaoCadastrar();
	}

	public void preencherDadosCartao(DataTable table) {
		addReportText("Preencher dados do Cartão");
		List<List<String>> data = table.raw();
		String campo = null;
		String valor = null;

		for (int i = 0; i < data.size(); i++) {
			campo = data.get(i).get(0).toString();
			valor = data.get(i).get(1).toString();

			switch (campo) {
			case "Número do cartão":
				preencherCampoNumeroCartao(valor);
				break;
			case "Mês":
				selecionarMesVencimento(valor);
				break;
			case "Ano":
				selecionarAnoVencimento(valor);
				break;
			case "Celular":
				preencherCampoCelular(valor);
				break;
				
			default:
				System.out.println("O campo não é válido!");
			}
		}
		addReportScreenshot();
		clicarBotaoFinalizar();
	}

	public void validarMensagemSucesso(String mensagemEsperada) {
		String mensagemExibida = recuperarMensagemSucesso();
		assertEquals(mensagemEsperada, mensagemExibida);
	}

	public void validarMensagemSucessoVemVidao(String mensagemEsperada) {
		String mensagemExibida = recuperarMensagemSucessoVemVidao();
		assertEquals(mensagemEsperada, mensagemExibida);
	}

	public void validarMensagemErroUsuario(String mensagemEsperada) {
		String mensagemExibida = recuperarMensagemErroUser();
		assertEquals(mensagemEsperada, mensagemExibida);
	}

	public void validarMensagemErroCampo(String mensagemEsperada) {
		String valor = null;
		switch (mensagemEsperada) {
		case "Confira o campo Nome completo":
			valor = "nomeP";
			break;
		case "Confira o campo CPF":
			valor = "cadastro-cpf";
			break;
		case "Confira o campo E-mail":
			valor = "cadastro-email";
			break;
		case "Confira o campo Confirmar e-mail":
			valor = "* Confirmação de e-mail";
			break;
		case "Confira o campo Criar senha":
			valor = "nova-senha";
			break;
		case "Confira o campo Repetir senha":
			valor = "repetir-senha";
			break;
		case "Confira o campo Número do Cartão":
			valor = "numero-cartao";
			break;
		case "Confira o campo Vencimento":
			valor = "selected-item";
			break;
		default:
			System.out.println("Mensagem não é válida!");
		}
		addReportScreenshot();

		CadastroPage cadastro = new CadastroPage();
		cadastro.clicarLinkTentarNovamenteErro();

		String mensagemExibida = cadastro.verificarMensagemErroCampo(valor);

		assertEquals(mensagemEsperada, mensagemExibida);
		addReportScreenshot();
	}

	public void validarMensagemErroCartao(String mensagemEsperada) {
		String mensagemExibida = recuperarMensagemErroCartao();
		assertEquals(mensagemEsperada, mensagemExibida);
		addReportScreenshot();
	}

	public void validarMensagemErro(String mensagemEsperada) {
		PerfilPage perfil = new PerfilPage();
		String mensagemExibida = perfil.validarMensagemErroCartao();
		assertEquals(mensagemEsperada, mensagemExibida);
		addReportScreenshot();
	}

	public void realizarCadastroCashBack(String cpf, String nome, String sobrenome, String cartao, String mes, String ano, String celular, String email, String senha, String confSenha) {
		clicarBotaoCadastreSe();
		preencherCampoCofCashBack(cpf);
		preencherCampoNomeCashBack(nome);
		preencherCampoSobrenomeCashBack(sobrenome);
		preencherCampoCartaoCashBack(cartao);
		addReportScreenshot();
		preencherCampoMesCashBack(mes);
		preencherCampoAnoCashBack(ano);
		preencherCampoCelularCashBack(celular);
		preencherCampoEmailCashBack(email);
		preencherCampoSenhaCashBack(senha);
		preencherCampoConfirmarSenhaCashBack(confSenha);
		addReportScreenshot();
		clicarBotaoCadastrarCashBack();
	}

	public void realizarCadastroCaixaHabitacional(String cpf, String nome, String sobrenome, String cartao, String mes, String ano, String celular, String email, String senha, String confSenha) {
		clicarBotaoCadastreMeuCartao();
		preencherCampoCofCashBack(cpf);
		preencherCampoNomeCashBack(nome);
		preencherCampoSobrenomeCashBack(sobrenome);
		preencherCampoCartaoCashBack(cartao);
		addReportScreenshot();
		preencherCampoMesCashBack(mes);
		preencherCampoAnoCashBack(ano);
		preencherCampoCelularCashBack(celular);
		preencherCampoEmailCashBack(email);
		preencherCampoSenhaCashBack(senha);
		preencherCampoConfirmarSenhaCashBack(confSenha);
		addReportScreenshot();
		clicarBotaoCadastrarCashBack();
	}

	public void preencherCampoCofCashBack(String cpf) {
		addReportText("Preencher o campo Cpf");
		campoCpfCashBack.sendKeys(cpf);
	}

	public void preencherCampoNomeCashBack(String nome) {
		addReportText("Prenchar o campo nome");
		campoNomeCashBack.sendKeys(nome);
	}

	public void preencherCampoSobrenomeCashBack(String sobrenome) {
		addReportText("Preencher o campo sobrenome");
		campoSobrenomeCashBack.sendKeys(sobrenome);
	}

	public void preencherCampoCartaoCashBack(String cartao) {
		addReportText("Preencher o campor cartão");
		campoCartaoCashBack.sendKeys(cartao);
	}

	public void preencherCampoMesCashBack(String mes) {
		addReportText("Preencher o campo mês");
		campoMesCashBack.click();
		driver.findElement(By.xpath("//select[@id='addCreditCardMonth']//option[contains(text(), '"+ mes +"')]")).click();
	}

	public void preencherCampoAnoCashBack(String ano) {
		addReportText("Preencher o campo Ano");
		campoAnoCashBack.click();
		driver.findElement(By.xpath("//select[@id='addCreditCardYear']//option[contains(text(), '"+ ano +"')]")).click();
	}

	public void preencherCampoCelularCashBack(String celular) {
		addReportText("Preenchar o campo celular");
		campoCalularCashBack.sendKeys(celular);
	}

	public void preencherCampoEmailCashBack(String email) {
		addReportText("Preencher o campo email");
		campoEmailCashBack.sendKeys(email);
	}

	public void preencherCampoSenhaCashBack(String senha) {
		addReportText("Preencher o campo senha");
		campoSenhaCashBack.sendKeys(senha);
	}

	public void preencherCampoConfirmarSenhaCashBack(String confSenha) {
		addReportText("Preencher o campo confirmar senha");
		campoConfirmarSenhaCashBack.sendKeys(confSenha);
	}

	public void clicarBotaoCadastrarCashBack() {
		addReportText("Clicar no botão cadastrar");
		botaoCadastrarCashBack.click();
	}

	public void validarMensagemCashBack(String msg) throws Exception {
		addReportText("Valida se a pagina foi carrega");

		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(),'"+ msg +"')]"), 10)) {
			throw new Exception("Mensagem :" + msg + "não encontrada.");
		}
		addReportScreenshot();
	}

	public void validarMensagemCaixaHabitacional(String msg) throws Exception {
		addReportText("Valida se a pagina foi carrega");

		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(),'"+ msg +"')]"), 10)) {
			throw new Exception("Mensagem :" + msg + "não encontrada.");
		}
		addReportScreenshot();
	}

}

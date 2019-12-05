package br.com.elo.qa.test.automation.tests.pages;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.elo.qa.test.automation.tests.pages.base.BasePage;

public class PerfilPage extends BasePage {

	/**
	 * Mapeamento
	 */

	@FindBy(id = "bt-cadastro")
	private WebElement botaoCadastrarCartao;

	@FindBy(id = "numero-cartao")
	private WebElement campoNumeroCartao;

	@FindBy(id = "botaoCadastrarCartao")
	private WebElement botaoCadastrarCartaoAdicionar;

	@FindBy(xpath = "//div[@class='modal-content']//h5[@id='sucessoModalLabel']")
	private WebElement sucessoModalLabel;

	@FindBy(id = "btn-add-cartao")
	private WebElement botaoAdicionarCartao;

	@FindBy(xpath = "//nav[@id='block-perfildesktop']//a[@href='/perfil/cartoes']")
	private WebElement linkCartoesEBeneficios;

	@FindBy(xpath = "//div[@id='modalErroCadastroCartao']//*[contains(text(),'Ops! Algo deu errado. Por favor, tente novamente.')]")
	private WebElement mensagemErro;

	/**
	 * Metodos
	 */

	public void clicarBotaoCadastrarCartao() {
		addReportText("Clicar no botão Cadastrar Cartão");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		botaoCadastrarCartao.click();
	}

	public void preencherCampoNumeroCartao(String valor) {
		addReportText("Preencher campo Número do Cartão");
		campoNumeroCartao.sendKeys(valor);
	}

	public void clicarBotaoCadastrarCartaoAdicionar() {
		addReportText("Clicar no botão Adicionar Cartão");
		botaoCadastrarCartaoAdicionar.click();
	}

	public String recuperarMensagemSucesso() {
		addReportText("Mensagem de Sucesso");
		String mensagem = sucessoModalLabel.getAttribute("innerText");
		return mensagem.trim();
	}

	public void clicarLinkCartoesBeneficios() {
		addReportText("Clicar em Cartões e Beneficios");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		linkCartoesEBeneficios.click();
	}

	public void clicarBotaoAdicionarCartao() {
		addReportText("Clicar no botão Adicionar Cartão");
		botaoAdicionarCartao.click();
	}

	public String validarMensagemErroCartao() {
		addReportText("Validar mensagem de Erro no Cartão");
		return mensagemErro.getAttribute("innerText").trim();
	}

	public void cadastrarCartao(String numCartao) {
		clicarBotaoCadastrarCartao();
		preencherCampoNumeroCartao(numCartao);
		addReportScreenshot(campoNumeroCartao);
		clicarBotaoCadastrarCartaoAdicionar();
	}

	public void validarMensagemSucesso(String mensagemEsperada) {
		String mensagemExibida = recuperarMensagemSucesso();
		assertEquals(mensagemEsperada, mensagemExibida);
		addReportScreenshot();
	}

	public void cadastrarNovoCartao(String numCartao) {
		clicarLinkCartoesBeneficios();
		clicarBotaoAdicionarCartao();
		addReportScreenshot();
		preencherCampoNumeroCartao(numCartao);
		addReportScreenshot();
		clicarBotaoCadastrarCartaoAdicionar();
	}

}

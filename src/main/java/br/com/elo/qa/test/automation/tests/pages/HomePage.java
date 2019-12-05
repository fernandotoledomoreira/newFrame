package br.com.elo.qa.test.automation.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import br.com.elo.qa.test.automation.core.selenium.webdriver.Command;
import br.com.elo.qa.test.automation.tests.pages.base.BasePage;

public class HomePage extends BasePage {

	/**
	 * Mapeamento
	 */

	@FindBy(xpath = "//span[@class='user-msg color-white']/a")
	private WebElement linkUsuario;

	@FindBy(xpath = "//nav[@id='block-perfil']//a[@href='/perfil/cartoes']")
	private WebElement linkCartoesBeneficios;

	@FindBy(xpath = "//*[contains(text(),'Participe')]")
	private WebElement linkParticipePromocao;

	@FindBy(id = "btn-continuar")
	private WebElement botaoConcluir;

	/**
	 * Metodos
	 */

	public void clicarCartoesBeneficiosUsuario() {
		addReportText("Clicar em Cartões e Beneficios do Usuário");
		Actions action = new Actions(driver);
		action.moveToElement(linkUsuario).moveToElement(linkCartoesBeneficios).click().build().perform();
	}

	public void clicarBotaoParticipe() throws Exception{
		addReportText("Clicar no Botão Participe");
		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(),'Participe')]"), 10)) {
			throw new Exception("Cadastro não Concluido.");
		}
		linkParticipePromocao.click();
	}

	public void clicarBotaoConcluir() {
		addReportText("Clicar no Botão Concluir");
		botaoConcluir.click();
	}

	public void validarCadastroConcluido() throws Exception {
		addReportText("Validar Cadastro Concluido");
		Command cmd = (Command) driver;
		if (!cmd.existsElement(By.xpath("//*[contains(text(),'Cadastro concluído!')]"), 10)) {
			throw new Exception("Cadastro não Concluido.");
		}
	}

	public void particiarDaPromocao() throws Exception {
		clicarBotaoParticipe();
		addReportScreenshot();
		clicarBotaoConcluir();
		validarCadastroConcluido();
		addReportScreenshot();
	}

}

package br.com.elo.qa.test.automation.tests.steps;

import static org.junit.Assert.assertEquals;

import br.com.elo.qa.test.automation.tests.pages.ResgateSenhaPage;
import br.com.elo.qa.test.automation.tests.steps.base.BaseStep;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RecuperacaoSenhaSteps extends BaseStep {
	private ResgateSenhaPage resgate = new ResgateSenhaPage();

	@Dado("^que estou na tela de resgate de senha$")
	public void queEstouNaTelaDeResgateDeSenha() throws Throwable {
		resgate.acessarSiteElo();
	}

	@Quando("^informo o CPF \"([^\"]*)\" para recuperar a senha via e-mail$")
	public void informoOCPFParaRecuperarASenhaViaEMail(String valor) throws Throwable {
		resgate.processoRecuperarSenhaEmail(valor);
	}

	@Quando("^informo o CPF \"([^\"]*)\" para  recuperar a senha via sms$")
	public void informoOCPFParaRecuperarASenhaViaSms(String valor) throws Throwable {
		resgate.processoRecuperarSenhaSms(valor);
	}

	@Entao("^exibe a mensagem \"([^\"]*)\"$")
	public void exibeAMensagem(String mensagemEsperada) throws Throwable {
		String mensagemExibida = new ResgateSenhaPage().recuperarMensagemSucesso();
		assertEquals(mensagemEsperada, mensagemExibida);
	}

}

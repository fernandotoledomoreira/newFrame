package br.com.elo.qa.test.automation.tests.steps;

import br.com.elo.qa.test.automation.tests.pages.LoginPage;
import br.com.elo.qa.test.automation.tests.steps.base.BaseStep;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginSteps extends BaseStep {
	private LoginPage login = new LoginPage();

	@Quando("^realizo login com os dados \"([^\"]*)\" e \"([^\"]*)\"$")
	public void realizoLoginComOsDadosE(String arg1, String arg2) throws Throwable {
		login.realizarLogin(arg1, arg2);
	}

	@Entao("^o login foi realizado com sucesso$")
	public void oLoginFoiRealizadoComSucesso() throws Throwable {
		login.validarTelaCarregadaVemVidao();
	}

	@Entao("^exibe a seguinte mensagem de erro \"([^\"]*)\"$")
	public void exibeASeguinteMensagemDeErro(String arg1) throws Throwable {
		login.validarMensagemDeErro(arg1);
	}

	@Quando("^realizo login com os dados \"([^\"]*)\" e \"([^\"]*)\" no site cash back$")
	public void realizoLoginComOsDadosENoSiteCashBack(String cpf, String Senha) throws Throwable {
		login.realizarLoginCashback(cpf, Senha);
	}

	@Entao("^o login foi realizado com sucesso no site cash back$")
	public void oLoginFoiRealizadoComSucessoNoSiteCashBack() throws Throwable {
		login.validarTelaCarregada();
	}

	@Entao("^exibe a seguinte mensagem de erro \"([^\"]*)\" no site cash back$")
	public void exibeASeguinteMensagemDeErroNoSiteCashBack(String msgErro) throws Throwable {
		login.validarMensagemDeErro(msgErro);
	}

	@Quando("^realizo login com os dados \"([^\"]*)\" e \"([^\"]*)\" no site caixa habitacional$")
	public void realizoLoginComOsDadosENoSiteCaixaHabitacional(String cpf, String Senha) throws Throwable {
		login.realizarLoginCaixaHabitacional(cpf, Senha);
	}

	@Entao("^o login foi realizado com sucesso no site caixa habitacional$")
	public void oLoginFoiRealizadoComSucessoNoSiteCaixaHabitacional() throws Throwable {
		login.validarTelaCarregadaVemVidao();
	}

	@Entao("^exibe a seguinte mensagem de erro \"([^\"]*)\" no site caixa habitacional$")
	public void exibeASeguinteMensagemDeErroNoSiteCaixaHabitacional(String msgErro) throws Throwable {
		login.validarMensagemDeErro(msgErro);
	}
	

}

package br.com.elo.qa.test.automation.tests.steps;

import br.com.elo.qa.test.automation.tests.pages.LoginPage;
import br.com.elo.qa.test.automation.tests.pages.PerfilPage;
import br.com.elo.qa.test.automation.tests.steps.base.BaseStep;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastroCartaoSteps extends BaseStep {
	
	private PerfilPage perfil = new PerfilPage();
	private LoginPage login = new LoginPage();

	@Dado("^que realizei login no site Elo com o CPF \"([^\"]*)\" e senha \"([^\"]*)\"$")
	public void queRealizeiLoginNoSiteEloComOCPFESenha(String cpf, String senha) throws Throwable {
	   login.realizarLogin(cpf, senha);
	}

	@Quando("^cadastro um cartão \"([^\"]*)\"$")
	public void cadastroUmCartão(String numCartao) throws Throwable {
		perfil.cadastrarCartao(numCartao);
	}

	@Entao("^retorna a mensagem \"([^\"]*)\"$")
	public void retornaAMensagem(String mensagemEsperada) throws Throwable {
		perfil.validarMensagemSucesso(mensagemEsperada);
	}

	@Quando("^cadastro um novo cartão \"([^\"]*)\"$")
	public void cadastroUmNovoCartão(String numCartao) throws Throwable {
		perfil.cadastrarNovoCartao(numCartao);
	}
}

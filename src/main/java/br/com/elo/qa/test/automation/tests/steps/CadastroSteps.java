package br.com.elo.qa.test.automation.tests.steps;

import br.com.elo.qa.test.automation.tests.pages.CadastroPage;
import br.com.elo.qa.test.automation.tests.pages.PrincipalPage;
import br.com.elo.qa.test.automation.tests.steps.base.BaseStep;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CadastroSteps extends BaseStep {

	private CadastroPage cadastro = new CadastroPage();
	PrincipalPage principal = new PrincipalPage();

	@Dado("^que estou na tela de cadastro$")
	public void queEstouNaTelaDeCadastro() throws Throwable {
		cadastro.acessarSiteEloCaixaHabitacional();
		// principal.clicarCadastrarMeuCartao();
	}

	@Quando("^preencho os dados da primeira etapa$")
	public void preenchoOsDadosDaPrimeiraEtapa(DataTable table) throws Throwable {
		cadastro.preencherDadosUsuario(table);
	}

	@Quando("^finalizo a segunda etapa$")
	public void finalizoSegundaEtapa(DataTable table) throws Throwable {
		cadastro.preencherDadosCartao(table);
	}

	@Entao("^a mensagem \"([^\"]*)\" é exibida$")
	public void aMensagemExibida(String mensagemEsperada) throws Throwable {
		cadastro.validarMensagemSucessoVemVidao(mensagemEsperada);
	}

	@Entao("^exibe a mensagem de erro \"([^\"]*)\"$")
	public void exibeAMensagemDeErro(String mensagemEsperada) throws Throwable {
		cadastro.validarMensagemErroUsuario(mensagemEsperada);
	}

	@Entao("^exibe a mensagem de erro \"([^\"]*)\" no cadastro de cartao$")
	public void exibeAMensagemDeErroNoCadastroDeCartao(String mensagemEsperada) throws Throwable {
		cadastro.validarMensagemErroCartao(mensagemEsperada);
	}

	@Entao("^exibe a mensagem de erro \"([^\"]*)\" no campo$")
	public void exibeAMensagemDeErroNoCampo(String mensagemEsperada) throws Throwable {
		cadastro.validarMensagemErroCampo(mensagemEsperada);
	}

	@Quando("^finalizo a segunda etapa sem preencher os dados do cartão$")
	public void finalizoASegundaEtapaSemPreencherOsDadosDoCartão() throws Throwable {
		new CadastroPage().clicarBotaoFinalizar();
	}

	@Entao("^retorna a mensagem de erro \"([^\"]*)\"$")
	public void retornaAMensagemDeErro(String mensagemEsperada) throws Throwable {
		cadastro.validarMensagemErro(mensagemEsperada);
	}

	@Quando("^preencho os dados para cadastro cash back \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" \"([^\"]*)\"$")
	public void preenchoOsDadosParaCadastroCashBack(String arg1, String cpf, String email, String senha,
			String confSenha, String cartao, String mes, String ano, String celular) throws Throwable {
		cadastro.realizarCadastroCashBack(cpf, arg1, arg1, cartao, mes, ano, celular, email, senha, confSenha);
	}

	@Entao("^a mensagem \"([^\"]*)\" é exibida para cash back$")
	public void aMensagemÉExibidaParaCashBack(String msg) throws Throwable {
		cadastro.validarMensagemCashBack(msg);
	}

	@Quando("^preencho os dados para cadastro caixa habitacional \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\" \"([^\"]*)\"$")
	public void preenchoOsDadosParaCadastroCaixaHabitacional(String arg1, String cpf, String email, String senha,
	String confSenha, String cartao, String mes, String ano, String celular) throws Throwable {
		cadastro.realizarCadastroCaixaHabitacional(cpf, arg1, arg1, cartao, mes, ano, celular, email, senha, confSenha);			
	}

	@Entao("^a mensagem \"([^\"]*)\" é exibida para caixa habitacional$")
	public void aMensagemÉExibidaParaCaixaHabitacional(String msg) throws Throwable {
		cadastro.validarMensagemCaixaHabitacional(msg);
	}
}

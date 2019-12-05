package br.com.elo.qa.test.automation.tests.hooks;

import java.util.LinkedList;

import br.com.elo.qa.test.automation.core.report.pdf.statements.Conteudo;
import br.com.elo.qa.test.automation.core.report.pdf.statements.Statement;

public class Evidencia {
	// TODO: Preparar o codigo para execucao paralela
	private static Conteudo conteudo = null;

	private Evidencia() {
	}

	public static void initialize() {
		if (conteudo == null) {
			conteudo = new Conteudo();
		}
	}

	public static void close() {
		conteudo = null;
	}

	public static Conteudo getConteudo() {
		return conteudo;
	}

	public static Boolean isFilled() {
		return conteudo != null;
	}

	public static String getStatus() {
		if (isFilled())
			return getConteudo().getStatus();
		else
			return null;
	}

	public static void setStatus(String status) {
		if (isFilled())
			getConteudo().setStatus(status);
	}

	public static void setFeature(String feature) {
		if (isFilled())
			getConteudo().setFeature(feature);
	}

	public static void setFuncionalidade(String funcionalidade) {
		if (isFilled())
			getConteudo().setFuncionalidade(funcionalidade);
	}

	public static String getCenario() {
		if (isFilled())
			return getConteudo().getCenario();
		else
			return null;
	}

	public static void setCenario(String cenario) {
		if (isFilled())
			getConteudo().setCenario(cenario);
	}

	public static String getNomeServ() {
		if (isFilled())
			return getConteudo().getNomeServ();
		else
			return null;
	}

	public static void setNomeServ(String nomeServ) {
		if (isFilled())
			getConteudo().setNomeServ(nomeServ);
	}

	public static String getIpServ() {
		if (isFilled())
			return getConteudo().getIpServ();
		else
			return null;
	}

	public static void setIpServ(String ipServ) {
		if (isFilled())
			getConteudo().setIpServ(ipServ);
	}

	public static String getUsuarioLogado() {
		if (isFilled())
			return getConteudo().getUsuarioLogado();
		else
			return null;
	}

	public static void setUsuarioLogado(String usuarioLogado) {
		getConteudo().setUsuarioLogado(usuarioLogado);
	}

	public static String getSistemaOperacional() {
		if (isFilled())
			return getConteudo().getSistemaOperacional();
		else
			return null;
	}

	public static void setSistemaOperacional(String sistemaOperacional) {
		getConteudo().setSistemaOperacional(sistemaOperacional);
	}

	public static LinkedList<Statement> getStatementsCapa() {
		if (isFilled())
			return getConteudo().getStatementsCapa();
		else
			return null;
	}

	public static void addConteudo(String description) {
		if (isFilled())
			getConteudo().addConteudo(description);
	}

	public static void addConteudo(byte[] image) {
		if (isFilled())
			getConteudo().addConteudo(image);
	}

	public static void addConteudo(String description, byte[] image) {
		if (isFilled())
			getConteudo().addConteudo(description, image);
	}

	public static void addTitulo(String description) {
		if (isFilled())
			getConteudo().addTitulo(description);
	}

	public static void addErro(String description) {
		if (isFilled())
			getConteudo().addErro(description);
	}

	public static void addErro(String description, byte[] image) {
		if (isFilled())
			getConteudo().addErro(description, image);
	}

	public static void addErro(Exception exception) {
		if (isFilled())
			getConteudo().addErro(exception);
	}

	public static void addErro(String description, Exception exception) {
		if (isFilled())
			getConteudo().addErro(description, exception);
	}

	public static void addErro(String description, Exception exception, byte[] image) {
		if (isFilled())
			getConteudo().addErro(description, exception, image);
	}

	public static void addErro(Exception exception, byte[] image) {
		if (isFilled())
			getConteudo().addErro(exception, image);
	}

	public static void addNewPage() {
		if (isFilled())
			getConteudo().addNewPage();
	}

	public static LinkedList<Statement> getStatementsConteudo() {
		return getConteudo().getStatementsConteudo();
	}

	public static String getId() {
		if (isFilled())
			return getConteudo().getId();
		else
			return null;
	}

	public static void setId(String id) {
		if (isFilled())
			getConteudo().setId(id);
	}

	public static String getTags() {
		if (isFilled())
			return getConteudo().getTags();
		else
			return null;
	}

	public static void setTags(String tags) {
		if (isFilled())
			getConteudo().setTags(tags);
	}
}

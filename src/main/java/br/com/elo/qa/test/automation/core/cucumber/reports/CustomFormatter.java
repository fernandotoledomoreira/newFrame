package br.com.elo.qa.test.automation.core.cucumber.reports;

import java.lang.reflect.Field;
import java.util.List;

import br.com.elo.qa.test.automation.core.report.pdf.Report;
import br.com.elo.qa.test.automation.core.selenium.screenshot.Screenshot;
import br.com.elo.qa.test.automation.tests.beans.DriverFactory;
import br.com.elo.qa.test.automation.tests.hooks.Evidencia;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

//TODO: Analisar a lentidao quando gera a envidencia
public class CustomFormatter implements Reporter, Formatter {
	private Feature feature;
	private String uri;
	
	public CustomFormatter(Appendable appendable) {
	}

	@Override
	public void uri(String uri) {
		this.uri = uri;
	}

	@Override
	public void feature(Feature feature) {
		this.feature = feature;
		//Inicializa a envidencia
		Evidencia.initialize();
	}

	/**
	 * Executado antes do cenario
	 */
	@Override
	public void scenario(Scenario scenario) {
		// Inicializa a evidencia
		Evidencia.initialize();
		Evidencia.setId(scenario.getId());
		Evidencia.setCenario(scenario.getName());
		Evidencia.setFuncionalidade(feature.getDescription());
		Evidencia.setFeature(uri);
		StringBuilder tags = new StringBuilder();
		scenario.getTags().forEach(p -> tags.append(p.getName() + "; "));
		Evidencia.setTags(tags.toString());
	}

	/**
	 * Executado apos a finalização do cenario
	 */
	@Override
	public void endOfScenarioLifeCycle(Scenario scenario) {
		try {
			// Salva a evidencia
			new Report().save(Evidencia.getConteudo());
			Evidencia.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Metodo executado apos o metodo before da Hooks
	 */
	@Override
	public void before(Match match, Result result) {
		// Caso o step falhe, deve-se adionar na evidencia
		if (!result.getStatus().equals("passed")) {
			Evidencia.setStatus(result.getStatus());
			Evidencia.addErro(result.getErrorMessage());
		}
	}
	
	@Override
	public void step(Step step) {
		//Evidencia.addTitulo(step.getKeyword() + step.getName());
	}

	/**
	 * Metodo executado apos o step ser executado
	 */
	@Override
	public void result(Result result) {

		// Caso o step falhe, deve-se adionar na evidencia
		if (!result.getStatus().equals("passed")) {
			Evidencia.setStatus(result.getStatus());
			Evidencia.addErro(result.getErrorMessage());

			// Caso exista um browser inicializado, deve-se tirar um print
			if (DriverFactory.isFilledWebDriver())
				Evidencia.addConteudo(Screenshot.take(DriverFactory.getWebDriver()));
		}
	}

	/**
	 * Metodo executado apos o metodo after da hooks
	 */
	@Override
	public void after(Match match, Result result) {
		// Caso o step falhe, deve-se adionar na evidencia
		if (!result.getStatus().equals("passed")) {
			Evidencia.setStatus(result.getStatus());
			Evidencia.addErro(result.getErrorMessage());
		}
	}

	/**
	 * Metodo executado antes do step
	 */
	@Override
	public void match(Match match) {
//		// Extrai a frase do match
//		try {
////			if (Evidencia.getFeature() == null || Evidencia.getFeature().isEmpty()
////					|| Evidencia.getFeature().equals("default")) {
////				Evidencia.setFeature(getValue(match, "featurePath", String.class));
////			}
//
			Step step = getValue(match, "step", Step.class);
			Evidencia.addTitulo(step.getKeyword() + step.getName());
//
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	}



	/**
	 * Metodo para extrair dados de um field via reflection
	 * 
	 * @param <T>  Tipo que será retornado
	 * @param obj  instancia do objeto que será extraido
	 * @param key  chave (nome) do field
	 * @param type Tipo retornado
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T getValue(Object obj, String key, Class<T> type) {
		try {
			Field field = obj.getClass().getDeclaredField(key);
			field.setAccessible(true);
			return (T) field.get(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	@Override
	public void embedding(String s, byte[] bytes) {
		//System.out.println("embedding(): s=");
	}

	@Override
	public void write(String s) {
		//System.out.println("write(): " + s);
	}

	@Override
	public void syntaxError(String state, String event, List<String> legalEvents, String uri, Integer line) {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	@Override
	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	@Override
	public void examples(Examples examples) {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	@Override
	public void startOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	@Override
	public void background(Background background) {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	

	@Override
	public void done() {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}

	@Override
	public void eof() {
		// TODO Auto-generated method stub
		//System.out.println("Teste");
	}
}
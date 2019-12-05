package br.com.elo.qa.test.automation.core.report.pdf.page;

import com.itextpdf.text.Document;

import br.com.elo.qa.test.automation.core.report.pdf.exceptions.PageException;
import br.com.elo.qa.test.automation.core.report.pdf.page.base.BasePage;
import br.com.elo.qa.test.automation.core.report.pdf.statements.Conteudo;

public class Pagina extends BasePage {
	
	public Pagina(Document document) {
		super(document);
	}
	
	public void addConteudo(Conteudo conteudo) throws PageException {
		addTableToEvidencePdf(conteudo.getStatementsCapa(), 4);
		addStatementToEvidencePdf(conteudo.getStatementsConteudo());
	}
}

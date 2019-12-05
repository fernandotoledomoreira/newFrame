package br.com.elo.qa.test.automation.core.report.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.elo.qa.test.automation.core.report.pdf.exceptions.PageException;
import br.com.elo.qa.test.automation.core.report.pdf.page.Header;
import br.com.elo.qa.test.automation.core.report.pdf.page.Pagina;
import br.com.elo.qa.test.automation.core.report.pdf.statements.Conteudo;

public class Report {
	private Document document = new Document();
	private PdfWriter writer;

	public void save(Conteudo conteudo) throws FileNotFoundException, DocumentException, PageException {
		String data = new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date());
		String path = "./evidence/teste" + data + ".pdf";

		document.open();
		document.setMargins(20, 20, 80, 20);
		createFolder(path);

		this.writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		Header event = new Header();
		writer.setPageEvent(event);

		document.open();

//		Conteudo conteudo = new Conteudo();
//		conteudo.addTitulo("Titulo 2");
//		conteudo.addConteudo("teste 2");
//		conteudo.addNewPage();
//		conteudo.addConteudo("teste 3");
//		conteudo.addConteudo("teste 4");
//		conteudo.addNewPage();
//		conteudo.addConteudo("teste 5");

		new Pagina(document).addConteudo(conteudo);

		document.close();
	}

	private void createFolder(String path) {
		File file = new File(path);
		File directory = file.getParentFile();

		if (!directory.exists()) {
			directory.mkdir();
		}
	}
}

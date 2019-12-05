package br.com.elo.qa.test.automation.core.report.pdf.page.base;

import java.util.LinkedList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import br.com.elo.qa.test.automation.core.report.pdf.exceptions.PageException;
import br.com.elo.qa.test.automation.core.report.pdf.statements.Statement;

public class BasePage {
	private Document document;

	public BasePage(Document document) {
		this.document = document;

	}

	protected void addTableToEvidencePdf(LinkedList<Statement> statements, int numColumns) throws PageException {
		try {
			PdfPTable table = new PdfPTable(numColumns);
			table.setSplitLate(false);
			table.setWidthPercentage(100);
			statements.stream().filter(p -> p.isFilled()).forEach(p -> {
				addContent(p, table);
			});
			addTable(table);
			addNewPage();
		} catch (Exception e) {
			throw new PageException("Erro ao adicionar o Statement na evidencia PDF.", e);
		}
	}

	protected void addStatementToEvidencePdf(LinkedList<Statement> statements) throws PageException {
		try {
			statements.stream().filter(p -> p.isFilled()).forEach(p -> {
				addContent(p);
			});
		} catch (Exception e) {
			throw new PageException("Erro ao adicionar o Statement na evidencia PDF.", e);
		}
	}

	protected void addNewPage() {
		document.newPage();
	}

	private void addContent(Statement statement) {
		PdfPTable table = new PdfPTable(1);
		table.setSplitLate(false);
		table.setWidthPercentage(100);
		addContent(statement, table);
		addTable(table);
	}

	private void addContent(Statement statement, PdfPTable table) {
		if ((statement.getDescription() != null && !statement.getDescription().isEmpty())
				|| statement.getImage() != null) {
			addText(statement, table);
			addImage(statement, table);
		}
		else {
			addNewPage();
		}
	}

	private void addText(Statement statement, PdfPTable table) {
		if (statement.getDescription() != null && !statement.getDescription().isEmpty()) {
			PdfPCell cell = new PdfPCell(new Phrase(statement.getDescription(), statement.getFont()));
			cell.setPaddingBottom(10f);
			cell.setBorder(statement.getBorder());
			cell.setHorizontalAlignment(statement.getHorizontalAlignment());
			cell.setVerticalAlignment(statement.getVerticalAlignment());

			if (statement.getColspan() != null)
				cell.setColspan(statement.getColspan());

			if (statement.getBackgroundColor() != null)
				cell.setBackgroundColor(statement.getBackgroundColor());

			table.addCell(cell);
		}
	}

//	public void addImage(Image image) throws DocumentException {
//		openDocument();
//		document.add(image);
//	}

	private void addImage(Statement statement, PdfPTable table) {
		if (statement.getImage() != null) {
			try {
				Image image = Image.getInstance(statement.getImage());
				int percent = 100;
				if (image.getWidth() < 900)
					percent = 50;
				PdfPCell cell = new PdfPCell(image);
				image.scalePercent(((this.document.getPageSize().getWidth() - this.document.leftMargin()
						- this.document.rightMargin()) / image.getWidth()) * percent);
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setPaddingBottom(10f);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			} catch (Exception e) {
			}
		}
	}

	private void openDocument() {
		if (!document.isOpen() == true) {
			document.open();
		}
	}

	private void addTable(PdfPTable table) {
		openDocument();
		try {
			document.add(table);
		} catch (DocumentException e) {
		}
	}
}

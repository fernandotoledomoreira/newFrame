package br.com.elo.qa.test.automation.core.report.pdf.exceptions;

public class PageException extends Exception {
	private static final long serialVersionUID = 1L;

	public PageException(String msg) {
		super(msg);
	}

	public PageException(Exception e) {
		super(e);
	}

	public PageException(String msg, Exception e) {
		super(msg, e);
	}
}

package br.com.elo.qa.test.automation.core.report.pdf.exceptions;

public class ImageException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ImageException(String msg) {
		super(msg);
	}

	public ImageException(Exception e) {
		super(e);
	}

	public ImageException(String msg, Exception e) {
		super(msg, e);
	}
}

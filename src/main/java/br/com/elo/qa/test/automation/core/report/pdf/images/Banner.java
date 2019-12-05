package br.com.elo.qa.test.automation.core.report.pdf.images;

import com.itextpdf.text.Image;

import br.com.elo.qa.test.automation.core.report.pdf.Report;

public class Banner {
	private static final Float SIZE_X = 550f;
	private static final Float SIZE_Y = 50f;
	private static Image img;

	private Banner() {
		try {
			img = Image.getInstance(Report.class.getResource("Banner.png"));
			img.scaleToFit(SIZE_X, SIZE_Y);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Image getImage() {
		if (img == null)
			new Banner();
		return img;
	}
}

package br.com.elo.qa.test.automation.core.report.pdf.statements;

import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

public class StatementImpl implements Statement {
	private Image image = null;
	private String description = null;
	private Font font = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
	private Date date = new Date();
	private Integer colspan = null;
	private BaseColor backgroundColor = null;
	private Integer horizontalAlignment = Element.ALIGN_LEFT;
	private Integer verticalAlignment = Element.ALIGN_MIDDLE;
	private Integer border = Rectangle.NO_BORDER;
	private Boolean newPage = false;

	public StatementImpl() {
	}

	public StatementImpl(String description) {
		this.description = description;
	}

	public StatementImpl(String description, Image image) {
		this.description = description;
		this.image = image;
	}

	public StatementImpl(Image image) {
		this.image = image;
	}

	@Override
	public Boolean isFilled() {
		if ((description != null && !description.isEmpty()) || image != null || newPage)
			return true;
		else
			return false;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void setFont(Font font) {
		this.font = font;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Integer getColspan() {
		return colspan;
	}

	@Override
	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	@Override
	public BaseColor getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(BaseColor backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public Integer getHorizontalAlignment() {
		return horizontalAlignment;
	}

	@Override
	public void setHorizontalAlignment(Integer horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	@Override
	public Integer getVerticalAlignment() {
		return verticalAlignment;
	}

	@Override
	public void setVerticalAlignment(Integer verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	@Override
	public Integer getBorder() {
		return border;
	}

	@Override
	public void setBorder(Integer border) {
		this.border = border;
	}

	@Override
	public Boolean getNewPage() {
		return newPage;
	}

	@Override
	public void setNewPage(Boolean newPage) {
		this.newPage = newPage;
	}
}

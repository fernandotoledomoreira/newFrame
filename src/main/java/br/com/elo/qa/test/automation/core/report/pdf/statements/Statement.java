package br.com.elo.qa.test.automation.core.report.pdf.statements;

import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;

public interface Statement {
	public Image getImage();

	public void setImage(Image image);

	public String getDescription();

	public void setDescription(String description);

	public Font getFont();

	public void setFont(Font font);

	public Date getDate();

	public void setDate(Date date);

	public Integer getColspan();

	public void setColspan(Integer colspan);

	public BaseColor getBackgroundColor();

	public void setBackgroundColor(BaseColor backgroundColor);

	public Integer getHorizontalAlignment();

	public void setHorizontalAlignment(Integer horizontalAlignment);

	public Integer getVerticalAlignment();

	public void setVerticalAlignment(Integer verticalAlignment);

	public Integer getBorder();

	public void setBorder(Integer border);

	public Boolean isFilled();

	public Boolean getNewPage();

	public void setNewPage(Boolean newPage);
}

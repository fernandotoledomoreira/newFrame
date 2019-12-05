package br.com.elo.qa.test.automation.core.report.pdf.statements;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

import br.com.elo.qa.test.automation.core.report.pdf.exceptions.ImageException;

public class Conteudo {
	private LinkedList<Statement> stmConteudo = new LinkedList<Statement>();
	private LinkedList<Statement> stmCapa = new LinkedList<Statement>();
	private String id = "default";
	private String tags = "default";
	private String feature = "default";
	private String funcionalidade = "default";
	private String cenario = "default";
	private String nomeServ = null;
	private String ipServ = null;
	private String usuarioLogado = null;
	private String sistemaOperacional = null;
	private String status = "passed";

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(String funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String getCenario() {
		return cenario;
	}

	public void setCenario(String cenario) {
		this.cenario = cenario;
	}

	public String getNomeServ() {
		return nomeServ;
	}

	public void setNomeServ(String nomeServ) {
		this.nomeServ = nomeServ;
	}

	public String getIpServ() {
		return ipServ;
	}

	public void setIpServ(String ipServ) {
		this.ipServ = ipServ;
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public LinkedList<Statement> getStatementsCapa() {
		try {
			if (nomeServ == null || nomeServ.isEmpty())
				nomeServ = InetAddress.getLocalHost().getHostName();

			if (usuarioLogado == null || usuarioLogado.isEmpty())
				usuarioLogado = System.getProperty("user.name");

			if (ipServ == null || ipServ.isEmpty())
				ipServ = InetAddress.getLocalHost().getHostAddress();

			if (sistemaOperacional == null || sistemaOperacional.isEmpty())
				sistemaOperacional = System.getProperty("os.name");
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}

		stmCapa.add(new CapaChave("Feature"));
		stmCapa.add(new CapaValor(feature));

		stmCapa.add(new CapaChave("ID"));
		stmCapa.add(new CapaValor(id));

		stmCapa.add(new CapaChave("Funcionalidade"));
		stmCapa.add(new CapaValor(funcionalidade, 3));

		stmCapa.add(new CapaChave("Cenario"));
		stmCapa.add(new CapaValor(cenario, 3));

		stmCapa.add(new CapaChave("Tags"));
		stmCapa.add(new CapaValor(tags, 3));

		stmCapa.add(new CapaChave("Nome Servidor"));
		stmCapa.add(new CapaValor(nomeServ));

		stmCapa.add(new CapaChave("Usuario Logado"));
		stmCapa.add(new CapaValor(usuarioLogado));

		stmCapa.add(new CapaChave("Ip do Servidor"));
		stmCapa.add(new CapaValor(ipServ));

		stmCapa.add(new CapaChave("Sistema Operacional"));
		stmCapa.add(new CapaValor(ipServ));

		stmCapa.add(new CapaChave("Status"));
		stmCapa.add(new CapaStatus(status, 3));

		StatementImpl newPage = new StatementImpl();
		newPage.setNewPage(true);
		stmCapa.add(newPage);

		return stmCapa;
	}

	public void addConteudo(String description) {
		stmConteudo.add(new ConteudoStatement(description));
	}

	public void addConteudo(byte[] image) throws ImageException {
		try {
			Image img = Image.getInstance(image);
			stmConteudo.add(new ConteudoStatement(img));
		} catch (BadElementException | IOException e) {
			throw new ImageException(e);
		}
	}

	public void addConteudo(String description, byte[] image) throws ImageException {
		try {
			Image img = Image.getInstance(image);
			stmConteudo.add(new ConteudoStatement(description, img));
		} catch (BadElementException | IOException e) {
			throw new ImageException(e);
		}
	}

	public void addTitulo(String description) {
		stmConteudo.add(new TituloStatement(description));
	}

	public void addErro(String description) {
		stmConteudo.add(new ErroStatement(description));
	}

	public void addErro(String description, byte[] image) throws ImageException {
		try {
			Image img = Image.getInstance(image);
			stmConteudo.add(new ErroStatement(description, img));
		} catch (BadElementException | IOException e) {
			throw new ImageException(e);
		}
	}

	public void addErro(Exception exception) {
		addErro(exception.getMessage());
	}

	public void addErro(String description, Exception exception) {
		addErro(description);
		addErro(exception.getMessage());
	}

	public void addErro(String description, Exception exception, byte[] image) throws ImageException {
		addErro(description);
		addErro(exception.getMessage(), image);
	}

	public void addErro(Exception exception, byte[] image) throws ImageException {
		addErro(exception.getMessage(), image);
	}

	public void addNewPage() {
		StatementImpl statement = new StatementImpl();
		statement.setNewPage(true);
		stmConteudo.add(statement);
	}

	public LinkedList<Statement> getStatementsConteudo() {
		return stmConteudo;
	}

	private class ErroStatement extends StatementImpl implements Statement {
		private Font fonte = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.RED);

		public ErroStatement(String description) {
			super(description);
			setFont(fonte);
		}

		public ErroStatement(String description, Image image) {
			super(description, image);
			setFont(fonte);
		}
	}

	private class ConteudoStatement extends StatementImpl implements Statement {
		private Font fonte = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

		public ConteudoStatement(String description) {
			super(description);
			setFont(fonte);
		}

		public ConteudoStatement(String description, Image image) {
			super(description, image);
			setFont(fonte);
		}

		public ConteudoStatement(Image image) {
			super(image);
			setFont(fonte);
		}
	}

	private class TituloStatement extends StatementImpl implements Statement {
		private Font fonte = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);

		public TituloStatement(String description) {
			super(description);
			setFont(fonte);
		}
	}

	private class CapaValor extends StatementImpl implements Statement {
		private final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

		public CapaValor(String description) {
			super(description);
			setFont(FONTE);
			setBorder(Rectangle.BOX);
		}

		public CapaValor(String description, int colspan) {
			super(description);
			setFont(FONTE);
			setColspan(colspan);
			setBorder(Rectangle.BOX);
		}
	}

	private class CapaChave extends StatementImpl implements Statement {
		private final Font FONTE = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.BLACK);

		public CapaChave(String description) {
			super(description);
			setFont(FONTE);
			setBorder(Rectangle.BOX);
		}

//		public CapaChave(String description, int colspan) {
//			super(description);
//			setFont(FONTE);
//			setColspan(colspan);
//			setBorder(Rectangle.BOX);
//		}
	}

	private class CapaStatus extends StatementImpl implements Statement {
		public CapaStatus(String status, int colspan) {
			super(status);

			if (status.equals("passed")) {
				setFont(FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.GREEN));
			} else if (status.equals("skipped")) {
				setFont(FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.YELLOW));
			} else {
				setFont(FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.RED));
			}

			setColspan(colspan);
			setBorder(Rectangle.BOX);
		}
	}
}

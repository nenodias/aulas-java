package draw.canvas;

import java.awt.Shape;

public class FormaBase {

	private Shape forma;
	private boolean ativo;
	private double x;
	private double y;
	private double velocidadeX;
	private double velocidadeY;
	private double anguloMovimentacao;
	private double faceAngulo;

	public FormaBase() {
		setForma(null);
		setAtivo(false);
		setX(0.0);
		setY(0.0);
		setVelocidadeX(0.0);
		setVelocidadeY(0.0);
		setAnguloMovimentacao(0.0);
		setFaceAngulo(0.0);
	}

	public Shape getForma() {
		return forma;
	}

	public void setForma(Shape forma) {
		this.forma = forma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelocidadeX() {
		return velocidadeX;
	}

	public void setVelocidadeX(double velocidadeX) {
		this.velocidadeX = velocidadeX;
	}

	public double getVelocidadeY() {
		return velocidadeY;
	}

	public void setVelocidadeY(double velocidadeY) {
		this.velocidadeY = velocidadeY;
	}

	public double getAnguloMovimentacao() {
		return anguloMovimentacao;
	}

	public void setAnguloMovimentacao(double anguloMovimentacao) {
		this.anguloMovimentacao = anguloMovimentacao;
	}

	public double getFaceAngulo() {
		return faceAngulo;
	}

	public void setFaceAngulo(double faceAngulo) {
		this.faceAngulo = faceAngulo;
	}

	public void incrementarX(double valor) {
		this.x += valor;
	}

	public void incrementarY(double valor) {
		this.y += valor;
	}

	public void incrementarVelocidadeX(double valor) {
		this.velocidadeX += valor;
	}

	public void incrementarVelocidadeY(double valor) {
		this.velocidadeY += valor;
	}

	public void incrementarAnguloMovimentacao(double valor) {
		this.anguloMovimentacao += valor;
	}

	public void incrementarFaceAngulo(double valor) {
		this.faceAngulo += valor;
	}
}

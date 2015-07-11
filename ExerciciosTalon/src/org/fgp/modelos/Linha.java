package org.fgp.modelos;

public class Linha {
	
	private Ponto pontoInicial;
	private Ponto pontoFinal;
	
	private static final Ponto ORIGEM = new Ponto(0,0);
	
	public Ponto getPontoInicial() {
		return pontoInicial;
	}
	public void setPontoInicial(Ponto pontoInicial) {
		this.pontoInicial = pontoInicial;
	}
	public Ponto getPontoFinal() {
		return pontoFinal;
	}
	public void setPontoFinal(Ponto pontoFinal) {
		this.pontoFinal = pontoFinal;
	}
	
	public Linha(){
		super();
		this.pontoInicial = new Ponto(ORIGEM.getX(), ORIGEM.getY());
		this.pontoFinal = new Ponto(ORIGEM.getX(), ORIGEM.getY());
	}
	
	public Linha(Ponto pontoFinal){
		super();
		this.pontoInicial = new Ponto(ORIGEM.getX(), ORIGEM.getY());
		this.pontoFinal = pontoFinal;
	}
	
	public Linha(Ponto pontoInicial, Ponto pontoFinal){
		super();
		this.pontoInicial = pontoInicial;
		this.pontoFinal = pontoFinal;
	}
	
	public Linha(int inicioX, int inicioY, int finalX, int finalY){
		super();
		this.pontoInicial = new Ponto(inicioX, inicioY);
		this.pontoFinal = new Ponto(finalX, finalY);
	}
}

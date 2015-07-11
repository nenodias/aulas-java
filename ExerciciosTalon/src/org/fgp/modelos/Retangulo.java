package org.fgp.modelos;

public class Retangulo {
	public Ponto pontoInicial;
	public Ponto pontoFinal;
	
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
	
	public void calcularArea(){
		int base = pontoInicial.getX()-pontoFinal.getX();
		int altura = pontoInicial.getY()-pontoFinal.getY();
		System.out.println("Area:"+base * altura);
	}
	
	public void calcularPerimetro(){
		int base = pontoFinal.getX() - pontoInicial.getX();
		int altura = pontoFinal.getY() - pontoInicial.getY();
		System.out.println("Perímetro:"+((2*base) + (2 * altura) ));
	}
	
	public boolean intercede(Ponto ponto){
		return (pontoInicial.getX() <= ponto.getX() && pontoInicial.getY() <= ponto.getY() ) && (pontoFinal.getX() >= ponto.getX() && pontoFinal.getY() >= ponto.getY() );
	}
	
	public boolean intercede(Linha linha){
		return intercede(linha.getPontoInicial())&&intercede(linha.getPontoFinal()) ;
	}
	
	public Retangulo(){
		this.pontoInicial = new Ponto(ORIGEM.getX(), ORIGEM.getY());
		this.pontoFinal = new Ponto(ORIGEM.getX(), ORIGEM.getY());
	}
	
	public Retangulo(Ponto pontoFinal){
		this.pontoInicial = new Ponto(ORIGEM.getX(), ORIGEM.getY());
		this.pontoFinal = pontoFinal;
	}
	
	public Retangulo(Ponto pontoInicial, Ponto pontoFinal){
		this.pontoInicial = pontoInicial;
		this.pontoFinal = pontoFinal;
	}
	
	public Retangulo(int inicioX, int inicioY, int finalX, int finalY ){
		this.pontoInicial = new Ponto(inicioX, inicioY);
		this.pontoFinal = new Ponto(finalX, finalY);
	}
	
}

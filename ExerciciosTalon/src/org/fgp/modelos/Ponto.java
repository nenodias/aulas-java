package org.fgp.modelos;

public class Ponto {
	private int x;
	private int y;
	
	private static final Ponto ORIGEM = new Ponto(0,0);
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void incrementarX() {
		this.x++;
	}
	
	public void incrementarY() {
		this.y++;
	}
	
	public boolean temEixoComun(Ponto ponto){
		return this.x == ponto.getX() && this.y == ponto.getY();
	}
	
	public int distancia(Ponto ponto){
		return  ( ( this.x - ponto.getX() ) * ( this.x - ponto.getX() ) ) + ( (this.y-ponto.getY() )* (this.y-ponto.getY() ) ); 
	}
	
	public int distanciaDaOrigem(){
		return distancia(ORIGEM);
	}
	
	public Ponto() {
		super();
		this.x = ORIGEM.getX();
		this.y = ORIGEM.getY();
	}
	
	public boolean proximo(Ponto ponto, int limiar){
		return distancia(ponto) < limiar;
	}
	
	public Ponto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

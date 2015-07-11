package draw.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

public class Bola {
	
	private static Dimension tamanhoTela;
	
	private Integer tamanho;
	
	private Double x;
	
	private Double y;
	
	private Double velocidadeX;
	
	private Double velocidadeY;
	
	public Bola(Dimension tamanhoTela) {
		Bola.tamanhoTela = tamanhoTela;
	}

	public void atualiza(long tempo){
		x += (tempo * velocidadeX ) /1000;
		y += (tempo * velocidadeY ) /1000;
		checarColisoes();
	}

	private void checarColisoes() {
		if(isColisaoLadoEsquerdo()){
			velocidadeX =  -velocidadeX;
			x = 0D;
		}else if(isColisaoLadoDireito()){
			velocidadeX =  -velocidadeX;
			x = tamanhoTela.getWidth() - tamanho;
		}else if(isColisaoTopo()){
			velocidadeY =  -velocidadeY;
			y = 0D;
		}else if(isColisaoBase()){
			velocidadeY =  -velocidadeY;
			y = tamanhoTela.getHeight() - tamanho;
		}
	}

	private boolean isColisaoBase() {
		return (y + Double.parseDouble(tamanho.toString() ) > tamanhoTela.getHeight() );
	}

	private boolean isColisaoTopo() {
		return y < 0D;
	}

	private boolean isColisaoLadoEsquerdo() {
		return x < 0D;
	}
	
	private boolean isColisaoLadoDireito() {
		return (x + Double.parseDouble(tamanho.toString() ) > tamanhoTela.getWidth() );
	}
	
	public void draw(Graphics2D g2d){
		Graphics2D g = (Graphics2D) g2d.create();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.RED);
		g.fill( new Ellipse2D.Double(x, y, tamanho, tamanho) );
		g.dispose();
	}

}

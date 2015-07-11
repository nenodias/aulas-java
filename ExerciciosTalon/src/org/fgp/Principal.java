package org.fgp;

import org.fgp.modelos.Ponto;

public class Principal {

	public static void main(String[] args) {
//		Ponto ponto = new Ponto(10, 12);
//		Linha linha = new Linha();
//		linha.setPontoInicial(new Ponto(5,10));
//		linha.setPontoFinal(new Ponto(12,14));
//		Retangulo retangulo = new Retangulo();
//		retangulo.setPontoInicial(new Ponto(5,10));
//		retangulo.setPontoFinal(new Ponto(20,20));
//		retangulo.calcularArea();
//		retangulo.calcularPerimetro();
//		System.out.println("Ponto intercede Retangulo:"+retangulo.intercede(ponto));
//		System.out.println("Linha intercede Retangulo:"+retangulo.intercede(linha));
		
		Ponto ponto = new Ponto(10, 10);
		Ponto ponto2 = new Ponto(15, 15);
		System.out.println("Distancia:"+ponto.distancia(ponto2));
		
	}

}

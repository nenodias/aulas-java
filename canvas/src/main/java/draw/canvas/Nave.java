package draw.canvas;

import java.awt.Polygon;
import java.awt.Rectangle;

public class Nave extends FormaBase{

	private int[] naveX = {-6, -3, 0, 3, 6, 0};
	private int[] naveY = {6, 7, 7, 7, 6, -7};
	
	public Rectangle getBounds(){
		return new Rectangle((int)getX()-6, (int)getY() -6, 12, 12);
	}
	
	public Nave() {
		setForma( new Polygon(naveX, naveY, naveX.length));
		setAtivo(true);
	}
	
}
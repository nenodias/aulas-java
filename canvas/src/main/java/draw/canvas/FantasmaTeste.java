package draw.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FantasmaTeste extends JComponent {
	
	@SuppressWarnings("unused")
	private static final ClassLoader LOADER = FantasmaTeste.class.getClassLoader(); 
	
	private static final long serialVersionUID = 747807762748564857L;

	private static JFrame mainFrame;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.RED);
		g2d.fill(new Arc2D.Float(200,100,50,50,900,-180,Arc2D.OPEN));
		int coordenadasX [] = {200,200,210,220,220,230,230,240,250,250};
		int coordenadasY [] = {125,150,140,150,140,140,150,140,150,125};
		g2d.fill( new Polygon(coordenadasX, coordenadasY, coordenadasX.length) );
		g2d.setColor(Color.WHITE);
		g2d.fill( new Ellipse2D.Float(210,110,15,17) );
		g2d.fill( new Ellipse2D.Float(233,110,15,17) );
		
		g2d.setColor(Color.BLUE);
		g2d.fillRect(220, 115, 7, 7);
		g2d.fillRect(242, 115, 7, 7);
		
//		g2d.drawLine(200, 125, 200, 150);
//		g2d.drawLine(200, 150, 210,140);
//		g2d.drawLine(210,140,220, 150);
//		g2d.drawLine(220, 150,230,140);
//		g2d.drawLine(230,140,240,150);
//		g2d.drawLine(240,150,250,140);
//		g2d.drawLine(250,140,250,125);
	}

	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public static void main(String args[]) {
		mainFrame = new JFrame("Graphics demo");
		mainFrame.getContentPane().add(new FantasmaTeste());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				mainFrame.setVisible(true);
			}
		});
	}
}

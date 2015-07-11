package draw.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FantasmaResolvido extends JComponent {

	private static final long serialVersionUID = 2094726853917657427L;

	private static JFrame mainFrame;

	private static final Ellipse2D eyeWhite = new Ellipse2D.Float(0, 0, 20, 25);
	private static final Ellipse2D eyeBall = new Ellipse2D.Float(0, 5, 8, 15);

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		drawBody(g2d);
		drawEyes(g2d);

		g2d.dispose();
	}

	@Override
	public void paint(Graphics g) {
		// Criamos um contexto gráfico com a área de pintura restrita
		// ao interior da janela.
		Graphics2D clip = (Graphics2D) g.create(getInsets().left,
				getInsets().top, getWidth() - getInsets().right, getHeight()
						- getInsets().bottom);

		// Pintamos o fundo do frame de preto
		clip.setColor(Color.BLACK);
		clip.fill(clip.getClipBounds());

		// Pintamos o fantasma
		clip.translate( ( getWidth() / 2 ) -40 , ( getHeight() / 2 ) -40 );
		this.paintComponent(clip);
		clip.dispose();
	}

	private void drawEyes(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g.create();

		//Aumentando a escala dos desenhos
		g2d.scale(1.2, 1.2);
		
		// Afastamos nosso sistema de coordenadas (em 0,0)
		// para a posição 10,25 e pintamos o olho
		g2d.translate(10, 25);
		drawEye(g2d);

		// g2d.translate(22, 0);
		// drawEye(g2d);
		
		// Afastamos mais 25 pixels em x
		// Ou seja, a posição (0,0) agora é (35,35).
		// Pintamos o olho novamente.
		g2d.translate(25, 0);
		drawEye(g2d);

		g2d.dispose();
	}

	private void drawEye(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.fill(eyeWhite);
		g2d.setColor(Color.BLUE);
		g2d.fill(eyeBall);
	}

	private void drawBody(Graphics2D g2d) {
		GeneralPath gp = new GeneralPath();

		// Lateral esquerda
		gp.moveTo(0, 35);
		gp.lineTo(0, 80);

		gp.quadTo(15, 95, 20, 80);
		gp.quadTo(25, 75, 30, 80);
		gp.quadTo(40, 95, 50, 80);
		gp.quadTo(55, 75, 60, 80);
		gp.quadTo(70, 95, 80, 80);

		// Lateral direita
		gp.lineTo(80, 35);

		// Topo
		gp.curveTo(70, -5, 8, -5, 0, 30);

		// Colorindo
		Paint oldPaint = g2d.getPaint();

		GradientPaint paint = new GradientPaint(0, 40, Color.RED, // Da cor  definida pelo usuário
				70, 40, Color.RED.darker()); // Até um tom um pouco mais escuro
		g2d.setPaint(paint);

		// Pintura do fantasma
		g2d.fill(gp);
	}

	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public static void main(String args[]) {
		mainFrame = new JFrame("Graphics demo");
		mainFrame.getContentPane().add(new FantasmaResolvido());
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

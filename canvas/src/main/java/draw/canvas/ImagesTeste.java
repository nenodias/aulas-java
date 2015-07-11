package draw.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ImagesTeste extends JPanel implements ImageObserver {

	private static final long serialVersionUID = 1003333581044531322L;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(0, 0, 640, 480);
                frame.add(new ImagesTeste());
//                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
	}
	
	@Override
	public Dimension getSize() {
		return new Dimension(640, 480);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		try {
			BufferedImage image = new BufferedImage(640, 480,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = image.createGraphics();
			g2d.setColor(Color.WHITE);
			g2d.drawString("LOL", 100, 110);
			g2d.translate(50, 50);
			g2d.draw(new Nave().getForma());
			g2d.dispose();
			
			g.drawImage(image, 0, 0, this);
			if (image == null ||!g.drawImage(image,0,0,getWidth(),getHeight(),this )) {
				g.drawString("ERRO", 20, getHeight()/2);
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	

}

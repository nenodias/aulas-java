import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Remover extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Pessoa pessoa;

	/**
	 * Create the panel.
	 */
	public Remover(JFrame principal, int id) {
		
		frame = principal;
		
		pessoa = new Pessoa(id);
		
		JLabel lblDesejaRemoverEsta = new JLabel("Deseja remover esta pessoa?");
		
		JLabel lblId = new JLabel("ID: " + pessoa.getId());
		
		JLabel lblNome = new JLabel("Nome: " + pessoa.getNome());
		
		JLabel lblEmail = new JLabel("Email: " + pessoa.getEmail());
		
		JButton btnSim = new JButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoa.remover();
				JOptionPane.showMessageDialog(frame, "Pessoa removida com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				frame.getContentPane().removeAll();
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		
		JButton btnNo = new JButton("N\u00E3o");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				JPanel panel = new JPanel();
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				frame.getContentPane().revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblId)
								.addComponent(lblEmail)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSim)
								.addComponent(lblDesejaRemoverEsta))
							.addGap(18)
							.addComponent(btnNo)))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDesejaRemoverEsta)
					.addGap(37)
					.addComponent(lblId)
					.addGap(18)
					.addComponent(lblNome)
					.addGap(18)
					.addComponent(lblEmail)
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSim)
						.addComponent(btnNo))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}

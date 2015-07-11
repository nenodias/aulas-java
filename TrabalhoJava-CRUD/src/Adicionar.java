import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Adicionar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JFrame frame;
	private JTextField textFieldTelefone;
	private JTextField textFieldCelular;

	/**
	 * Create the panel.
	 */
	public Adicionar(JFrame principal) {
		
		frame = principal;
		
		JLabel lblAdicionar = new JLabel("Adicionar");
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		JLabel lblCelular = new JLabel("Celular");
		
		textFieldCelular = new JTextField();
		textFieldCelular.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAdicionar))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblAdicionar))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(42)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTelefone)
									.addComponent(lblEmail)
									.addComponent(lblNome)
									.addComponent(lblCelular, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(30)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldCelular, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))))
					.addGap(155))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdicionar)
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefone)
						.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCelular)
						.addComponent(textFieldCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnAdicionar)
					.addGap(40))
		);
		setLayout(groupLayout);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Pessoa pessoa = new Pessoa();
				 pessoa.setNome(textFieldNome.getText());
				 pessoa.setEmail(textFieldEmail.getText());
				 pessoa.setTelefone(textFieldTelefone.getText());
				 pessoa.setCelular(textFieldCelular.getText());
				 pessoa.salvar(); 
				 JOptionPane.showMessageDialog(frame, "Pessoa adicionada com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				 frame.getContentPane().removeAll();
				 JPanel panel = new JPanel();
				 frame.getContentPane().add(panel, BorderLayout.CENTER);
				 frame.getContentPane().revalidate(); 
			}
		});
	}
}

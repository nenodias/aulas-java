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


public class Atualizar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JFrame frame;
	private Pessoa pessoa;
	private JTextField textFieldTelefone;
	private JTextField textFieldCelular;

	/**
	 * Create the panel.
	 */
	public Atualizar(JFrame principal, int id) {
		
		frame = principal;
		
		pessoa = new Pessoa(id);
		
		JLabel lblAtualizar = new JLabel("Atualizar - ID: " + pessoa.getId());
		
		JLabel lblNome = new JLabel("Nome:");
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setText(pessoa.getNome());
		
		JLabel lblEmail = new JLabel("Email:");
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setText(pessoa.getEmail());
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setText(pessoa.getTelefone());
		textFieldTelefone.setColumns(10);
		
		JLabel labelTelefone = new JLabel("Telefone:");
		
		textFieldCelular = new JTextField();
		textFieldCelular.setText(pessoa.getCelular());
		textFieldCelular.setColumns(10);
		
		JLabel labelCelular = new JLabel("Celular:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAtualizar))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblAtualizar))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(42)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblEmail)
									.addComponent(lblNome)
									.addComponent(labelCelular)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addGap(13)
										.addComponent(labelTelefone)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
									.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldCelular, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))))
					.addGap(170))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAtualizar)
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelTelefone))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelCelular))
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addGap(41))
		);
		setLayout(groupLayout);
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 pessoa.setNome(textFieldNome.getText());
				 pessoa.setEmail(textFieldEmail.getText());
				 pessoa.setTelefone(textFieldTelefone.getText());
				 pessoa.setCelular(textFieldCelular.getText());
				 pessoa.salvar(); 
				 JOptionPane.showMessageDialog(frame, "Pessoa atualizada com sucesso!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				 frame.getContentPane().removeAll();
				 JPanel panel = new JPanel();
				 frame.getContentPane().add(panel, BorderLayout.CENTER);
				 frame.getContentPane().revalidate(); 
			}
		});
	}
}

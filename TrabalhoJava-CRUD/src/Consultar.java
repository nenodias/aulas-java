import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Consultar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public Consultar(JFrame principal) {
		
		frame = principal;
		
		JLabel lblConsultar = new JLabel("Consultar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() >= 0) {
					frame.getContentPane().removeAll();
					Remover remover = new Remover(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(remover, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {
					JOptionPane.showMessageDialog(frame, "Selecione uma pessoa!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					frame.getContentPane().removeAll();
					Atualizar atualizar = new Atualizar(frame, (int)table.getValueAt(table.getSelectedRow(), 0));
					frame.getContentPane().add(atualizar, BorderLayout.CENTER);
					frame.getContentPane().revalidate();
				} else {
					JOptionPane.showMessageDialog(frame, "Selecione uma pessoa!", "Mensagem", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(lblConsultar)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnAtualizar)
							.addGap(18)
							.addComponent(btnRemover)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConsultar)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemover)
						.addComponent(btnAtualizar))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NOME", "EMAIL", "TELEFONE", "CELULAR"
				}
			);
		Pessoa p = new Pessoa();
		Pessoa[] pessoas = p.consultar();
		if (pessoas != null) {
			for (int i=0; i<pessoas.length; i++) {
				dtm.addRow(new Object[] {
						pessoas[i].getId(),
						pessoas[i].getNome(),
						pessoas[i].getEmail(),
						pessoas[i].getTelefone(),
						pessoas[i].getCelular()
				});
			}
		}
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}

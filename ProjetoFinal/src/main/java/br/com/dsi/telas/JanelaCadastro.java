package br.com.dsi.telas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaCadastro extends JInternalFrame {	
	
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private JLabel labelNome;
	private JTextField fieldNome;

	private JLabel labelMarca;
	private JTextField fieldMarca;

	private JLabel labelPreco;
	private JTextField fieldPreco;

	private JButton btnCadastrar;

	public JanelaCadastro() {
		super("Cadastro de Produto", true, true, true, true);
		criarComponentes();
		configurarJanela();
	}

	private void criarComponentes() {
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Inserção de produtos"));
		panel.setLayout(null);

		// x, y , wi, hei

		labelNome = new JLabel("Nome");
		labelNome.setBounds(20, 30, 42, 20);

		fieldNome = new JTextField();
		fieldNome.setBounds(65, 30, 220, 20);

		labelMarca = new JLabel("Marca");
		labelMarca.setBounds(20, 60, 42, 20);

		fieldMarca = new JTextField(18);
		fieldMarca.setBounds(65, 60, 220, 20);		
	
		fieldPreco = new JTextField(8);
		fieldPreco.setBounds(65, 90, 55, 20);
		
		fieldPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				
				if((Character.isAlphabetic(validar) || validar==KeyEvent.VK_BACK_SPACE)) {
					getToolkit().beep();
					e.consume();					
				}
			}
		});		
		
		labelPreco = new JLabel("Preço");
		labelPreco.setBounds(20, 90, 55, 20);
		labelPreco.setLabelFor(fieldPreco);				
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(150, 90, 110, 30);
		btnCadastrar.addActionListener(this::salvarListener);

		panel.add(labelNome);
		panel.add(fieldNome);
		panel.add(labelMarca);
		panel.add(fieldMarca);
		panel.add(labelPreco);
		panel.add(fieldPreco);
		panel.add(btnCadastrar);

		add(panel);

	}

	private void configurarJanela() {
		setVisible(true);
		setSize(500, 260);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void keyTypedPreco(KeyEvent k) {
		
	}
	
	private void salvarListener(ActionEvent e) {

//		if(fieldNome.getText().isBlank() || fieldIdade.getText().isBlank()) {
//			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
//			return;
//		}
//		EditarPessoaController ec = new EditarPessoaController(this);
//		ec.editarPessoa();
//		JOptionPane.showMessageDialog(this, "Registro alterado");
//		resetaCampos();

	}

	private void resetaCampos() {
		fieldNome.setText("");
		fieldMarca.setText("");
		//fieldPreco.setText("");
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanel() {
		return panel;
	}
	
}

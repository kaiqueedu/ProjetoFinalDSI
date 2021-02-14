package br.com.dsi.telas;

import br.com.dsi.controller.ProdutoController;
import br.com.dsi.modelo.Produto;

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

	private ProdutoController pController;

	public JanelaCadastro() {
		super("Janale Cadastro", true, true, true, true);
		pController = new ProdutoController();
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
		fieldNome.setBounds(78, 30, 220, 20);

		labelMarca = new JLabel("Marca");
		labelMarca.setBounds(20, 60, 50, 20);

		fieldMarca = new JTextField(18);
		fieldMarca.setBounds(78, 60, 220, 20);
	
		fieldPreco = new JTextField(8);
		fieldPreco.setBounds(78, 90, 55, 20);
		
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
		btnCadastrar.setBounds(150, 90, 120, 30);
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

	private void salvarListener(ActionEvent e) {

		if(fieldNome.getText().isBlank() || fieldMarca.getText().isBlank() || fieldPreco.getText().isBlank()){
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}
		Produto produto = new Produto(fieldNome.getText(), fieldMarca.getText(), Double.parseDouble(fieldPreco.getText()));
		pController.inserirProduto(produto);
		JOptionPane.showMessageDialog(this, "Produto cadastrado");
		resetaCampos();
	}

	private void resetaCampos() {
		fieldNome.setText("");
		fieldMarca.setText("");
		fieldPreco.setText("");
	}
	
}

package br.com.dsi.telas;

import java.awt.event.ActionEvent;

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
    private JLabel labelIdade;
    
    private JTextField fieldNome;
    private JTextField fieldIdade;
    
	private JButton btnSalvarPessoa;
	private JButton btnLimpar;	

	public JanelaCadastro() {
		super("Janela de Cadastro",true,true,true,true);
		criarComponentes();
		configurarJanela();		
	}
	
	private void criarComponentes(){
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Inser��o de produtos"));
		
		labelNome = new JLabel("Nome");		
		labelIdade = new JLabel("Idade");
		
		fieldNome = new JTextField(18);		
		fieldIdade = new JTextField(2);
		
		btnSalvarPessoa = new JButton("Salvar");
		btnSalvarPessoa.addActionListener(this::onClickListener);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this::limpar);
		
		panel.add(labelNome);
		panel.add(fieldNome);
		panel.add(labelIdade);		
		panel.add(fieldIdade);
		panel.add(btnSalvarPessoa);
		panel.add(btnLimpar);
		
		add(panel);
	}
	
	private void onClickListener(ActionEvent e) {
		if(e.getSource().equals(btnSalvarPessoa)) {
			if(fieldNome.getText().isBlank() || fieldIdade.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
				return;
			}
			//InserePessoaController ipc = new InserePessoaController(this);
			//ipc.salvarPessoa();
		}
	}
	
	private void limpar(ActionEvent e) {
        fieldNome.setText(null);
        fieldIdade.setText(null);
	}

	private void configurarJanela() {
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }	
	
	//Getters
	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public JLabel getLabelIdade() {
		return labelIdade;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public JTextField getFieldIdade() {
		return fieldIdade;
	}

	public JButton getBtnSalvarPessoa() {
		return btnSalvarPessoa;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}	

}

package br.com.dsi.telas;

import br.com.dsi.controller.ProdutoController;
import br.com.dsi.modelo.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class JanelaConsulta extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JPanel panel;
	
	private JLabel labelIdBusca;
	private JTextField fIdBusca;	
	
	private JLabel labelDescricao;
	private JTextField fieldDescricao;
	
	private JLabel labelMarca;
	private JTextField fieldMarca;
	
	private JLabel labelPreco;
	private JTextField fieldPreco;
	
	private JButton btnBuscar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	
	private Long idJanela;
	private ProdutoController pController;
	private Produto produto;
	
	public JanelaConsulta() {
		super("Janela Consulta/Alteração",true,true,true,true);
		pController = new ProdutoController();
		criarComponentes();
        configurarJanela();
	}
	
	private void criarComponentes() {
		panel = new JPanel();		
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Consulta/Alteração"));
		panel.setLayout(null);		
		
		labelIdBusca = new JLabel("Id:");
		labelIdBusca.setBounds(20, 30, 40, 20);		
		
		fIdBusca = new JTextField();
		fIdBusca.setBounds(50, 30, 40, 20);	
		
		labelDescricao = new JLabel("Produto:");
		labelDescricao.setBounds(20, 70, 70, 20);
		
		fieldDescricao = new JTextField(18);
		fieldDescricao.setBounds(80, 70, 240, 20);		
		
		labelMarca = new JLabel("Marca:");
		labelMarca.setBounds(20, 100, 50, 20);
		
		fieldMarca = new JTextField(2);	
		fieldMarca.setBounds(80, 100, 240, 20);
		
		labelPreco = new JLabel("Preço:");
		labelPreco.setBounds(20, 130, 50, 20);
		
		fieldPreco = new JTextField(2);	
		fieldPreco.setBounds(80, 130, 90, 20);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(120, 29, 150, 20);
		btnBuscar.addActionListener(this::buscarListener);		
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(350, 68, 89, 25);
		btnEditar.addActionListener(this::editarListener);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(445, 68, 89, 25);
		btnExcluir.addActionListener(this::excluirListener);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(200, 130, 89, 23);
		btnSalvar.addActionListener(this::salvarListener);
		
		fieldDescricao.setEditable(false);
		fieldMarca.setEditable(false);
		fieldPreco.setEditable(false);
		
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);	
		btnSalvar.setEnabled(false);	
		
		panel.add(labelIdBusca);
		panel.add(fIdBusca);	
		panel.add(labelDescricao);
		panel.add(fieldDescricao);
		panel.add(labelMarca);
		panel.add(fieldMarca);
		panel.add(labelPreco);
		panel.add(fieldPreco);	
		panel.add(btnBuscar);
		panel.add(btnEditar);
		panel.add(btnExcluir);
		panel.add(btnSalvar);
		
		add(panel);
		
	}
	
	private void configurarJanela() {
		setVisible(true);
		setSize(610,285);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void buscarListener(ActionEvent e) {
		
		if(fIdBusca.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Informe o id para a consulta");
			return;
		}

		produto = pController.buscarId(Long.parseLong(fIdBusca.getText()));
		if(produto == null){
			JOptionPane.showMessageDialog(this, "Id inv�lido");
			return;
		}
		setId(produto.getId());
		carregaTela(produto);
	}	
	
	private void editarListener(ActionEvent e) {		
		fieldDescricao.setEditable(true);
		fieldMarca.setEditable(true);
		fieldPreco.setEditable(true);
	}
	
	private void salvarListener(ActionEvent e) {
		
		if(fieldDescricao.getText().isBlank() || fieldMarca.getText().isBlank() || fieldPreco.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}
		produto.setDescricao(fieldDescricao.getText());
		produto.setMarca(fieldMarca.getText());
		produto.setPreco(Double.parseDouble(fieldPreco.getText()));

		pController.atualizarProtudo(produto);

		JOptionPane.showMessageDialog(this, "Registro alterado");
		resetaCampos();
	}
	
	private void excluirListener(ActionEvent e) {

		if(getId() != null){
			pController.removerProduto(produto);
		}

		JOptionPane.showMessageDialog(this, "Registro removido");
		resetaCampos();
	}
	
	private void carregaTela(Produto p) {
		fieldDescricao.setText(p.getDescricao());
		fieldMarca.setText(p.getMarca());
		fieldPreco.setText(""+p.getPreco());
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);	
		btnSalvar.setEnabled(true);		
	}
	
	private void resetaCampos() {
		fieldDescricao.setText("");
		fieldMarca.setText("");
		fieldPreco.setText("");
		
		fieldDescricao.setEditable(false);
		fieldMarca.setEditable(false);
		fieldPreco.setEditable(false);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);	
		btnSalvar.setEnabled(false);	
	}

	public Long getId() {
		return idJanela;
	}

	public void setId(Long id) {
		this.idJanela = id;
	}
	
}

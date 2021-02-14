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
	
	private JLabel labelNome;
	private JTextField fieldNome;
	
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
	
	public JanelaConsulta() {
		super("Janela Consulta/Alteração",true,true,true,true);
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
		
		labelNome = new JLabel("Produto:");
		labelNome.setBounds(20, 70, 50, 20);		
		
		fieldNome = new JTextField(18);
		fieldNome.setBounds(80, 70, 240, 20);		
		
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
		
		fieldNome.setEditable(false);
		fieldMarca.setEditable(false);
		fieldPreco.setEditable(false);
		
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);	
		btnSalvar.setEnabled(false);	
		
		panel.add(labelIdBusca);
		panel.add(fIdBusca);	
		panel.add(labelNome);
		panel.add(fieldNome);
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
			JOptionPane.showMessageDialog(this, "Preencha os campos para a pesquisa");
			return;
		}

		Produto produto = pController.buscarId(Long.parseLong(fIdBusca.getText()));
		if(produto == null){
			JOptionPane.showMessageDialog(this, "Id inválido");
			return;
		}
		setId(produto.getId());
		carregaTela(produto);
	}	
	
	private void editarListener(ActionEvent e) {		
		fieldNome.setEditable(true);
		fieldMarca.setEditable(true);
		fieldPreco.setEditable(true);
	}
	
	private void salvarListener(ActionEvent e) {
		
		if(fieldNome.getText().isBlank() || fieldMarca.getText().isBlank() || fieldPreco.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
			return;
		}
		pController.atualizarProtudo();
//		EditarPessoaController ec = new EditarPessoaController(this);
//		ec.editarPessoa();
//		JOptionPane.showMessageDialog(this, "Registro alterado");
//		resetaCampos();
		
	}
	
	private void excluirListener(ActionEvent e) {
//		ExcluirPessoaController ec = new ExcluirPessoaController(this);
//		if(id != null) {
//			ec.excluirPessoa(id);
//		}
//		JOptionPane.showMessageDialog(this, "Registro excluído");
//		
//		resetaCampos();		
	}
	
	private void carregaTela(Produto p) {
		fieldNome.setText(p.getDescricao());
		fieldMarca.setText(p.getMarca());
		fieldPreco.setText(""+p.getPreco());
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);	
		btnSalvar.setEnabled(true);		
	}
	
	private void resetaCampos() {
		fieldNome.setText("");
		fieldMarca.setText("");
		
		fieldNome.setEditable(false);
		fieldMarca.setEditable(false);
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);	
		btnSalvar.setEnabled(false);	
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JLabel getLabelIdBusca() {
		return labelIdBusca;
	}

	public void setLabelIdBusca(JLabel labelIdBusca) {
		this.labelIdBusca = labelIdBusca;
	}

	public JTextField getfIdBusca() {
		return fIdBusca;
	}

	public void setfIdBusca(JTextField fIdBusca) {
		this.fIdBusca = fIdBusca;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public void setLabelNome(JLabel labelNome) {
		this.labelNome = labelNome;
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public void setFieldNome(JTextField fieldNome) {
		this.fieldNome = fieldNome;
	}

	public JLabel getLabelMarca() {
		return labelMarca;
	}

	public void setLabelMarca(JLabel labelMarca) {
		this.labelMarca = labelMarca;
	}

	public JTextField getFieldMarca() {
		return fieldMarca;
	}

	public void setFieldMarca(JTextField fieldMarca) {
		this.fieldMarca = fieldMarca;
	}

	public JLabel getLabelPreco() {
		return labelPreco;
	}

	public void setLabelPreco(JLabel labelPreco) {
		this.labelPreco = labelPreco;
	}

	public JTextField getFieldPreco() {
		return fieldPreco;
	}

	public void setFieldPreco(JTextField fieldPreco) {
		this.fieldPreco = fieldPreco;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public void setBtnExcluir(JButton btnExcluir) {
		this.btnExcluir = btnExcluir;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public Long getId() {
		return idJanela;
	}

	public void setId(Long id) {
		this.idJanela = id;
	}
	
}

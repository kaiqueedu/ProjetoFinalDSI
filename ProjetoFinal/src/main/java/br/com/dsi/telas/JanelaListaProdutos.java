package br.com.dsi.telas;

import br.com.dsi.controller.ProdutoController;
import br.com.dsi.modelo.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class JanelaListaProdutos extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private JPanel panel;

    private JTable table;
    private DefaultTableModel defaultModel;
    private JScrollPane scroll;
    private JButton buttonBuscar;

    private ProdutoController pController;

    public JanelaListaProdutos() {
        criarComponentes();
        configurarJanela();
        pController = new ProdutoController();
        carregaProdutos();
    }

    private void criarComponentes() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Listagem de Produtos"));

        defaultModel = new DefaultTableModel();
        table = new JTable();
        table.setModel(defaultModel);
        table.setFillsViewportHeight(true);

        defaultModel.addColumn("Id");
        defaultModel.addColumn("Descrição");
        defaultModel.addColumn("Marca");
        defaultModel.addColumn("Preço");
        defaultModel.addColumn("Estoque");

        scroll = new JScrollPane();
        scroll.setViewportView(table);

        scroll.setPreferredSize(new Dimension(600, 500));

        buttonBuscar = new JButton("Atualizar");
        buttonBuscar.setBounds(29, 190, 68, 23);
        buttonBuscar.addActionListener(this::atualizaLista);
        getContentPane().add(buttonBuscar);

        panel.add(buttonBuscar);

        panel.add(scroll);
        add(panel);
    }

    private void configurarJanela() {
        setVisible(true);

        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JButton getButtonBuscar() {
        return buttonBuscar;
    }

    public void setButtonBuscar(JButton buttonBuscar) {
        this.buttonBuscar = buttonBuscar;
    }

    public void atualizaLista(ActionEvent e){
        carregaProdutos();
    }

    public void carregaProdutos() {
        defaultModel.setRowCount(0);
        defaultModel.setNumRows(0);

        List<Produto> list = pController.buscaTodos();

        for(Produto p: list) {
            Object[] array = {p.getId(),p.getDescricao(), p.getMarca(), p.getPreco()};
            defaultModel.addRow(array);
        }
    }

}

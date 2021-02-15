package br.com.dsi.principal;

import br.com.dsi.telas.JanelaPrincipal;

import javax.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("banco");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new JanelaPrincipal();
            }
        });			
	}
}







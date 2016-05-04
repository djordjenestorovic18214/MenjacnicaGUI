package menjacnica.gui.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public class KursTableModel extends AbstractTableModel{

	public final String[] kolone = new String[]{"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};

	public int getColumnCount() {
		return kolone.length;
	}

	public int getRowCount() {
		return 0;
	}

	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}

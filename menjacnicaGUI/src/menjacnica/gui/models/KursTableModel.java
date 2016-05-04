package menjacnica.gui.models;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;
import menjacnica.gui.GUIKontroler;

public class KursTableModel extends AbstractTableModel{

	private final String[] kolone = new String[]{"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	private LinkedList<Kurs> kursevi;
	
	public KursTableModel(LinkedList<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	public KursTableModel() {
	}

	public int getColumnCount() {
		return kolone.length;
	}

	public int getRowCount() {
		return kursevi.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k = kursevi.get(rowIndex);
		
		switch(columnIndex) {
		case 0: return k.getSifra();
		case 1: return k.getSkraceniNaziv();
		case 2:	return k.getProdajniKurs();
		case 3:	return k.getSrednjiKurs();
		case 4:	return k.getKupovniiKurs();
		case 5:	return k.getNaziv();
		default: return "NN";
		}
	}
	
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public Kurs getKursByIndex(int index) {
		return kursevi.get(index);
	}
	
	public void staviKurseveUModel(LinkedList<Kurs> kursevi) {
		this.kursevi = kursevi;
		fireTableDataChanged();
	}
	
	public Kurs vratiKurs(int indeks){
		return kursevi.get(indeks);
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}

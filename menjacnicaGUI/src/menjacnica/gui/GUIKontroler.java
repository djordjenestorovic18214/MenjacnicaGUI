package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUIKontroler {
	
	private static MenjacnicaGUI menjacnica;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new MenjacnicaGUI();
					menjacnica.setVisible(true);
					menjacnica.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(), "Da li zelite da izadjete iz programa?", "Zatvaranje aplikacije...", JOptionPane.YES_NO_CANCEL_OPTION);
		if(opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public static void dodajKurs() {
		try {
			DodajKursGUI dk = new DodajKursGUI();
			dk.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void izvrsiZamenu() {
			try {
				IzvrsiZamenuGUI iz = new IzvrsiZamenuGUI();
				iz.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void ispisiStatus(String tekst) {
		MenjacnicaGUI.taStatus.append(tekst + "\n");
	}
	
	public static void sacuvaj() {
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showSaveDialog(menjacnica.getContentPane());
		if(opcija == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ispisiStatus("Sacuvan fajl: " + file.getAbsolutePath());
		}		
	}
	
	public static void ucitaj() {
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showOpenDialog(menjacnica.getContentPane());
		if(opcija == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			GUIKontroler.ispisiStatus("Ucitan fajl: " + file.getAbsolutePath());
		}
	}
	public static void about() {
	JOptionPane.showMessageDialog(menjacnica.getContentPane(), "Autor: Djordje Nestorovic \n"
			+ "Studira na: Fakultet Organizacionih Nauka \n"
			+ "Datum rodjenja: 25.09.1995. \n"
			+ "Broj indeksa: 0182/2014 \n");
		}
}
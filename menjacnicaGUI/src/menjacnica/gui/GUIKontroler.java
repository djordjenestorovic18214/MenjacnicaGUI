package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.Kurs;
import menjacnica.Menjacnica;
import menjacnica.gui.models.KursTableModel;

public class GUIKontroler {
	
	private static MenjacnicaGUI prozor;
	private static Menjacnica menjacnica;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
					prozor = new MenjacnicaGUI();
					prozor.setVisible(true);
					prozor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(prozor.getContentPane(), "Da li zelite da izadjete iz programa?", "Zatvaranje aplikacije...", JOptionPane.YES_NO_CANCEL_OPTION);
		if(opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	
	public static void dodajKurs(Kurs k){
		menjacnica.dodajKurs(k);
		prozor.osveziTabelu();
	}
	
	public static void pokreniDodajKursProzor() {
		try {
			DodajKursGUI dk = new DodajKursGUI();
			dk.setVisible(true);
			dk.setLocationRelativeTo(prozor.getContentPane());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void obrisiKurs(Kurs k){
		menjacnica.izbrisiKurs(k);
		prozor.osveziTabelu();
	}
	
	public static void pokreniIzvrsiZamenuProzor() {
			try {
				IzvrsiZamenuGUI iz = new IzvrsiZamenuGUI();
				iz.setVisible(true);
				iz.setLocationRelativeTo(prozor.getContentPane());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void ispisiStatus(String tekst) {
		MenjacnicaGUI.taStatus.append(tekst + "\n");
	}
	
	public static void sacuvaj() {
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showSaveDialog(prozor.getContentPane());
		if(opcija == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ispisiStatus("Sacuvan fajl: " + file.getAbsolutePath());
		}		
	}
	
	public static void ucitaj() {
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showOpenDialog(prozor.getContentPane());
		if(opcija == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			GUIKontroler.ispisiStatus("Ucitan fajl: " + file.getAbsolutePath());
		}
	}
	
	public static void about() {
	JOptionPane.showMessageDialog(prozor.getContentPane(), "Autor: Djordje Nestorovic \n"
			+ "Studira na: Fakultet Organizacionih Nauka \n"
			+ "Datum rodjenja: 25.09.1995. \n"
			+ "Broj indeksa: 0182/2014 \n");
		}
	
	public static LinkedList<Kurs> vratiListuKurseva() {
		return menjacnica.vratiKurseve();
	}

	public static void dodaj() {
		int sifra = Integer.parseInt(DodajKursGUI.txtSifra.getText());
		String naziv = DodajKursGUI.txtNaziv.getText();
		double prodajniKurs = Double.parseDouble(DodajKursGUI.txtProdajniKurs.getText());
		double kupovniKurs = Double.parseDouble(DodajKursGUI.txtKupovniKurs.getText());
		double srednjiKurs = Double.parseDouble(DodajKursGUI.txtSrednjiKurs.getText());
		String skraceniNaziv = DodajKursGUI.txtSkraceniNaziv.getText();
		
		Kurs k = new Kurs(sifra, skraceniNaziv, prodajniKurs, srednjiKurs, kupovniKurs, naziv);
		GUIKontroler.dodajKurs(k);
		
		String dodajKurs = "Sifra: " + sifra + "; Naziv: " + naziv + "; Prodajni kurs: " + prodajniKurs
				 + "; Kupovni kurs: "+ kupovniKurs + "; Srednji kurs: " + srednjiKurs + "; Skraceni naziv: " + skraceniNaziv + ".";
		GUIKontroler.ispisiStatus(dodajKurs);
		ocistiPoljaDodajKursProzora();
	}
	
	public static void ocistiPoljaDodajKursProzora() {
		DodajKursGUI.txtSifra.setText("");
		DodajKursGUI.txtNaziv.setText("");
		DodajKursGUI.txtProdajniKurs.setText("");
		DodajKursGUI.txtKupovniKurs.setText("");
		DodajKursGUI.txtSrednjiKurs.setText("");
		DodajKursGUI.txtSkraceniNaziv.setText("");
	}

	public static void izbrisiKurs() {
		int indeks = MenjacnicaGUI.table.getSelectedRow();
		if(indeks == -1){
			GUIKontroler.upozorenjeOSelekcijiReda();
		}else{
			int opcija = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete ovaj kurs?",
					"Upozorenje", JOptionPane.YES_NO_OPTION);
			if(opcija == JOptionPane.YES_OPTION){
				KursTableModel model = (KursTableModel) MenjacnicaGUI.table.getModel();
				Kurs k = model.vratiKurs(indeks);
				GUIKontroler.obrisiKurs(k);
				ispisiStatus("Obrisan je red sa indeksom " + indeks);
				JOptionPane.showMessageDialog(prozor.getContentPane(), "Kurs uspesno obrisan!", 
						"Obavestenje", JOptionPane.INFORMATION_MESSAGE);		
			}
		}
	}

	private static void upozorenjeOSelekcijiReda() {
		JOptionPane.showMessageDialog(prozor.getContentPane(), "Izaberite kurs u tabeli koji zelite da obrisete!",
				"Greska", JOptionPane.ERROR_MESSAGE);
	}

	public static void zamena() {
		String valuta = (String) IzvrsiZamenuGUI.cbValuta.getSelectedItem();
		if(valuta != "EUR" && valuta != "USD" && valuta != "CHF") {
			JOptionPane.showMessageDialog(null, "Morate izabrati valutu");
			return;
	}
		int iznos = Integer.parseInt(IzvrsiZamenuGUI.txtIznos.getText());
		String radnja;
		if(IzvrsiZamenuGUI.rdbtnKupovina.isSelected())
			radnja = "Kupovina";
		else if(IzvrsiZamenuGUI.rdbtnProdaja.isSelected())
			radnja = "Prodaja";
		else {
			JOptionPane.showMessageDialog(null, "Morate izabrati izmedju kupovine i prodaje!");
			return;
		}
		
		String status = "Valuta: " + valuta + "; Iznos: " + iznos + "; Vrsta transakcije: " + radnja + ".";
		GUIKontroler.ispisiStatus(status);
	}
}
package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JTextField txtSifra;
	private JLabel lblProdajniKurs;
	private JTextField txtProdajniKurs;
	private JLabel lblSrednjiKurs;
	private JTextField txtSrednjiKurs;
	private JButton btnDodaj;
	private JLabel lblNaziv;
	private JTextField txtNaziv;
	private JLabel lblKupovniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSkraceniNaziv;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[30px:n][30][30][30][30][30][30]"));
		contentPane.add(getLblSifra(), "cell 0 0");
		contentPane.add(getLblNaziv(), "cell 2 0");
		contentPane.add(getTxtSifra(), "cell 0 1,grow");
		contentPane.add(getTxtNaziv(), "cell 2 1,grow");
		contentPane.add(getLblProdajniKurs(), "cell 0 2");
		contentPane.add(getLblKupovniKurs(), "cell 2 2");
		contentPane.add(getTxtProdajniKurs(), "cell 0 3,grow");
		contentPane.add(getTxtKupovniKurs(), "cell 2 3,grow");
		contentPane.add(getLblSrednjiKurs(), "cell 0 4");
		contentPane.add(getLblSkraceniNaziv(), "cell 2 4");
		contentPane.add(getTxtSrednjiKurs(), "cell 0 5,grow");
		contentPane.add(getTxtSkraceniNaziv(), "cell 2 5,grow");
		contentPane.add(getBtnDodaj(), "cell 0 6,grow");
		contentPane.add(getBtnOdustani(), "cell 2 6,grow");
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
		}
		return lblSifra;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}
	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
		}
		return lblSrednjiKurs;
	}
	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setColumns(10);
		}
		return txtSrednjiKurs;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int sifra = Integer.parseInt(txtSifra.getText());
					String naziv = txtNaziv.getText();
					double prodajniKurs = Double.parseDouble(txtProdajniKurs.getText());
					double kupovniKurs = Double.parseDouble(txtKupovniKurs.getText());
					double srednjiKurs = Double.parseDouble(txtSrednjiKurs.getText());
					String skraceniNaziv = txtSkraceniNaziv.getText();
					
					String dodajKurs = "Sifra: " + sifra + "; Naziv: " + naziv + "; Prodajni kurs: " + prodajniKurs
							 + "; Kupovni kurs: "+ kupovniKurs + "; Srednji kurs: " + srednjiKurs + "; Skraceni naziv: " + skraceniNaziv + ".";
					GUIKontroler.ispisiStatus(dodajKurs);
				}
			});
		}
		return btnDodaj;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}
	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}
	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
}

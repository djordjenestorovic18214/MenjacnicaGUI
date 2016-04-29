package menjacnica.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private static JTextField txtKupovniKurs;
	private static JTextField txtProdajniKurs;
	private static JComboBox cbValuta;
	private JLabel lblIznos;
	private JLabel lblVrstaTransakcije;
	private JTextField txtIznos;
	private static JRadioButton rdbtnKupovina;
	private static JRadioButton rdbtnProdaja;
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getCbValuta());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getLblIznos());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getTxtIznos());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnKupovina);
		bg.add(rdbtnProdaja);
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblKupovniKurs.setBounds(17, 13, 99, 14);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblProdajniKurs.setBounds(271, 6, 99, 25);
		}
		return lblProdajniKurs;
	}
	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setBounds(17, 38, 150, 36);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}
	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setBounds(271, 38, 150, 36);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}
	
	public static void comboBoxRefresh() {
		int opcija = cbValuta.getSelectedIndex();
		if(opcija == 1) {
			txtKupovniKurs.setText("122.24");
			txtProdajniKurs.setText("122.98");
		} else if (opcija == 2) {
			txtKupovniKurs.setText("107.82");
			txtProdajniKurs.setText("108.47");
		} else if(opcija == 3) {
			txtKupovniKurs.setText("111.15");
			txtProdajniKurs.setText("111.82");
		}
	}
		
	private JComboBox getCbValuta() {
		if (cbValuta == null) {
			cbValuta = new JComboBox();
			cbValuta.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(arg0.getStateChange() != ItemEvent.SELECTED) {
					}
					else comboBoxRefresh();
				}
			});
			cbValuta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBoxRefresh();
				}
			});
			cbValuta.setBounds(187, 38, 67, 36);
			cbValuta.addItem("----------");
			cbValuta.addItem("EUR");
			cbValuta.addItem("USD");
			cbValuta.addItem("CHF");
		}
		return cbValuta;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIznos.setBounds(17, 103, 61, 14);
		}
		return lblIznos;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVrstaTransakcije.setBounds(267, 103, 108, 14);
		}
		return lblVrstaTransakcije;
	}
	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setBounds(17, 124, 196, 33);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnKupovina.setBounds(270, 124, 105, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			rdbtnProdaja.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnProdaja.setBounds(270, 150, 105, 23);
		}
		return rdbtnProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					txtIznos.setText(slider.getValue() + "");
				}
			});
			slider.setMinorTickSpacing(5);
			slider.setMajorTickSpacing(10);
			slider.setSnapToTicks(true);
			slider.setPaintLabels(true);
			slider.setPaintTicks(true);
			slider.setBounds(17, 176, 399, 48);
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String valuta = (String) cbValuta.getSelectedItem();
					if(valuta != "EUR" && valuta != "USD" && valuta != "CHF") {
						JOptionPane.showMessageDialog(null, "Morate izabrati valutu");
						return;
				}
					int iznos = Integer.parseInt(txtIznos.getText());
					String radnja;
					if(rdbtnKupovina.isSelected())
						radnja = "Kupovina";
					else if(rdbtnProdaja.isSelected())
						radnja = "Prodaja";
					else {
						JOptionPane.showMessageDialog(null, "Morate izabrati izmedju kupovine i prodaje!");
						return;
					}
					
					String status = "Valuta: " + valuta + "; Iznos: " + iznos + "; Prodaja/Kupovina: " + radnja + ".";
					MenjacnicaGUI.ispisiStatus(status);
				}
			});
			btnIzvrsiZamenu.setBounds(17, 235, 170, 28);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setBounds(251, 235, 170, 28);
		}
		return btnOdustani;
	}

}
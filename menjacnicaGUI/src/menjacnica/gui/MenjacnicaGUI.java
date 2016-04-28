package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import java.awt.Point;
import javax.swing.table.DefaultTableModel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenjacnicaGUI extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPanel eastPanel;
	private JPanel southPanel;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/icons/31012012ms-office-icon.png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel_1(), BorderLayout.EAST);
		getContentPane().add(getPanel_1_1(), BorderLayout.SOUTH);
		getContentPane().add(getScrollPane_1(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
	private JPanel getPanel_1() {
		if (eastPanel == null) {
			eastPanel = new JPanel();
			eastPanel.setName("");
			eastPanel.setLayout(new MigLayout("", "[83px]", "[23px][][]"));
			eastPanel.add(getBtnDodajKurs(), "cell 0 0,growx,aligny top");
			eastPanel.add(getBtnIzbrisiKurs(), "cell 0 1,growx,aligny top");
			eastPanel.add(getBtnIzvrsiZamenu(), "cell 0 2,alignx left,aligny top");
		}
		return eastPanel;
	}
	private JPanel getPanel_1_1() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setLayout(new MigLayout("", "[106px,grow,fill]", "[18px,fill]"));
			southPanel.add(getScrollPane(), "flowx,cell 0 0,alignx left,aligny top");
		}
		return southPanel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setMinimumSize(new Dimension(23, 70));
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBackground(Color.WHITE);
			textArea.setWrapStyleWord(true);
			textArea.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "STATUS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textArea.setDragEnabled(true);
			textArea.setLineWrap(true);
		}
		return textArea;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
		}
		return btnDodajKurs;
	}
	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi kurs");
		}
		return btnIzbrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnIzvrsiZamenu;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
			));
			table.setFillsViewportHeight(true);
			addPopup(table, getPopupMenu());
		}
		return table;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIzbrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbrisi kurs");
		}
		return mntmIzbrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		}
		return mntmIzvrsiZamenu;
	}
}

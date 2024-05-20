/**
 * Transporti.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */

// Uvozimo vse razrede in pakete za delo z V/I napravami, pripomočke, format decimalnega zapisa, GUI, dogodke in tabele
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

/**
 * Javni razred za zagon uporabniškega vmesnika GUI
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class Transporti extends JFrame implements ActionListener {

	/**
	 * Gumb Dodaj osebno vozilo
	 */
	private JButton dodajOsebnoButton;

	/**
	 * Gumb Dodaj minibus vozilo
	 */
	private JButton dodajMinibusButton;

	/**
	 * Gumb Dodaj tovorno vozilo
	 */
	private JButton dodajTovornoButton;

	/**
	 * Tekstovno polje za vnos znamke osebnega vozila
	 */
	private JTextField osebnoZnamkaVnos;

	/**
	 * Tekstovno polje za vnos prevoženih kilometrov osebnega vozila
	 */
	private JTextField osebnoPrevozenihVnos;

	/**
	 * Tekstovno polje za vnos znamke minibus vozila
	 */
	private JTextField minibusZnamkaVnos;

	/**
	 * Tekstovno polje za vnos števila prevoženih kilometrov minibus vozila
	 */
	private JTextField minibusPrevozenihVnos;

	/**
	 * Tekstovno polje za vnos števila potniških sedežev minibus vozila
	 */
	private JTextField minibusSedezevVnos;

	/**
	 * Tekstovno polje za vnos vrste goriva minibus vozila
	 */
	private JTextField minibusGorivoVnos;

	/**
	 * Tekstovno polje za vnos znamke tovornega vozila
	 */
	private JTextField tovornoZnamkaVnos;

	/**
	 * Tekstovno polje za vnos prevoženih kilometrov tovornega vozila
	 */
	private JTextField tovornoPrevozenihVnos;

	/**
	 * Tekstovno polje za vnos kapacitete tovornega vozila
	 */
	private JTextField tovornoKapacitetaVnos;

	/**
	 * Tekstovno polje za vnos nosilnosti tovornega vozila
	 */
	private JTextField tovornoNosilnostVnos;

	/**
	 * Tekstovno polje za vnos vrste goriva tovornega vozila
	 */
	private JTextField tovornoGorivoVnos;

	/**
	 * Tabela za prikaz osebnih vozil
	 */
	private JTable tabelaOsebna;

	/**
	 * Tabela za prikaz minibus vozil
	 */
	private JTable tabelaMinibus;

	/**
	 * Tabela za prikaz tovornih vozil
	 */
	private JTable tabelaTovorna;

	/**
	 * Model tabele za prikaz osebnih vozil
	 */
	private TransportiOsebniTableModel osebnaTabela;

	/**
	 * Model tabele za prikaz minibus vozil
	 */
	private TransportiMinibusTableModel minibusTabela;

	/**
	 * Model tabele za prikaz tovornih vozil
	 */
	private TransportiTovorniTableModel tovornaTabela;
	
	/** Javna statična metoda, ki se izvede ob zagonu programa
	 * @param args Seznam nizov (vhodnih argumentov), ki jih vnesemo ob zagonu programa
	 */
	public static void main(String[] args) {

		// Ustvarimo objekt tipa Transporti (kličemo konstruktor razred Transporti)
		SwingUtilities.invokeLater(() -> new Transporti());
	}
	
	/** Javni konstruktor za ustvarjanje novega okna s prikazom transportov
	 */
	public Transporti() {

		// Pokličemo konstruktor nadrazreda
		super("Transporti");

		// Nastavimo obnašanje križca (x) tako, da konča aplikacijo
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Nastavimo privzeto velikost okna
		setSize(1900, 1000);
	
		// Nastavimo obliko okna
		setLayout(new BorderLayout());
	
		// Inicializiramo lastnosti
		dodajOsebnoButton = new JButton("Dodaj osebno vozilo");
		dodajMinibusButton = new JButton("Dodaj minibus vozilo");
		dodajTovornoButton = new JButton("Dodaj tovorno vozilo");
	
		// Gumbom za dodajanje dodamo action listener
		dodajOsebnoButton.addActionListener(this);
		dodajMinibusButton.addActionListener(this);
		dodajTovornoButton.addActionListener(this);
	
		// Naredimo vnosna polja
		osebnoZnamkaVnos = new JTextField(15);
		osebnoPrevozenihVnos = new JTextField(10);
		minibusZnamkaVnos = new JTextField(15);
		minibusPrevozenihVnos = new JTextField(10);
		minibusSedezevVnos = new JTextField(10);
		minibusGorivoVnos = new JTextField(15);
		tovornoZnamkaVnos = new JTextField(15);
		tovornoPrevozenihVnos = new JTextField(10);
		tovornoKapacitetaVnos = new JTextField(10);
		tovornoNosilnostVnos = new JTextField(10);
		tovornoGorivoVnos = new JTextField(15);
	
		osebnaTabela = new TransportiOsebniTableModel();
		minibusTabela = new TransportiMinibusTableModel();
		tovornaTabela = new TransportiTovorniTableModel();
	
		tabelaOsebna = new JTable(osebnaTabela);
		tabelaMinibus = new JTable(minibusTabela);
		tabelaTovorna = new JTable(tovornaTabela);
	
		// Ustvarimo panele za tabele in gumbe
		JPanel tablesPanel = new JPanel(new GridLayout(3, 1));
		JPanel buttonsPanel = new JPanel(new BorderLayout());
	
		// Dodamo glave tabel
		JLabel osebnaHeader = new JLabel("Osebna vozila", SwingConstants.CENTER);
		JLabel tovornaHeader = new JLabel("Tovorna vozila", SwingConstants.CENTER);
	
		// Nastavimo pisavo za glave tabel
		Font headerFont = new Font("Arial", Font.BOLD, 16);
		osebnaHeader.setFont(headerFont);
		tovornaHeader.setFont(headerFont);
	
		// Sekcija osebnih vozil
		JPanel osebnaPanel = new JPanel(new BorderLayout());
		osebnaPanel.add(osebnaHeader, BorderLayout.NORTH);
		osebnaPanel.add(createOsebnoPanel(), BorderLayout.CENTER);
		tablesPanel.add(new JScrollPane(tabelaOsebna));
	
		// Sekcija minibusov
		JPanel minibusPanel = new JPanel(new BorderLayout());
		minibusPanel.add(createMinibusPanel(), BorderLayout.CENTER);
		tablesPanel.add(new JScrollPane(tabelaMinibus));
	
		// Sekcija tovornih vozil
		JPanel tovornoPanel = new JPanel(new BorderLayout());
		tovornoPanel.add(tovornaHeader, BorderLayout.NORTH);
		tovornoPanel.add(createTovornoPanel(), BorderLayout.CENTER);
		tablesPanel.add(new JScrollPane(tabelaTovorna));
	
		// Dodamo sekcije v buttonsPanel
		buttonsPanel.add(osebnaPanel, BorderLayout.NORTH);
		buttonsPanel.add(minibusPanel, BorderLayout.CENTER);
		buttonsPanel.add(tovornoPanel, BorderLayout.SOUTH);
		add(tablesPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.EAST);
	
		// Naredimo okno vidno
		setVisible(true);
	}
	
	// Ustvari panel za osebna vozila
	private JPanel createOsebnoPanel() {
		JPanel osebnoPanel = new JPanel(new GridBagLayout());
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		osebnoPanel.add(new JLabel("Znamka"), gbc);
		gbc.gridx = 1;
		osebnoPanel.add(osebnoZnamkaVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 1;
		osebnoPanel.add(new JLabel("Prevoženih kilometrov"), gbc);
		gbc.gridx = 1;
		osebnoPanel.add(osebnoPrevozenihVnos, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 2;
		osebnoPanel.add(dodajOsebnoButton, gbc);
	
		return osebnoPanel;
	}
	
	// Ustvari panel za minibus vozila
	private JPanel createMinibusPanel() {
		JPanel minibusPanel = new JPanel(new GridBagLayout());
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
	
		// Dodamo oznako "Minibus vozila" na sredino nad vnosna polja
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2; // Raztegne čez dva stolpca
		JLabel minibusLabel = new JLabel("Minibus vozila", SwingConstants.CENTER);
		minibusLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Nastavimo pisavo Arial bold 16
		minibusPanel.add(minibusLabel, gbc);
		gbc.gridwidth = 1; // Ponastavi širino za naslednje komponente
	
		gbc.gridx = 0;
		gbc.gridy = 1;
		minibusPanel.add(new JLabel("Znamka"), gbc);
		gbc.gridx = 1;
		minibusPanel.add(minibusZnamkaVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 2;
		minibusPanel.add(new JLabel("Vrsta goriva"), gbc);
		gbc.gridx = 1;
		minibusPanel.add(minibusGorivoVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 3;
		minibusPanel.add(new JLabel("Prevoženih kilometrov"), gbc);
		gbc.gridx = 1;
		minibusPanel.add(minibusPrevozenihVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 4;
		minibusPanel.add(new JLabel("Število sedežev"), gbc);
		gbc.gridx = 1;
		minibusPanel.add(minibusSedezevVnos, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 5;
		minibusPanel.add(dodajMinibusButton, gbc);
	
		return minibusPanel;
	}
	
	// Ustvari panel za tovorna vozila
	private JPanel createTovornoPanel() {
		JPanel tovornoPanel = new JPanel(new GridBagLayout());
	
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
	
		gbc.gridx = 0;
		gbc.gridy = 0;
		tovornoPanel.add(new JLabel("Znamka"), gbc);
		gbc.gridx = 1;
		tovornoPanel.add(tovornoZnamkaVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 1;
		tovornoPanel.add(new JLabel("Vrsta goriva"), gbc);
		gbc.gridx = 1;
		tovornoPanel.add(tovornoGorivoVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 2;
		tovornoPanel.add(new JLabel("Prevoženih kilometrov"), gbc);
		gbc.gridx = 1;
		tovornoPanel.add(tovornoPrevozenihVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 3;
		tovornoPanel.add(new JLabel("Kapaciteta (m3)"), gbc);
		gbc.gridx = 1;
		tovornoPanel.add(tovornoKapacitetaVnos, gbc);
	
		gbc.gridx = 0;
		gbc.gridy = 4;
		tovornoPanel.add(new JLabel("Nosilnost (t)"), gbc);
		gbc.gridx = 1;
		tovornoPanel.add(tovornoNosilnostVnos, gbc);
	
		gbc.gridx = 1;
		gbc.gridy = 5;
		tovornoPanel.add(dodajTovornoButton, gbc);
	
		return tovornoPanel;
	}

@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dodajOsebnoButton) {
			String znamka = osebnoZnamkaVnos.getText();
			int prevozenih = Integer.parseInt(osebnoPrevozenihVnos.getText());
			OsebnoVozilo osebnoVozilo = new OsebnoVozilo(znamka, prevozenih);
			osebnaTabela.addOsebnoVozilo(osebnoVozilo);
		} else if (e.getSource() == dodajMinibusButton) {
			String znamka = minibusZnamkaVnos.getText();
			int prevozenih = Integer.parseInt(minibusPrevozenihVnos.getText());
			int sedezev = Integer.parseInt(minibusSedezevVnos.getText());
			String gorivo = minibusGorivoVnos.getText();
			MinibusVozilo minibusVozilo = new MinibusVozilo(znamka, prevozenih, sedezev, gorivo);
			minibusTabela.addMinibusVozilo(minibusVozilo);
		} else if (e.getSource() == dodajTovornoButton) {
			String znamka = tovornoZnamkaVnos.getText();
			int prevozenih = Integer.parseInt(tovornoPrevozenihVnos.getText());
			double kapaciteta = Double.parseDouble(tovornoKapacitetaVnos.getText());
			double nosilnost = Double.parseDouble(tovornoNosilnostVnos.getText());
			String gorivo = tovornoGorivoVnos.getText();
			TovornoVozilo tovornoVozilo = new TovornoVozilo(znamka, prevozenih, kapaciteta, nosilnost, gorivo);
			tovornaTabela.addTovornoVozilo(tovornoVozilo);
		}
	}
}

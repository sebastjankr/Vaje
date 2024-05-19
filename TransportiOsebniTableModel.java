/**
 * OsebnoVozilo.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */
 
 /**
 * Javni razred za strukturo tabele za osebna vozila
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
 public class TransportiOsebniTableModel extends TransportiTableModel {


	/** Javni konstruktor za ustvarjanje novega modela tabele za osebna vozila
	 */
    public TransportiOsebniTableModel() {
        super("osebno");
    }

	/** Javna metoda, ki doda vnose v vrstico
	 * @param ov Objekt osebno vozilo
	 */
	public void addOsebnoVozilo(OsebnoVozilo ov) {
        Object[] vrstica = new Object[]{ov.getZnamka(), "osebno", ov.getPrevozeno()};
        addRow(vrstica);
    }
}

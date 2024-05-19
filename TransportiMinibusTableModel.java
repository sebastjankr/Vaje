/**
 * OsebnoVozilo.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */
 
 /**
 * Javni razred za strukturo tabele za minibus vozila
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class TransportiMinibusTableModel extends TransportiTableModel {

	/** Javni konstruktor za ustvarjanje novega modela tabele za minibus vozila
	 */
    public TransportiMinibusTableModel() {
        super("minibus");
    }

	/** Javna metoda, ki doda vnose v vrstico
	 * @param mv Objekt minibus vozilo
	 */
    public void addMinibusVozilo(MinibusVozilo mv) {
        Object[] vrstica = new Object[]{mv.getZnamka(), "minibus", mv.getVrstaGoriva(), mv.getPrevozeno(), mv.getSedezi()};
        addRow(vrstica);
    }
}

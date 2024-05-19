/**
 * OsebnoVozilo.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */
 
 /**
 * Javni razred za strukturo tabele za tovorna vozila
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class TransportiTovorniTableModel extends TransportiTableModel {

	/** Javni konstruktor za ustvarjanje novega modela tabele za tovorna vozila
	 */
    public TransportiTovorniTableModel() {
        super("tovorno");
    }

	/** Javna metoda, ki doda vnose v vrstico
	 * @param tv Objekt tovorno vozilo
	 */
    public void addTovornoVozilo(TovornoVozilo tv) {
        Object[] vrstica = new Object[]{tv.getZnamka(), "tovorno", tv.getVrstaGoriva(), tv.getPrevozeno(), tv.getKapaciteta(), tv.getNosilnost()};
        addRow(vrstica);
    }
}

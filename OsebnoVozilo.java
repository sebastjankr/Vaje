/**
 * OsebnoVozilo.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */
 
 /**
 * Javni razred za uporabo metod osebnega vozila
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class OsebnoVozilo {
 
	// Deklaracija zasebnih lastnosti
	private String znamka;
    private int prevozenih;

	// Javna metoda, ki vrne znamko vozila in število prevoženih kilometrov
    public OsebnoVozilo(String znamka, int prevozenih) {
        this.znamka = znamka;
        this.prevozenih = prevozenih;
    }
	
	// Javna metoda, ki vrne znamko vozila
    public String getZnamka() {
        return znamka;
    }

	// Javna metoda, ki vrne število prevoženih kilometrov
    public int getPrevozeno() {
        return prevozenih;
    }
}

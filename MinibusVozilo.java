/**
 * MinibusVozilo.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */
 
 /**
 * Javni razred za uporabo metod minibus vozila
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class MinibusVozilo {

	// Deklaracija zasebnih lastnosti
    private String znamka;
    private int prevozenih;
    private int sedezi;
    private String vrstaGoriva;

    /**
     * Javna metoda, ki vrne znamko vozila, število prevoženih kilometrov, število sedežev in vrsto goriva
     * @param znamka znamka vozila
     * @param prevozenih število prevoženih kilometrov
     * @param sedezi število potniških sedežev
     * @param vrstaGoriva vrsta goriva
     */
    public MinibusVozilo(String znamka, int prevozenih, int sedezi, String vrstaGoriva) {
        this.znamka = znamka;
        this.prevozenih = prevozenih;
        this.sedezi = sedezi;
        this.vrstaGoriva = vrstaGoriva;
    }

	
    /**
     * Javna metoda, ki vrne znamko vozila
     * @return String getZnamka vrne znamko vozila
     */
    public String getZnamka() {
        return znamka;
    }

	
    /**
     * Javna metoda, ki vrne število prevoženih kilometrov
     * @return int getPrevozeno vrne število prevoženih kilometrov
     */
    public int getPrevozeno() {
        return prevozenih;
    }

	
    /**
     * Javna metoda, ki vrne število sedežev
     * @return int
     */
    public int getSedezi() {
        return sedezi;
    }

	
    
    /**
     * Javna metoda, ki vrne vrsto goriva
     * @return String getVrstaGoriva vrne vrsto goriva
     */
    public String getVrstaGoriva() {
        return vrstaGoriva;
    }
}

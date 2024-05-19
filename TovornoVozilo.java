/**
 * TovornoVozilo.java
 *
 * Opis:
 * Program, ki služi uporabi vozil z vmesnikom GUI
 *
 */
 
 /**
 * Javni razred za uporabo metod tovornih vozil
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class TovornoVozilo {

	// Deklaracija zasebnih lastnosti
    private String znamka;
    private int prevozenih;
    private double kapaciteta;
    private double nosilnost;
    private String vrstaGoriva;

	// Javna metoda, ki vrne znamko vozila, število prevoženih kilometrov, kapaciteto, nosilnost in vrsto goriva
    public TovornoVozilo(String znamka, int prevozenih, double kapaciteta, double nosilnost, String vrstaGoriva) {
        this.znamka = znamka;
        this.prevozenih = prevozenih;
        this.kapaciteta = kapaciteta;
        this.nosilnost = nosilnost;
        this.vrstaGoriva = vrstaGoriva;
    }

	// Javna metoda, ki vrne znamko vozila
    public String getZnamka() {
        return znamka;
    }

	// Javna metoda, ki vrne število prevoženih kilometrov
    public int getPrevozeno() {
        return prevozenih;
    }

	// Javna metoda, kapaciteto
    public double getKapaciteta() {
        return kapaciteta;
    }

	// Javna metoda, nosilnost
    public double getNosilnost() {
        return nosilnost;
    }

	// Javna metoda, vrsto goriva
    public String getVrstaGoriva() {
        return vrstaGoriva;
    }
}

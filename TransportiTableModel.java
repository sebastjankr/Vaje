/**
 * TransportiTableModel.java
 *
 * Opis:
 * Razred za vnos vozil v tabelo
 *
 */

// Uvozimo vse razrede in pakete za delo s tabelami
 import javax.swing.table.*;

/**
 * Javni razred za strukturo tabele vozil
 *
 * @author Sebastjan Kreže
 * @version Vaja 35
 */
public class TransportiTableModel extends DefaultTableModel {

    /** Javni konstruktor za ustvarjanje novega modela tabele osebnih vozil
     * @param vehicleType vrsta vozila
     */
    public TransportiTableModel(String vehicleType) {
        super();

        // Dodamo stolpce
        addColumn("Znamka");
        addColumn("Vrsta vozila");

        // Conditional columns based on vehicle type
        switch (vehicleType) {
            case "osebno":
                addColumn("Prevoženih kilometrov");
                // Ustvarimo prvi, testni seznam objektov za dodajanje v tabelo
                Object[] vrsticaOsebno = new Object[]{"Kia", "osebno", 12345};
                // Dodamo prvi, testni vnos (vrstico) v tabelo
                addRow(vrsticaOsebno);
                break;

            case "minibus":
                addColumn("Vrsta goriva");
                addColumn("Prevoženih kilometrov");
                addColumn("Število potniških sedežev");
                // Ustvarimo prvi, testni seznam objektov za dodajanje v tabelo
                Object[] vrsticaMinibus = new Object[]{"Ford", "minibus", "plin", 12345, 8};
                // Dodamo prvi, testni vnos (vrstico) v tabelo
                addRow(vrsticaMinibus);
                break;

            case "tovorno":
                addColumn("Vrsta goriva");
                addColumn("Prevoženih kilometrov");
                addColumn("Kapaciteta (m3)");
                addColumn("Nosilnost (t)");
                // Ustvarimo prvi, testni seznam objektov za dodajanje v tabelo
                Object[] vrsticaTovorno = new Object[]{"Volvo", "tovorno", "dizel", 123456, 80.0, 80.0};
                // Dodamo prvi, testni vnos (vrstico) v tabelo
                addRow(vrsticaTovorno);
                break;
        }
    }

    /** Javna metoda, ki doda osebno vozilo v tabelo
     * @param ov Objekt z osebnim vozilom, ki ga dodamo v tabelo
     */
    public void addVozilo(OsebnoVozilo ov) {
        // Ustvarimo seznam objektov za dodajanje v tabelo
        Object[] vrstica = new Object[]{ov.getZnamka(), "osebno", ov.getPrevozeno()};
        // Dodamo vrstico v tabelo
        addRow(vrstica);
    }

    /** Javna metoda, ki doda minibus vozilo v tabelo
     * @param mv Objekt z minibus vozilom, ki ga dodamo v tabelo
     */
    public void addMinibusVozilo(MinibusVozilo mv) {
        // Ustvarimo seznam objektov za dodajanje v tabelo
        Object[] vrstica = new Object[]{mv.getZnamka(), "minibus", mv.getVrstaGoriva(), mv.getPrevozeno(), mv.getSedezi()};
        // Dodamo vrstico v tabelo
        addRow(vrstica);
    }

    /** Javna metoda, ki doda tovorno vozilo v tabelo
     * @param tv Objekt s tovornim vozilom, ki ga dodamo v tabelo
     */
    public void addTovornoVozilo(TovornoVozilo tv) {
        // Ustvarimo seznam objektov za dodajanje v tabelo
        Object[] vrstica = new Object[]{tv.getZnamka(), "tovorno", tv.getVrstaGoriva(), tv.getPrevozeno(), tv.getKapaciteta(), tv.getNosilnost()};
        // Dodamo vrstico v tabelo
        addRow(vrstica);
    }
}

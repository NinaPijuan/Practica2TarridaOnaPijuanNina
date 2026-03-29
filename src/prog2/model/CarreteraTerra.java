package prog2.model;

/**
 * Representa una carretera de terra del càmping.
 * Aquest tipus d'accés SÍ permet accessibilitat amb vehicle.
 */
public class CarreteraTerra extends AccesTerra {
    private float amplada;

    /**
     * Constructor
     *
     * @param nom nom de l'accés
     * @param estat estat inicial de l'accés (true = obert, false = tancat)
     * @param longitud longitud de la carretera en metres
     * @param amplada amplada de la carretera en metres
     */
    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb vehicle.
     * Les carreteres de terra SÍ permeten accessibilitat.
     *
     * @return true sempre (permet accessibilitat)
     */
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * Obté l'amplada de la carretera.
     *
     * @return amplada en metres
     */
    public float getAmplada() {
        return amplada;
    }

    /**
     * Estableix l'amplada de la carretera.
     *
     * @param amplada nova amplada en metres
     */
    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    /**
     * Retorna una representació en String de la carretera de terra.
     *
     * @return String amb el nom, tipus, longitud, amplada, accessibilitat i allotjaments connectats
     */
    @Override
    public String toString() {

        String acces = isAccessibilitat() ? "Sí" : "No";

        String allotjaments = "";

        int midaLlista = getAAllotjaments().getLlistaAllotjaments().size();

        if (midaLlista == 0) allotjaments = "Cap";
        else {
            for (int i = 0; i < midaLlista; i++) {
                allotjaments += getAAllotjaments().getLlistaAllotjaments().get(i).getId();
                if (i != midaLlista - 1) allotjaments += ", ";
            }
        }
        return super.toString() + ", Tipus: Carretera de terra, Longitud: " + getLongitud() + "metres, Amplada: "
                + amplada + " metres, Accessibilitat: " + acces + ", Allotjaments: " + allotjaments + ".";
    }
}


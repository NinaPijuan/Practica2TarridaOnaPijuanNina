package prog2.model;

/**
 * Representa una carretera asfaltada del càmping.
 * Aquest tipus d'accés SÍ permet accessibilitat amb vehicle.
 */
public class CarreteraAsfaltada extends AccesAsfalt {

    private float pesMax;

    /**
     * Constructor
     *
     * @param nom nom de l'accés
     * @param estat estat inicial de l'accés (true = obert, false = tancat)
     * @param m2Asfalt metres quadrats d'asfalt de la carretera
     * @param pesMax pes màxim en kg que pot suportar la carretera
     */
    public CarreteraAsfaltada(String nom, boolean estat, float m2Asfalt, float pesMax) {
        super(nom, estat, m2Asfalt);
        this.pesMax = pesMax;
    }

    /**
     * Retorna si l'accés permet accessibilitat amb vehicle.
     * Les carreteres asfaltades SÍ permeten accessibilitat.
     *
     * @return true sempre (permet accessibilitat)
     */
    public boolean isAccessibilitat() {
        return true;
    }

    /**
     * Obté el pes màxim permès a la carretera.
     *
     * @return pes màxim en kg
     */
    public float getPesMax() {
        return pesMax;
    }

    /**
     * Estableix el pes màxim permès a la carretera.
     *
     * @param pesMax nou pes màxim en kg
     */
    public void setPesMax(float pesMax) {
        this.pesMax = pesMax;
    }

    /**
     * Retorna una representació en String de la carretera asfaltada.
     *
     * @return String amb el nom, tipus, metres quadrats, pes màxim, accessibilitat i allotjaments connectats
     */
    @Override
    public String toString() {

        String acces = isAccessibilitat() ? "Sí" : "No";

        String allotjaments = "";

        int midaLlista = getAAllotjaments().getLlistaAllotjaments().size();

        if (midaLlista == 0) allotjaments = "Cap";
        else {
            for(int i = 0; i < midaLlista; i++) {
                allotjaments += getAAllotjaments().getLlistaAllotjaments().get(i).getId();
                if (i != midaLlista - 1) allotjaments += ", ";
            }
        }
        return super.toString() + ", Tipus: Carretera asfaltada, Metres quadrats: " + getM2Asfalt() +
                "m2, Pes màxim: " + pesMax + "kg, Accessibilitat: " + acces + ", Allotjaments: " + allotjaments + ".";
    }
}

package prog2.model;

/**
 * Representa un camí asfaltat del càmping.
 * Aquest tipus d'accés NO permet accessibilitat amb vehicle.
 */
public class CamiAsfaltat extends AccesAsfalt {

    /**
     * Constructor
     *
     * @param nom nom de l'accés
     * @param estat estat inicial de l'accés (true = obert, false = tancat)
     * @param m2Asfalt metres quadrats d'asfalt del camí
     */
    public CamiAsfaltat(String nom, boolean estat, float m2Asfalt) {
        super(nom, estat, m2Asfalt); }

    /**
     * Retorna si l'accés permet accessibilitat amb vehicle.
     * Els camins asfaltats NO permeten accessibilitat.
     *
     * @return false sempre (no permet accessibilitat)
     */
    public boolean isAccessibilitat() {
        return false;
    }

    /**
     * Retorna una representació en String del camí asfaltat.
     *
     * @return String amb el nom, tipus, metres quadrats, accessibilitat i allotjaments connectats
     */
    @Override
    public String toString(){

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

        return super.toString() + ", Tipus: Camí asfaltat, Metres quadrats: " + getM2Asfalt() + " metres, Accessibilitat: " + acces
                + ", Allotjaments: " + allotjaments + ".";
    }
}

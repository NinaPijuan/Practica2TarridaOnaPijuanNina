package prog2.model;

/**
 * Representa un camí de terra del càmping.
 * Aquest tipus d'accés NO permet accessibilitat amb vehicle.
 */
public class CamiTerra extends AccesTerra {

    /**
     * Constructor
     *
     * @param nom nom de l'accés
     * @param estat estat inicial de l'accés (true = obert, false = tancat)
     * @param longitud longitud del camí en metres
     */
    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, longitud);
    }

    /**
     * Retorna una representació en String del camí de terra.
     *
     * @return String amb el nom, tipus, longitud, accessibilitat i allotjaments connectats
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
        return super.toString() + ", Tipus: Camí de terra, Longitud: " + getLongitud() + ", Accessibilitat: "
                + acces + ", Allotjaments: " + allotjaments + ".";

    }

    /**
     * Retorna si l'accés permet accessibilitat amb vehicle.
     * Els camins de terra NO permeten accessibilitat.
     *
     * @return false sempre (no permet accessibilitat)
     */
    public boolean isAccessibilitat() {
        return false;
    }
}

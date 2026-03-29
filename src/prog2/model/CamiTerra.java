package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, boolean estat, float longitud) {

        super(nom, estat, longitud);
    }

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

    public boolean isAccessibilitat() {
        return false;
    }
}

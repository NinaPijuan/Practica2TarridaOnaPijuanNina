package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, boolean estat, float longitud) {

        super(nom, estat, longitud);
    }

    @Override
    public String toString(){

        String acces = isAccessibilitat() ? "Sí" : "No";

        String allotjaments = "";
        for(int i = 0; i < getAAllotjaments().getLlistaAllotjaments().size(); i++){
            allotjaments += getAAllotjaments().getLlistaAllotjaments().get(i).getNom();
            allotjaments += " ";
        }
        return super.toString() + "Tipus: Camí de terra, Longitud: " + getLongitud() + ", Accessibilitat: "
                + acces + ", Allotjaments: " + allotjaments + ".";

    }

    public boolean isAccessibilitat() {
        return false;
    }
}

package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean estat, float m2Asfalt) {

        super(nom, estat, m2Asfalt); }

    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString(){

        String acces = isAccessibilitat() ? "Sí" : "No";

        String allotjaments = "";

        for(int i = 0; i < getAAllotjaments().getLlistaAllotjaments().size(); i++){
            allotjaments += getAAllotjaments().getLlistaAllotjaments().get(i).getNom();
            allotjaments += " ";
        }

        return super.toString() + "Tipus: Camí asfaltat, Metres quadrats: " + getM2Asfalt() + ", Accessibilitat: " + acces
                + ", Allotjaments: " + allotjaments + ".";
    }
}

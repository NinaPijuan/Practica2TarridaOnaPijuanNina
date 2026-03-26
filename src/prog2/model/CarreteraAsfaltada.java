package prog2.model;

public class CarreteraAsfaltada extends AccesAsfalt {

    private float pesMax;

    public CarreteraAsfaltada(String nom, boolean estat, float m2Asfalt, float pesMax) {
        super(nom, estat, m2Asfalt);
        this.pesMax = pesMax;
    }

    public boolean isAccessibilitat() {
        return true;
    }

    public float getPesMax() {
        return pesMax;
    }

    public void setPesMax(float pesMax) {
        this.pesMax = pesMax;
    }

    @Override
    public String toString() {

        String acces = isAccessibilitat() ? "Sí" : "No";

        String allotjaments = "";
        for(int i = 0; i < getAAllotjaments().getLlistaAllotjaments().size(); i++){
            allotjaments += getAAllotjaments().getLlistaAllotjaments().get(i).getNom();
            allotjaments += " ";
        }
        return super.toString() + "Tipus: Carretera asfaltada, Metres quadrats: " + getM2Asfalt() +
                ", Pes màxim: " + pesMax + ", Accessibilitat: " + acces + ", Allotjaments: " + allotjaments + ".";
    }
}

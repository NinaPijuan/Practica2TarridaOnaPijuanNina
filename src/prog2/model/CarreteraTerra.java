package prog2.model;

public class CarreteraTerra extends AccesTerra {
    private float amplada;

    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, estat, longitud);
        this.amplada = amplada;
    }

    public boolean isAccessibilitat() {
        return true;
    }

    public float getAmplada() {
        return amplada;
    }

    public void setAmplada(float amplada) {
        this.amplada = amplada;
    }

    @Override
    public String toString() {

            String acces = isAccessibilitat() ? "Sí" : "No";

            String allotjaments = "";


            for(int i = 0; i < getAAllotjaments().getLlistaAllotjaments().size(); i++){
                allotjaments += getAAllotjaments().getLlistaAllotjaments().get(i).getNom();
                allotjaments += " ";
            }
            return super.toString() + "Tipus: Carretera de terra, Longitud: " + getLongitud() + ", Amplada: "
                    + amplada + " metres, Accessibilitat: " + acces + ", Allotjaments: " + allotjaments + ".";
        }
    }


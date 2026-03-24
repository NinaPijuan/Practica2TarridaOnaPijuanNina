package prog2.model;

public class CarreteraTerra extends AccesTerra {
    private float amplada;

    public CarreteraTerra(String nom, boolean accesibilitat, float longitud, float amplada) {
        super(nom, accesibilitat, longitud);
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
        return super.toString(); // Afegir
    }
}

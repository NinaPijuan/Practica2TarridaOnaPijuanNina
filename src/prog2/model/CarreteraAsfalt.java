package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {
    private float pesMax;

    public CarreteraAsfalt(String nom, boolean accesibilitat, float m2Asfalt, float pesMax) {
        super(nom, accesibilitat, m2Asfalt);
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
        return super.toString(); // Afegir
    }
}

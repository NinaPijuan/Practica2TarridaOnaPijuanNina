package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean accesibilitat, float m2Asfalt) {
        super(nom, accesibilitat, m2Asfalt);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}

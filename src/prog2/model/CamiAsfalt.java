package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, boolean estat, float m2Asfalt) {
        super(nom, estat, m2Asfalt);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}

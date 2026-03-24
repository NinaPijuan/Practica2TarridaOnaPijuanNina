package prog2.model;

public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, boolean accesibilitat, float longitud) {
        super(nom, accesibilitat, longitud);
    }

    public boolean isAccessibilitat() {
        return false;
    }
}

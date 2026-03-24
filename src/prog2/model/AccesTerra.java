package prog2.model;

public abstract class AccesTerra extends Acces {
    float longitud;

    public AccesTerra(String nom, boolean accesibilitat, float longitud) {
        super(nom, accesibilitat);
        this.longitud = longitud;
    }
}

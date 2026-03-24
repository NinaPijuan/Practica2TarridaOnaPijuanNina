package prog2.model;

public abstract class AccesTerra extends Acces {
    float longitud;

    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }
}

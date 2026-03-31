package prog2.model;

public abstract class AccesTerra extends Acces {
    float longitud;

    /**
     * Constructor
     * @param nom
     * @param estat
     * @param longitud
     */
    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    /**
     * Retorna la longitud en metres
     * @return longitud
     */
    public float getLongitud() { return longitud; }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     */
    public abstract boolean isAccessibilitat();
}


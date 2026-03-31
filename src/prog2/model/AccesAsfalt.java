package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float m2Asfalt;

    public AccesAsfalt(String nom, boolean estat, float m2Asfalt) {
        super(nom, estat);
        this.m2Asfalt = m2Asfalt;
    }

    /**
     * Retorna els metres quadrats d'asfalt
     *
     * @return m2Asfalt
     */
    public float getM2Asfalt(){ return m2Asfalt; }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     */
    public abstract boolean isAccessibilitat();
}




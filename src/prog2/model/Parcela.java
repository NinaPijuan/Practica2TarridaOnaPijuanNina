package prog2.model;

public class Parcela extends Allotjament {

    private float mida; // en m2
    private boolean connexioElectrica;

    /**
     * Constructor amb paràmetres
     * @param nom
     * @param id
     * @param mida
     * @param connexioElectrica
     */
    public Parcela(String nom, String id, boolean operatiu, String iluminacio, float mida, boolean connexioElectrica){
        super(nom, id, 4, 2, operatiu, iluminacio);
        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    /**
     * Obté la mida
     * @return mida
     */
    public float getMida(){ return mida; }

    /**
     * Guarda la mida
     * @param mida
     */
    public void setMida(float mida){ this.mida = mida; }

    /**
     * Obté l'electricitat
     * @return connexioElectrica
     */
    public boolean getConnexioElectrica(){ return connexioElectrica; }
    // El mateix que isConnexioElectrica()

    /**
     * Guarda l'electricitat
     * @param connexioElectrica
     */
    public void setConnexioElectrica(boolean connexioElectrica){ this.connexioElectrica = connexioElectrica; }

    /**
     * Obté tota la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString() + " Parcela{mida= " +
                mida + ", connexio electrica= " +
                connexioElectrica + "}";
    }

    /**
     * Obté l'electricitat
     * @return connexioElectrica
     */
    public boolean isConnexioElectrica() { return connexioElectrica;}
}

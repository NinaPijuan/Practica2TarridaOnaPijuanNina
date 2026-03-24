package prog2.model;

// ELS DOS ÚLTIMS MÈTODES JA ESTAN A ALLOTJAMENT, ELS PODEM TREURE D'AKUÍ, NO?
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
     * Una parcel·la té un funcionament correcte si té punt de connexió elèctrica
     * @return true si té electricitat, false si no
     */
    /* @Override
    public boolean correcteFuncionament(){
        return connexioElectrica;
    }

     */

    /**
     * Obté tota la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString();
    }

    /**
     * Obté l'electricitat
     * @return connexioElectrica
     */
    public boolean isConnexioElectrica() { return connexioElectrica;}

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la tasca rebuda com a paràmetre
     *
     * @param tasca Objecte de tipus TascaManteniment.
     */
    @Override
    public void tancarAllotjament(TascaManteniment tasca) {



    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    @Override
    public void obrirAllotjament() {

    }
}

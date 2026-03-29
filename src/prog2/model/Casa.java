package prog2.model;


abstract class Casa extends Allotjament {

    private float mida; // m2
    private int numHab;
    private int capacitat;

    /**
     * Constructor amb paràmetres
     * @param nom
     * @param id
     * @param mida
     * @param numHab
     * @param capacitat
     */
    public Casa(String nom, String id, int tempsMinAlta, int tempsMinBaixa, boolean operatiu, String iluminacio, float mida, int numHab, int capacitat){
        super(nom, id, tempsMinAlta, tempsMinBaixa, operatiu, iluminacio);
        this.mida = mida;
        this.numHab = numHab;
        this.capacitat = capacitat;
    }

    /**
     * Obté la mida de la casa
     * @return 1: petita, 2: mitjana, 3: gran
     */
    public float getMida(){ return mida; }

    /**
     * Guarda la mida
     * @param mida
     */
    public void setMida(float mida){ this.mida = mida; }

    /**
     * Obté el número d'habitacions
     * @return número d'habitacions
     */
    public int getNumHab() { return numHab; }

    /**
     * Guarda el número d'habitacions
     * @param numHab
     */
    public void setNumHab(int numHab) { this.numHab = numHab; }

    /**
     * Obté la quantitat de persones que hi caben
     * @return capacitat
     */
    public int getCapacitat() { return capacitat; }

    /**
     * Guarda la capacitat de persones
     * @param capacitat
     */
    public void setCapacitat(int capacitat) { this.capacitat = capacitat; }

    public abstract boolean correcteFuncionament();


    /**
     * Retorna tota la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString() + " Casa{mida= " +
                mida + ", número habitacions= " +
                numHab + ", capacitat= " + capacitat;
    }
}
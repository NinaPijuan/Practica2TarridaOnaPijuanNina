package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassa;

    /**
     * Constructor amb paràmetres
     * @param nom
     * @param id
     * @param mida
     * @param numHab
     * @param capacitat
     * @param terrassa
     */
    public MobilHome(String nom, String id, boolean operatiu, String iluminacio, float mida, int numHab, int capacitat, boolean terrassa) {
        super(nom, id, 5, 3, operatiu, iluminacio, mida, numHab, capacitat);
        this.terrassa = terrassa;
    }

    /**
     * Getter i setter de terrassa amb barbacoa
     */
    public boolean getTerrassa(){ return terrassa; }
    public void setTerrassa(boolean terrassa){ this.terrassa = terrassa; }

    /**
     * Obté tota la informació sobre la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString() + " Mobil-Home{Terrassa amb barbacoa= " + terrassa + " .";
    }

    /**
     * Una Mobil-Home funciona bé si té terrassa amb barbacoa
     * @return true si en té, false si no
     */
    @Override
    public boolean correcteFuncionament(){
        return terrassa;
    }


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

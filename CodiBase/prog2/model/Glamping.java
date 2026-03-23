package prog2.model;

public class Glamping extends Casa {
    private String material; // tela o fusta
    private boolean casaMascota;

    /**
     * Constructor amb paràmetres
     * @param nom
     * @param id
     * @param mida
     * @param numHab
     * @param capacitat
     * @param material
     * @param casaMascota
     */
    public Glamping(String nom, String id, String mida, int numHab, int capacitat, String material, boolean casaMascota){
        super(nom, id, 3, 3, mida, numHab, capacitat);
        this.material = material;
        this.casaMascota = casaMascota;
    }

    /**
     * Getters de tipus de material i casa de mascotes
     */
    public String getMaterial(){ return material; }
    public boolean getCasaMascota(){ return casaMascota; }

    /**
     * Setters de tipus de material i casa de mascotes
     */
    public void setMaterial(String material) {
        if (material.equalsIgnoreCase("fusta") || material.equalsIgnoreCase("tela"))
            this.material = material;
        else System.out.println("Material incorrecte");
    }
    public void setCasaMascota(boolean casaMascota){ this.casaMascota = casaMascota; }


    /**
     * Obté tota la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString() + " Glamping{material=" + material + ", casa per mascotes= "
                + casaMascota + " .";
    }
    /**
     * Un glamping funciona bé si té casa per mascotes
     * @return true si en té, false si no
     */
    @Override
    public boolean correcteFuncionament(){ return casaMascota; }


}

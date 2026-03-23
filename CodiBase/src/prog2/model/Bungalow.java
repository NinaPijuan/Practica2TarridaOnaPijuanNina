package prog2.model.prog2.model;


import prog2.model.prog2.Casa;

public class Bungalow extends Casa {

    private int parquing; // 1 o 2
    private boolean terrassa;
    private boolean tele;
    private boolean aire;

    /**
     * Constructor amb paràmetres
     * @param nom
     * @param id
     * @param mida
     * @param numHab
     * @param capacitat
     * @param parquing
     * @param terrassa
     * @param tele
     * @param aire
     */
    public Bungalow(String nom, String id, String mida, int numHab, int capacitat, int parquing, boolean terrassa, boolean tele, boolean aire){
        super(nom, id, 7, 4, mida, numHab, capacitat);
        this.parquing = parquing;
        this.terrassa = terrassa;
        this.tele = tele;
        this.aire = aire;
    }

    /**
     * Getters de places de parquing, terrassa, televisió i sistema d'aire fred
     */
    public int getPark(){ return parquing; }
    public boolean getTerrassa(){ return terrassa; }
    public boolean getTele(){ return tele; }
    public boolean getAire(){ return aire; }

    /**
     * Setters de places de parquing, terrassa, televisió i sistema d'aire fred
     */
    public void setParquing(int park){ this.parquing = parquing; }
    public void setTerrassa(boolean terrassa){ this.terrassa = terrassa; }
    public void setTele(boolean tele){ this.tele = tele; }
    public void setAire(boolean aire){ this.aire = aire; }

    /**
     * Obté tota la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString() + ". Bungalow{places de parking= "
                + parquing + ", terrassa= " + terrassa + ",tele= " + tele
                + ", aire= " + aire + ".";
    }

    /**
     * Un bungalow té un funcionament correcte si té aire fred
     * @return true si en té, false si no
     */
    @Override
    public boolean correcteFuncionament(){ return aire; }

}

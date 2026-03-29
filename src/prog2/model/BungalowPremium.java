package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String wifi;

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
     * @param serveisExtra
     * @param wifi
     */
    public BungalowPremium(String nom, String id, boolean operatiu, String iluminacio, float mida, int numHab, int capacitat, int parquing, boolean terrassa, boolean tele, boolean aire, boolean serveisExtra, String wifi){
       super(nom, id, operatiu, iluminacio, mida, numHab, capacitat, parquing, terrassa, tele, aire);
       this.serveisExtra = serveisExtra;
       this.wifi = wifi;
    }

    /**
     * Getters de llençols, tovalloles i clau del wifi
     */
    public boolean getServeisExtra(){ return serveisExtra; }
    public String getWifi(){ return wifi; }

    /**
     * Setters de llençols, tovalloles i clau del wifi
     */
    public void setServeisExtra(boolean serveisExtra){ this.serveisExtra = serveisExtra; }
    public void setWifi(String wifi){ this.wifi = wifi; }


    /**
     * Obté la informació de la classe
     * @return un string
     */
    @Override
    public String toString(){
        return super.toString() + " Premium{Serveix extra= " + serveisExtra + ", clau del wifi= " + wifi + "}}";
    }


    /**
     * Un bungalow Prenium funciona bé si té aire i el seu codi wifi té entre 8 i 16 caràcters
     * @return true si sí, false si no
     */
    @Override
    public boolean correcteFuncionament(){
       boolean aire = super.correcteFuncionament();
       int caracters = wifi.length();
       return (aire && 8 <= caracters && caracters <= 16);
    }

}

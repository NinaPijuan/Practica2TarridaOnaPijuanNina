package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;

public abstract class Acces implements InAcces, Serializable {

    private String nom;
    private final boolean accessibilitat;
    private boolean estat; // obert o tancat
    private LlistaAllotjaments llistaAllotjaments;

    /**
     * Constructor
     * @param nom
     * @param estat
     */
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.accessibilitat = isAccessibilitat();
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    /**
     * toString
     * @return informació de l'Acces en format String
     */
    @Override
    public String toString(){
        return "Nom: " + nom;
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping{

        // Cridem al mètode de LlistaAllotjaments que fa aquesta feina
        // (a dins ja es comprova si l'allotjament ja està a la llista)
        llistaAllotjaments.afegirAllotjament(allotjament);
    }


    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() { this.estat = false; }


    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() { this.estat = true; }


    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return true o false depenent de cada accés
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return nom
     */
    @Override
    public String getNom() { return nom; }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return estat
     */
    @Override
    public boolean getEstat() { return estat; }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return llistaAllotjaments
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() { return llistaAllotjaments; }
}

package prog2.model;

import java.io.Serializable;

public abstract class Acces implements InAcces, Serializable {

    private String nom;
    private final boolean accessibilitat;
    private boolean estat; // obert o tancat
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.accessibilitat = isAccessibilitat();
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     *
     * @param allotjament
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    @Override
    public void tancarAcces() {

    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    @Override
    public void obrirAcces() {

    }

    /**
     * Retorna si l'accés permet accessibilitat amb cotxe o no.
     *
     * @return
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Retorna el nom de l'accés
     *
     * @return
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     *
     * @return
     */
    @Override
    public boolean getEstat() {
        return estat;
    }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     *
     * @return
     */
    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return null;
    }
}
